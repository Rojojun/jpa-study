package com.rojojun.jpastudy.shop.service;

import com.rojojun.jpastudy.shop.domain.Member;
import com.rojojun.jpastudy.shop.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {
    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    public void 회원가입() throws Exception {
        // Given
        Member member = new Member();
        member.setName("kim");

        // When
        Long saveId = memberService.join(member);

        // Then
        assertEquals(member, memberRepository.findOne(saveId));
    }

    @Test
    public void 중복_회원_예외() throws Exception {
        // Given
        Member member = new Member();
        member.setName("kim");

        Member member2 = new Member();
        member2.setName("kim");

        // When
        memberService.join(member);
        IllegalStateException exception = assertThrows(IllegalStateException.class,
                () -> memberService.join(member2));

        // Then
        assertEquals("이미 존재하는 회원입니다 : kim", exception.getMessage());
    }
}