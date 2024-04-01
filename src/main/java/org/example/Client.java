package org.example;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;

public class Client {
    public static void main(String[] args) throws URISyntaxException {
        URI uri = new URI("ws://localhost:8080/subscribe");
        WebSocketClient client = new WebSocketClient(uri) {
            @Override
            public void onOpen(ServerHandshake handshakeData) {
                System.out.println("socket connection connection established");
            }

            @Override
            public void onMessage(String message) {
                System.out.println("data received " +
                        "\nbody : \n" + message  + "\n");
            }

            @Override
            public void onClose(int code, String reason, boolean remote) {
                System.out.println("data receive end. connection close");
            }

            @Override
            public void onError(Exception ex) {
                System.out.println("error : " + ex.getMessage());
                ex.printStackTrace();
            }
        };
        client.connect();
    }
}
