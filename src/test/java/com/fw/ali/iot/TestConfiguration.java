package com.fw.ali.iot;

import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootApplication
@Configuration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {IotServerConfig.class})
public class TestConfiguration {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(com.fw.ali.iot.IotServerConfig.class, args);
    }
}
