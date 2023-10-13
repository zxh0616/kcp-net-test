package com.player.constants;

public enum ZegoPublisherState {
    NO_PUBLISH, //未推流状态，在推流前处于该状态。
    PUBLISH_REQUESTING, //正在请求推流状态，
    PUBLISHING;//正在推流状态，进入该状态表明推流已经成功，用户可以正常通信


}
