package com.kcp.test.controller;

import com.kcp.test.entity.zego.ZegoRoomConfig;
import com.kcp.test.entity.zego.ZegoUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author: stem) Zjq
 * @Date: 11:04
 */

@RestController("/room")
public class ZegoExpressEngine {
    static final Logger logger = LoggerFactory.getLogger(ZegoExpressEngine.class);

    @PostMapping("/login")
    public void loginRoom(String roomID, ZegoUser user, ZegoRoomConfig config){

    }

    @PostMapping("/logout")
    public void logoutRoom(String roomID){

    }

    //@PostMapping("/stream/start")
    //public void startStream(){
    //    System.out.println("zego start streaming");
    //    String roomId =  "9999";
    //    String userId = "1111";
    //    //推流
    //    Ukcp publishingStreamUkcp = KcpRttListener.rooms.get(roomId).get(userId);
    //    ByteBuf buf = Unpooled.buffer(10);
    //    buf.writeInt(2);
    //    buf.writeBytes("9999".getBytes());
    //    publishingStreamUkcp.write(buf);
    //    logger.info("通知客户端【111】开始推流");
    //}

    @PostMapping("/stream/stop")
    public void stopStream(){

        System.out.println("zego stop stream");
    }

    //public  static ZegoExpressEngine createEngine(ZegoEngineProfile profile, IZegoEventHandler eventHandler){}


}
