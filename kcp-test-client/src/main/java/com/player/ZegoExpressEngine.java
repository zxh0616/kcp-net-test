package com.player;

import com.player.callback.IZegoEventHandler;
import com.player.entity.ZegoUser;
import com.player.impl.ZegoExpressEngineImpl;
import lombok.Data;

import java.nio.ByteBuffer;

/**
 * @Description TODO
 * @Author: stem) Zjq
 * @Date: 14:11
 */

@Data
public abstract class ZegoExpressEngine {

    public static ZegoExpressEngine createEngine(IZegoEventHandler handler) {
        return new ZegoExpressEngineImpl(handler);
    }

    public abstract void loginRoom(String roomID, ZegoUser user);
    public abstract void logoutRoom(String roomID);
    public abstract void startPublishingStream(String streamID);
    public abstract void startPlayingStream(String streamID);
    public abstract void sendCustomAudioCapturePCMData(ByteBuffer data, int dataLength);
    public abstract void fetchCustomAudioRenderPCMData(ByteBuffer data, int dataLength);
    public abstract void stopPublishingStream();
    public abstract void stopPlayingStream(String streamID);


}
