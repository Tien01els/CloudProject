package com.example.springbootcloud.converter;

import com.example.springbootcloud.entity.Member;
import com.example.springbootcloud.model.dto.MemberDTO;
import org.springframework.stereotype.Component;

@Component
public class MemberConverter {
    public Member toEntity(MemberDTO dto) {
        Member entity = new Member();
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        entity.setEmail(dto.getEmail());
        return entity;
    }
    public MemberDTO toDTO(Member entity) {
        MemberDTO dto = new MemberDTO();
        dto.setUsername(entity.getUsername());
        dto.setPassword(entity.getPassword());
        dto.setEmail(entity.getEmail());
        return dto;
    }
}
