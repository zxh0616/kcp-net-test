package com.player;

import com.player.callback.IZegoEventHandler;
import com.player.entity.ZegoUser;
import org.junit.jupiter.api.Test;

/**
 * @Description TODO
 * @Author: stem) Zjq
 * @Date: 16:08
 */


public class AudioTest {

    @Test
    void test (){
        IZegoEventHandler handler = new EventHandler();
        ZegoExpressEngine engine = ZegoExpressEngine.createEngine(handler);

        engine.loginRoom("444",  new ZegoUser("123", "zjq"));
    }

}
