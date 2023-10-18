package com.example.core.order;

import com.example.core.AppConfig;
import com.example.core.member.MemberService;
import org.junit.jupiter.api.BeforeEach;


class OrderServiceTest{
    MemberService memberService;
    OrderService orderService;
    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }
}


