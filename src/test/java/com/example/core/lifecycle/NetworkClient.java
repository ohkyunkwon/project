package com.example.core.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient {
    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
        connect();
        call("초기화 연결 메세지");
    }
    public void setUrl(String url) {
        this.url = url;
    }

    //서비스 시작시 호출
    public void connect(){
        System.out.println("commect = " + url);
    }

    public void call(String massage){
        System.out.println("call = " + url + " massage = " + massage);
    }

    //서비스 종료시 호출
    public void disConnect(){
        System.out.println("clase = " + url);
    }
    @PostConstruct
    public void init() {
        System.out.println("NetworkClient.init"); connect();
        call("초기화 연결 메시지");
    }
    @PreDestroy
    public void close() {
        System.out.println("NetworkClient.close");
        disConnect();
    }

}
