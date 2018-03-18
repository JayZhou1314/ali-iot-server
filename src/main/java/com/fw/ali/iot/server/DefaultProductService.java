package com.fw.ali.iot.server;

import com.aliyuncs.iot.model.v20170420.CreateProductResponse.ProductInfo;
import com.fw.ali.iot.AliIotClient;
import com.fw.ali.iot.AliIotConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultProductService extends ProductService {

    @Autowired
    protected DefaultProductService(AliIotClient iotClient) {
        super(iotClient);
    }

    public ProductInfo getDefaultProduct() {
        AliIotConfig config = getIotClient().getConfig();
        ProductInfo info = new ProductInfo();
        info.setProductKey(config.getProduct());
        return info;
    }
}
