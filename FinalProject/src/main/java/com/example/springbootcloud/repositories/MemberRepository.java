package com.example.springbootcloud.repositories;

import com.example.springbootcloud.entity.Member;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Long> {
    @Query("SELECT u FROM Member u WHERE u.username = ?1 and u.password = ?2")
    public Member findByUsernameAndPassword(String username, String password);
}
