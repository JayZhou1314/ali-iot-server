package com.fw.ali.iot.server;

import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.iot.model.v20170420.RegistDeviceRequest;
import com.aliyuncs.iot.model.v20170420.RegistDeviceResponse;
import com.fw.ali.iot.AliIotClient;
import com.fw.ali.iot.server.dto.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceService {

    @Autowired
    private AliIotClient aliIotClient;

    /**
     * 设备注册
     */
    public Device regist(String productKey, String deviceName) throws ClientException, IotException {
        RegistDeviceRequest req = new RegistDeviceRequest();
        req.setProductKey(productKey);
        req.setDeviceName(deviceName);
        RegistDeviceResponse res = aliIotClient.getClient().getAcsResponse(req);
        if (! res.getSuccess()) {
            throw new IotException(res.getErrorMessage());
        }
        Device device = new Device();
        device.setId(res.getDeviceId());
        device.setName(res.getDeviceName());
        device.setSecret(res.getDeviceSecret());
        device.setStatus(res.getDeviceStatus());
        return device;
    }

    /**
     * 批量申请设备
     */
    public void apply() {}

    /**
     * 查询产品的设备列表
     */
    public void queryDeviceByProduct() {}

    /**
     * 查询批量设备的申请状态
     */
    public void queryApplyStatus() {}

    /**
     * 查询批量生成的设备信息
     */
    public void queryPageByApplyId() {}
}
