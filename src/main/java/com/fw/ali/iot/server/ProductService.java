package com.fw.ali.iot.server;

import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.iot.model.v20170420.CreateProductRequest;
import com.aliyuncs.iot.model.v20170420.CreateProductResponse;
import com.aliyuncs.iot.model.v20170420.CreateProductResponse.ProductInfo;
import com.aliyuncs.iot.model.v20170420.QueryDeviceRequest;
import com.aliyuncs.iot.model.v20170420.QueryDeviceResponse;
import com.aliyuncs.iot.model.v20170420.QueryDeviceResponse.DeviceInfo;
import com.aliyuncs.iot.model.v20170420.UpdateProductRequest;
import com.aliyuncs.iot.model.v20170420.UpdateProductResponse;
import com.fw.ali.iot.AliIotClient;
import com.fw.ali.iot.server.dto.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class ProductService {

    private AliIotClient iotClient;

    protected ProductService(AliIotClient iotClient) {
        this.iotClient = iotClient;
    }

    protected AliIotClient getIotClient() {
        return iotClient;
    }

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

    /**
     * 查询产品的设备列表
     * @param product
     * @param pageSize
     * @param currentPage
     * @return
     * @throws ClientException
     * @throws IotException
     */
    public PageData<DeviceInfo> queryDevice(String product, Integer pageSize, Integer currentPage) throws ClientException, IotException {
        QueryDeviceRequest req = new QueryDeviceRequest();
        req.setProductKey(product);
        req.setPageSize(pageSize);
        req.setCurrentPage(currentPage);
        QueryDeviceResponse res = iotClient.getClient().getAcsResponse(req);
        if (!res.getSuccess()) {
            throw new IotException(res.getErrorMessage());
        }
        PageData<DeviceInfo> pageData = new PageData<>();
        pageData.setTotal(res.getTotal());
        pageData.setData(res.getData());
        return pageData;
    }

}
