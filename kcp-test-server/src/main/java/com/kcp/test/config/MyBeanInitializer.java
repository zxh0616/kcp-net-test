package com.kcp.test.config;

import kcp.ChannelConfig;
import kcp.KcpServer;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyBeanInitializer implements SmartInitializingSingleton {

    @Autowired
    private KcpRttListener kcpRttListener;

    @Autowired
    private ChannelConfig channelConfig;

    // 执行应用程序启动时的初始化逻辑
    @Override
    public void afterSingletonsInstantiated() {

        //crc32校验  CRC32被用于校验数据完整性，特别是在网络传输、文件存储等领域
        //channelConfig.setCrc32Check(true);
        KcpServer kcpServer = new KcpServer();
        kcpServer.init(kcpRttListener, channelConfig,20003);
        System.out.println("服务初始化成功");
    }


}
