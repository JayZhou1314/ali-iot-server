package com.fw.ali.iot;


import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class AliIotClient {

    @Getter
    private IClientProfile profile;
    @Getter
    private IAcsClient client;
    @Getter
    private AliIotConfig config;

    @Autowired
    public AliIotClient(AliIotConfig config) throws ClientException {
        this.config = config;
        init(config);
    }

    private void init(AliIotConfig config) throws ClientException {
        //"cn-shanghai", "cn-shanghai", "Iot", "iot.cn-shanghai.aliyuncs.com"
        DefaultProfile.addEndpoint(config.getEndPointName(), config.getRegionId(), config.getProduct(), config.getDomain());
        profile = DefaultProfile.getProfile(config.getRegionId(), config.getAccessKeyId(), config.getAccessKeySecret());
        client = new DefaultAcsClient(profile);
    }
}
