package com.official.project001.listener;

import com.official.project001.netty.SocketServer;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
/*
* 监听spring启动后
* 启动netty
* */
@Component
public class NettyStartListener implements ApplicationRunner {

    @Resource
    private SocketServer socketServer;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        this.socketServer.start();
    }
}
