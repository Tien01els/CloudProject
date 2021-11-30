package com.example.springbootcloud.repositories;

import com.example.springbootcloud.entity.MemberEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<MemberEntity, Long> {
    @Query("SELECT u FROM Member u WHERE u.username = ?1 and u.password = ?2")
    public MemberEntity findByUsernameAndPassword(String username, String password);
}
