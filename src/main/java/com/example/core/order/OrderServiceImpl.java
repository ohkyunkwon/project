package com.example.core.order;

import com.example.core.annotataion.MainDiscountPolicy;
import com.example.core.discount.DiscountPolicy;
import com.example.core.member.Member;
import com.example.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {
        private final MemberRepository memberRepository;
        private final DiscountPolicy discountPolicy;

        //@RequiredArgsConstructor 로 아래 this 삭제 가능
        public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy  DiscountPolicy DiscountPlicy) {
                this.memberRepository = memberRepository;
                this.discountPolicy = DiscountPlicy;
        }

        //수정자 주입 방법
//        private MemberRepository memberRepository;
//        private DiscountPolicy discountPolicy;
//        @Autowired (required = false) //required 선택 , 변경 가능성 있는 의존관계 사용
//        public void setMemberRepository(MemberRepository memberRepository) {
//                this.memberRepository = memberRepository;
//        }
//        @Autowired(required = false)
//        public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//                this.discountPolicy = discountPolicy;
//        }
        //필드 주입
        //이름 그대로 필드에 바로 주입하는 방법
        //사용안하는게 좋음
//        @Autowired private MemberRepository memberRepository;
//        @Autowired private DiscountPolicy discountPolicy;

        @Override
        public Order createOrder(Long memberId, String itemName, int itemPrice) {
                Member member = memberRepository.findById(memberId);
                int discountPrice = discountPolicy.discount(member, itemPrice);
                return new Order(memberId, itemName, itemPrice, discountPrice);
        }


        //테스트 용도
        public MemberRepository getMemberRepository(){
                return memberRepository;
        }

}