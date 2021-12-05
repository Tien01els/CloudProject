package com.example.springbootcloud.repositories;

import com.example.springbootcloud.entity.Account;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
    @Query("SELECT u FROM Member u WHERE u.username = ?1 and u.password = ?2")
    public Account findByUsernameAndPassword(String username, String password);
}
