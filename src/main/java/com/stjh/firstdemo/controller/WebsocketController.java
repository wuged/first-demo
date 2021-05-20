package com.stjh.firstdemo.controller;

import com.stjh.firstdemo.bo.Result;
import com.stjh.firstdemo.websocket.WebSocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * websocket推送消息给前台
 * @Author: wuge
 * @Date: 2020/9/27
 */
@RestController
public class WebsocketController extends BaseController {

    @Autowired
    WebSocket webSocket;


    /**
     * 给某个用户发消息
     * @param userId
     * @param msg
     * @return
     * @throws IOException
     */
    @GetMapping("/sendTo")
    public Result sendTo(@RequestParam("userId") String userId, @RequestParam("msg") String msg) throws IOException {
        webSocket.sendMessageTo(msg, userId);
        return successResult();
    }

    /**
     * 给所有用户发消息
     * @param msg
     * @return
     * @throws IOException
     */
    @GetMapping("/sendAll")
    public Result sendAll(@RequestParam("msg") String msg) throws IOException {
        String fromUserId="system";//其实没用上
        webSocket.sendMessageAll(msg,fromUserId);
        return successResult();
    }
}
