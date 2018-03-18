package com.fw.ali.iot.server;

import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.iot.model.v20170420.CreateProductResponse.ProductInfo;
import com.fw.ali.iot.AliIotConfig;
import com.fw.ali.iot.IotServerConfig;
import com.fw.ali.iot.JsonUtils;
import com.fw.ali.iot.server.dto.Device;
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
public class DeviceServiceTest {

    @Autowired
    private DeviceService deviceService;
    @Autowired
    private AliIotConfig config;


    @Test
    public void testRegister() throws IOException, ClientException, IotException {
        Device device = deviceService.regist(config.getProduct(), "device_test_001");
        JsonUtils.getIns().toString(device);
    }
}
