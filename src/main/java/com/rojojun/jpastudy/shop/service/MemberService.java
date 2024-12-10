package com.rojojun.jpastudy.shop.service;

import com.rojojun.jpastudy.shop.domain.Member;
import com.rojojun.jpastudy.shop.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Transactional
@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public Long join(Member member) {
        validateDuplicate(member);
        memberRepository.save(member);
        return member.getId();
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }

    private void validateDuplicate(Member member) {
        memberRepository.findByName(member.getName()).stream()
                .findFirst()
                .ifPresent(m -> { throw new IllegalArgumentException("이미 존재하는 회원입니다: " + m.getName()); });
    }
}

