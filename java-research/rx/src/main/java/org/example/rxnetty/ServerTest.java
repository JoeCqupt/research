package org.example.rxnetty;

import reactor.netty.DisposableServer;
import reactor.netty.tcp.TcpServer;

public class ServerTest {
    public static void main(String[] args) {
        DisposableServer server = TcpServer.create()
                .bindNow();

        server.onDispose().block();
    }
}
