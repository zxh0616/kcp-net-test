package com.player.constants;

public enum ZegoPlayerState
{
    NO_PLAY, //未拉流状态
    PLAY_REQUESTING, //正在请求拉流状态，
    PLAYING;//正在拉流状态，进入该状态表明拉流已经成功，用户可以正常通信


}
