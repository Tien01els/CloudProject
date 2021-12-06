package com.example.springbootcloud.repositories;

import com.example.springbootcloud.entity.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
    @Query("SELECT u FROM account u WHERE u.username = ?1 and u.password = ?2")
    public Account findByUsernameAndPassword(String username, String password);
}
