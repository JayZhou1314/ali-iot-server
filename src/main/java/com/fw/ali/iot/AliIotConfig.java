package com.fw.ali.iot;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class AliIotConfig {

    private String accessKeyId;
    private String accessKeySecret;
    private String endPointName;
    private String regionId;
    private String product;
    private String domain;

    /**
     * 初始化实例期间, 设置配置项的值.
     *
     * 配置值的获得方式可以为:
     * 远程服务
     * 配置文件
     * 数据库
     */
    public AliIotConfig() {
       //todo
    }
}
