package com.player.constants;

public enum ZegoRoomStateChangedReason
{
    LOGINING, //正在登录房间
    LOGINED, //登录房间成功
    LOGIN_FAILED,  //登录房间失败
    RECONNECTING, //房间连接临时中断。如果因为网络质量不佳产生的中断
    RECONNECTED, //房间重新连接成功。
    RECONNECT_FAILED, //房间重新连接失败。
    KICK_OUT, //被服务器踢出房间
    LOGOUT, //登出房间成功
    LOGOUT_FAILED; //登出房间失败
}
