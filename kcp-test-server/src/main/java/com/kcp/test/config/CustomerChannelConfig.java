package com.kcp.test.config;

import kcp.ChannelConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerChannelConfig  {
    @Bean
    public ChannelConfig initChannelConfig() {
        ChannelConfig channelConfig = new ChannelConfig();
        /* *
        * 设置
        * this.nodelay = nodelay;  无延迟
        * this.interval = interval; 数据包发送的时间间隔。
        * this.fastresend = resend; 快速重传
        * this.nocwnd = nc;
       /\/     * "cwnd"，即拥塞窗口（Congestion Window）。

拥塞窗口是在 TCP 协议中用于控制数据流量的一个重要参数。它代表了在不发生拥塞的情况下，可以在网络中传输的未确认数据的最大量。通过调整拥塞窗口大小，TCP 协议可以实现动态控制数据流量，以便在网络负载高的情况下避免拥塞，而在网络负载较轻的情况下充分利用可用的带宽。

拥塞窗口的调整通常会结合拥塞避免算法（如慢启动、拥塞避免和快速重传/快速恢复）来进行。在 TCP 通信中，发送方会根据网络的反馈来动态调整拥塞窗口的大小，以控制发送的数据量，以及防止过多的数据在网络中堆积从而导致拥塞。

拥塞窗口的大小会受到 RTT（Round-Trip Time）等因素的影响，以便在不引起拥塞的情况下合理利用网络带宽。这种机制有助于确保网络通信的可靠性和效率。
        */
        channelConfig.nodelay(true,40,2,true);
        /**
         * IKCP_WND_SND 是 KCP 协议中的一个配置参数，用于设置发送窗口大小。
         * 发送窗口是 KCP 协议用于控制发送数据量的一个缓冲区，它表示允许同时发送的未确认数据包的最大数量.
         */
        channelConfig.setSndwnd(512);
        /**
         * IKCP_WND_RCV 表示接收窗口的大小。接收窗口是 KCP 协议用于控制接收端的缓冲区大小，它表示接收端能够接收的未确认数据包的最大数量。
         * 较大的接收窗口可以提高网络吞吐量，但也会增加接收端的内存消耗和网络拥塞的风险.
         */
        channelConfig.setRcvwnd(512);
        /**
         * MTU 表示在网络中能够传输的数据包的最大大小。
         * 对于 KCP 协议来说，它需要将应用层的数据分割成较小的数据块，然后通过底层的传输协议（通常是 UDP）进行传输。
         * 这些较小的数据块的大小不能超过 MTU 的大小，否则可能会导致数据包被分片，从而增加网络传输的开销。
         * IKCP_MTU_DEF 是 KCP 协议中默认的 MTU 大小。
         */
        channelConfig.setMtu(512);

        //channelConfig.setFecAdapt(new FecAdapt(3,1));
        channelConfig.setAckNoDelay(true);     //收到包立刻回传ack包
        channelConfig.setTimeoutMillis(100000);  //超时时间 超过一段时间没收到消息断开连接
        channelConfig.setAckMaskSize(8);
        /**
         * 使用conv确定一个channel
         * 还是使用 socketAddress确定一个channel
         **/
        //channelConfig.setUseConvChannel(true);
        return channelConfig;
    }

}
