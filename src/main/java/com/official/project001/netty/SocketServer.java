package com.official.project001.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Slf4j
@Component
public class SocketServer {

    @Resource
    private SocketInitializer socketInitializer;

    @Getter
    private ServerBootstrap serverBootstrap;

    private int port =8098;

    private int bossThread = 1;

    public void start(){
        this.init();
        //绑定端口
        this.serverBootstrap.bind(this.port);
        log.info("Netty started on port 8098");
    }

    private void init(){
        //接收连接
        NioEventLoopGroup boss = new NioEventLoopGroup(this.bossThread);
        //处理业务
        NioEventLoopGroup worker = new NioEventLoopGroup();
        this.serverBootstrap = new ServerBootstrap();
        this.serverBootstrap.group(boss,worker)
                .channel(NioServerSocketChannel.class)
                //添加通道初始化
                .childHandler(this.socketInitializer);
    }

}
