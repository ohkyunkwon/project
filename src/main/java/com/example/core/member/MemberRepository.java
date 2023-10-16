package com.example.core.member;

import com.example.core.member.Member;

public interface MemberRepository {
    void save(Member member);
    Member findById(Long memberId);
}
