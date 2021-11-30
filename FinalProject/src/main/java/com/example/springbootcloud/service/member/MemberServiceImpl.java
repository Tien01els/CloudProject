package com.example.springbootcloud.service.member;

import com.example.springbootcloud.converter.MemberConverter;
import com.example.springbootcloud.entity.MemberEntity;
import com.example.springbootcloud.model.dto.MemberDTO;
import com.example.springbootcloud.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class MemberServiceImpl implements MemberService{
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberConverter memberConverter;

    @Override
    public MemberDTO createMember(MemberDTO memberDTO){
        MemberEntity memberEntity = memberConverter.toEntity(memberDTO);
        memberEntity = memberRepository.save(memberEntity);
        return memberConverter.toDTO(memberEntity);
    }

    @Override
    public String checkLogin(MemberDTO memberDTO) {
//        MemberEntity memberEntity = memberConverter.toEntity(memberDTO);
        MemberEntity memberEntity = memberRepository.findByUsernameAndPassword(memberDTO.getUsername(), memberDTO.getPassword());
        if(Objects.equals(memberEntity.getUsername(), memberDTO.getUsername()) && Objects.equals(memberEntity.getPassword(), memberDTO.getPassword())){
            return "Success";
        }
        return "Fail";
    }
}
