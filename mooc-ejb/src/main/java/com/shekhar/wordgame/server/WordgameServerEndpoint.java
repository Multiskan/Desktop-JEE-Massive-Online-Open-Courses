package com.shekhar.wordgame.server;

import java.io.IOException;
import java.util.logging.Logger;

import javax.websocket.CloseReason;
import javax.websocket.CloseReason.CloseCodes;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/game1")
public class WordgameServerEndpoint {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @OnOpen
    public void onOpen(Session session) {
        logger.info("Connected ... " + session.getId());
    }

    @OnMessage
    public String onMessage(String message, Session session) {
        switch (message) {
        case "quit":
            //logger.info("Quitting the game");
            try {
                session.close(new CloseReason(CloseCodes.NORMAL_CLOSURE, "Game finished"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            break;
        }
        return "**Notification** Server Endpoint Recieved New : "+message;
    }

    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        logger.info(String.format("Session %s closed because of %s", session.getId(), closeReason));
    }

    
}
