package com.player.callback;

import cn.hutool.json.JSONObject;
import com.player.constants.ZegoPlayerState;
import com.player.constants.ZegoPublisherState;
import com.player.constants.ZegoRoomStateChangedReason;

public interface IZegoEventHandler {
    void onRoomStateChanged(String roomId, ZegoRoomStateChangedReason reason, int errorCode, JSONObject extendedData);

    //void onRoomUserUpdate(String roomId, ZegoUpdateType updateType, List<ZegoUser> userList);

    //void onRoomStreamUpdate(String roomId,);

    void onPublisherStateUpdate(String streamID, ZegoPublisherState state, int errorCode, JSONObject extendedData);

    void onPlayerStateUpdate(String streamID, ZegoPlayerState state, int errorCode, JSONObject extendedData);

}
