package org.example.rxnetty;

import reactor.core.publisher.Mono;
import reactor.netty.DisposableServer;
import reactor.netty.tcp.TcpServer;

public class ServerTest {
    public static void main(String[] args) {
        DisposableServer server = TcpServer.create()
                .handle((nettyInbound, nettyOutbound) -> {
                    return nettyOutbound.sendString(Mono.just("hello world!"));
                })
                .bindNow();

        server.onDispose().block();
    }
}
