package com.player;

import cn.hutool.json.JSONObject;
import com.player.callback.IZegoEventHandler;
import com.player.constants.ZegoPlayerState;
import com.player.constants.ZegoPublisherState;
import com.player.constants.ZegoRoomStateChangedReason;

/**
 * @Description TODO
 * @Author: stem) Zjq
 * @Date: 16:10
 */

public class EventHandler implements IZegoEventHandler {
    @Override
    public void onRoomStateChanged(String roomId, ZegoRoomStateChangedReason reason, int errorCode, JSONObject extendedData) {
        System.out.println("111---onRoomStateChanged");
    }

    @Override
    public void onPublisherStateUpdate(String streamID, ZegoPublisherState state, int errorCode, JSONObject extendedData) {
        System.out.println("222---onPublisherStateUpdate");
    }

    @Override
    public void onPlayerStateUpdate(String streamID, ZegoPlayerState state, int errorCode, JSONObject extendedData) {
        System.out.println("333---onPlayerStateUpdate");
    }
}
