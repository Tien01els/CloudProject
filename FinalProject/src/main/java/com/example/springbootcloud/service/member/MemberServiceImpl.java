package com.example.springbootcloud.service.member;

import com.example.springbootcloud.converter.MemberConverter;
import com.example.springbootcloud.entity.Member;
import com.example.springbootcloud.model.dto.MemberDTO;
import com.example.springbootcloud.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberConverter memberConverter;

    @Override
    public MemberDTO createMember(MemberDTO memberDTO){
        Member member = memberConverter.toEntity(memberDTO);
        member = memberRepository.save(member);
        return memberConverter.toDTO(member);
    }

    @Override
    public String checkLogin(MemberDTO memberDTO) {
        Member member = memberRepository.findByUsernameAndPassword(memberDTO.getUsername(), memberDTO.getPassword());
        if(member != null){return "Success";}
        return "Fail";
    }
}
