package com.fw.ali.iot.server;

import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.iot.model.v20170420.CreateProductResponse.ProductInfo;
import com.fw.ali.iot.IotServerConfig;
import com.fw.ali.iot.JsonUtils;
import com.fw.ali.iot.server.dto.PageData;
import java.io.IOException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@SpringBootApplication
@ContextConfiguration(classes = {IotServerConfig.class})
public class ProductServiceTest {

    @Autowired
    private ProductService productService;


    @Test
    public void testCreateProduct() throws IOException, ClientException, IotException {
        ProductInfo info = productService.create("feeder_test", "feeder_test_desc");
        System.out.println(JsonUtils.getIns().toString(info));
    }

    @Test
    public void testQueryProductDevice() throws IOException, ClientException, IotException {
        PageData pageData = productService.queryDevice("Rqyhsbl7Kxo", 1, 1);
        JsonUtils.getIns().toString(pageData);
    }
}
