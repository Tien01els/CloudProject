package com.example.springbootcloud.service.account;

import com.example.springbootcloud.entity.Account;
import com.example.springbootcloud.entity.Student;
import com.example.springbootcloud.model.dto.AccountDTO;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {
    AccountDTO createAccount(AccountDTO accountDTO);
    Iterable<Account> getListAccount();
}
