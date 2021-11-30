package com.example.springbootcloud.service.member;

import com.example.springbootcloud.entity.MemberEntity;
import com.example.springbootcloud.model.dto.MemberDTO;
import org.springframework.stereotype.Service;

@Service
public interface MemberService {
//    Iterable<MemberEntity>
    MemberDTO createMember(MemberDTO memberDTO);
    String checkLogin(MemberDTO memberDTO);
}
