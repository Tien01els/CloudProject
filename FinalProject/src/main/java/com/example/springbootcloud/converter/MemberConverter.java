package com.example.springbootcloud.converter;

import com.example.springbootcloud.entity.MemberEntity;
import com.example.springbootcloud.entity.UserEntity;
import com.example.springbootcloud.model.dto.MemberDTO;
import com.example.springbootcloud.model.dto.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class MemberConverter {
    public MemberEntity toEntity(MemberDTO dto) {
        MemberEntity entity = new MemberEntity();
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        entity.setEmail(dto.getEmail());
        return entity;
    }
    public MemberDTO toDTO(MemberEntity entity) {
        MemberDTO dto = new MemberDTO();
        dto.setUsername(entity.getUsername());
        dto.setPassword(entity.getPassword());
        dto.setEmail(entity.getEmail());
        return dto;
    }
}
