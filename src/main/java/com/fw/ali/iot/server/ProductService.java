package com.fw.ali.iot.server;

import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.iot.model.v20170420.CreateProductRequest;
import com.aliyuncs.iot.model.v20170420.CreateProductResponse;
import com.aliyuncs.iot.model.v20170420.CreateProductResponse.ProductInfo;
import com.aliyuncs.iot.model.v20170420.UpdateProductRequest;
import com.aliyuncs.iot.model.v20170420.UpdateProductResponse;
import com.fw.ali.iot.AliIotClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private AliIotClient iotClient;

    /**
     * 创建产品
     * @param name 产品名称
     * @param desc 产品描述
     */
    public ProductInfo create(String name, String desc) throws ClientException, IotException {
        CreateProductRequest req = new CreateProductRequest();
        req.setName(name);
        req.setDesc(desc);
        CreateProductResponse res = iotClient.getClient().getAcsResponse(req);
        if (! res.getSuccess()) {
            throw new IotException(res.getErrorMessage());
        }
        return res.getProductInfo();
    }

    /**
     * 修改产品
     * @param key    作为需要更新产品的ID
     * @param catId  产品类型ID
     * @param name   产品名称
     * @param desc   产品描述
     */
    public void update(String key, Long catId, String name, String desc) throws ClientException, IotException {
        UpdateProductRequest req = new UpdateProductRequest();
        req.setProductKey(key);
        req.setCatId(catId);
        req.setProductName(name);
        req.setProductDesc(desc);
        UpdateProductResponse res = iotClient.getClient().getAcsResponse(req);
        if (! res.getSuccess()) {
            throw new IotException(res.getErrorMessage());
        }
    }

}
