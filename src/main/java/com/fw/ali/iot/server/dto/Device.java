package com.fw.ali.iot.server.dto;

import lombok.Data;

@Data
public class Device {

    private String id;
    private String name;
    private String secret;
    private String status;

}
