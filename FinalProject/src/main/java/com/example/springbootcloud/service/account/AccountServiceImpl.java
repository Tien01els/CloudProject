package com.example.springbootcloud.service.account;

import com.example.springbootcloud.converter.AccountConverter;
import com.example.springbootcloud.entity.Account;
import com.example.springbootcloud.model.dto.AccountDTO;
import com.example.springbootcloud.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountServiceImpl implements AccountService{
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountConverter accountConverter;

    @Override
    public AccountDTO createAccount(AccountDTO accountDTO) {
        Account account = accountConverter.toEntity(accountDTO);
        account = accountRepository.save(account);
        return accountConverter.toDTO(account);
    }

    @Override
    public Iterable<Account> getListAccount() {
        return accountRepository.findAll();
    }
}
