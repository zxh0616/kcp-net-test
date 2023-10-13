package com.player.impl;

import cn.hutool.json.JSONUtil;
import com.player.ZegoExpressEngine;
import com.player.callback.IZegoEventHandler;
import com.player.constants.ZegoRoomStateChangedReason;
import com.player.entity.ZegoUser;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import kcp.ChannelConfig;
import kcp.KcpClient;
import kcp.KcpListener;
import kcp.Ukcp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Author: stem) Zjq
 * @Date: 14:11
 */

public class ZegoExpressEngineImpl extends ZegoExpressEngine implements KcpListener {

    static final Logger log = LoggerFactory.getLogger(ZegoExpressEngineImpl.class);

    private IZegoEventHandler handler;

    private Ukcp ukcp;

    public ZegoExpressEngineImpl(IZegoEventHandler handler){
        this.handler = handler;
        initConfig();
    }

    private void initConfig() {
        ChannelConfig channelConfig = new ChannelConfig();
        channelConfig.nodelay(true, 30, 2, true);
        channelConfig.setSndwnd(512);
        channelConfig.setRcvwnd(512);
        channelConfig.setMtu(100);
        channelConfig.setAckNoDelay(true);
        channelConfig.setAckMaskSize(8);
        //channelConfig.setStream(true);
        //channelConfig.setConv(111);
        //channelConfig.setFecAdapt(new FecAdapt(3,1));
        //channelConfig.setCrc32Check(true);
        channelConfig.setTimeoutMillis(100000);
        //channelConfig.setAckMaskSize(32);
        KcpClient kcpClient = new KcpClient();
        kcpClient.init(channelConfig);

        kcpClient.connect(new InetSocketAddress("127.0.0.1", 20003), channelConfig, this);
        //kcpClient.connect(new InetSocketAddress("10.60.100.191",20003),channelConfig,kcpClientRttExample);
    }

    @Override
    public void loginRoom(String roomID, ZegoUser user) {


        handler.onRoomStateChanged(roomID, ZegoRoomStateChangedReason.LOGINED, 0, null);
    }



    @Override
    public void onConnected(Ukcp ukcp) {
        log.info("连接成功-onConnected, 会话ID= {}, 客户端IP={}, 服务端IP= {}",  ukcp.getConv(), ukcp.user().getLocalAddress(), ukcp.user().getRemoteAddress());
        this.ukcp = ukcp;

        // ■ 登录房间【IKCP_CMD_LOGIN_ROOM】 1
        //ByteBuf byteBuf = Unpooled.buffer(10);
        //byteBuf.writeShort(1);
        //
        //HashMap<String, String> map = new HashMap<>();
        //map.put("roomId", "123");
        //map.put("userId", "456");
        //byteBuf.writeBytes(JSONUtil.toJsonStr(map).getBytes());
        //ukcp.write(byteBuf);
        //byteBuf.release();
    }

    /*
     * ■ 登录房间【IKCP_CMD_LOGIN_ROOM] 1
     * ■ 登录房间成功【IKCP_CMD_LOGIN_ROOM_success] 11
     * ■ 登出房间【IKCP_CMD_LOGOUT_ROOM] 2
     * ■ 登出房间成功【IKCP_CMD_LOGOUT_ROOM_success] 22
     *
     * */
    @Override
    public void handleReceive(ByteBuf buf, Ukcp ukcp) {
        int flag = buf.readShort();
        if (flag == 11) {
            log.info("开始拉流推流");
            ByteBuf buffer = Unpooled.buffer(10);
            buffer.writeShort(2);
            HashMap<String, String> map = new HashMap<>();
            map.put("roomId", "123");
            map.put("userId", "789");
            //map.put("ts", String.valueOf(System.currentTimeMillis() -startTime));
            map.put("data", "客户端A");
            buffer.writeBytes(JSONUtil.toJsonStr(map).getBytes());
            ukcp.write(buffer);
            buffer.release();

        }else if(flag ==22) {
            int readableBytes = buf.readableBytes();
            byte[] contentBytes = new byte[readableBytes];
            buf.readBytes(contentBytes);
            Map bean = JSONUtil.toBean(new String(contentBytes), Map.class);
            String data = (String) bean.get("data");
            //long ts = Long.parseLong((String) bean.get("ts"));

            //log.info("收到数据={}, 时间ts= {}", data, System.currentTimeMillis() -startTime -ts);
            log.info("收到数据={}", data);
        }

    }

    @Override
    public void handleException(Throwable ex, Ukcp kcp) {
        log.error("出现异常：{}", ex.getMessage());
    }

    @Override
    public void handleClose(Ukcp kcp) {
        log.info("开始handleClose");
    }


    @Override
    public void logoutRoom(String roomID) {

    }

    @Override
    public void startPublishingStream(String streamID) {

    }

    @Override
    public void startPlayingStream(String streamID) {

    }

    @Override
    public void sendCustomAudioCapturePCMData(ByteBuffer data, int dataLength) {

    }

    @Override
    public void fetchCustomAudioRenderPCMData(ByteBuffer data, int dataLength) {

    }

    @Override
    public void stopPublishingStream() {

    }

    @Override
    public void stopPlayingStream(String streamID) {

    }

}
