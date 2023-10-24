package com.example.core.autowired;

import com.example.core.member.Member;
import jakarta.annotation.Nullable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Optional;

//옵션 처리 방법

public class AutowiredTest {

    @Test
    void AutowiredOption(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);

    }
    static class TestBean{
        //호출 안됨
        @Autowired(required = false)
        public void serNoBean1(Member noBean1){
            System.out.println("noBean1 = " + noBean1);
        }
        //null 호출
        @Autowired
        public void serNoBean2(@Nullable Member noBean2){
            System.out.println("noBean2 = " + noBean2);
        }
        //Optional.empty 호출
        @Autowired
        public void serNoBean3(Optional<Member> noBean3){
            System.out.println("noBean3 = " + noBean3);
        }

    }
}
