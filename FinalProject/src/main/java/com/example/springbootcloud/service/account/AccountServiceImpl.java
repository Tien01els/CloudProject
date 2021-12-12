package com.example.springbootcloud.service.account;

import com.example.springbootcloud.converter.AccountConverter;
import com.example.springbootcloud.converter.StudentConverter;
import com.example.springbootcloud.converter.TeacherConverter;
import com.example.springbootcloud.entity.Account;
import com.example.springbootcloud.entity.Student;
import com.example.springbootcloud.entity.Teacher;
import com.example.springbootcloud.global.GlobalVariable;
import com.example.springbootcloud.model.dto.AccountDTO;
import com.example.springbootcloud.repositories.AccountRepository;
import com.example.springbootcloud.repositories.StudentRepository;
import com.example.springbootcloud.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Objects;

@Component
public class AccountServiceImpl implements AccountService{
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountConverter accountConverter;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentConverter studentConverter;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private TeacherConverter teacherConverter;

    //Tạo tài khoản
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

    //Lấy ra thông tin của account = id
    @Override
    public AccountDTO getAccountById(Long account_id) {
        Account account = accountRepository.findAccountById(account_id);
        return accountConverter.toDTO(account);
    }

    //Check mk cũ có trùng khớp không
    @Override
    public String checkOldPassword(AccountDTO accountDTO){
        Account account = accountRepository.findAccountById(accountDTO.getAccount_id());
        if(Objects.equals(account.getPassword(), accountDTO.getPassword())){
            return "Match";
        }else
            return "Not Match";
    }

    //Update thông tin account
    @Override
    public void updateAccountById(AccountDTO accountDTO){
        Account account = accountConverter.toEntity(accountDTO);
        accountRepository.save(account);
    }

    //Vừa đăng nhập vào thì kiểm tra xem có account đó không, có thì gán global.
    @Override
    public HashMap<String, String> checkLogin(AccountDTO accountDTO){
        Account account = accountRepository.findByUsernameAndPassword(accountDTO.getUsername(), accountDTO.getPassword());
        HashMap<String, String> result = new HashMap<String, String>();

        if(account != null){
            result.put("accid", Long.toString(account.getAccount_id()));
            GlobalVariable.IDaccount = account.getAccount_id();
            GlobalVariable.UserRole = account.getRole();
            if(Objects.equals(account.getRole(), "student")){
                Student student = studentRepository.findStudentByAccountId(account.getAccount_id());
                result.put("userid", Long.toString(student.getStudent_id()));
                GlobalVariable.IDuser = student.getStudent_id();

            }else if(Objects.equals(account.getRole(), "teacher")){
                Teacher teacher = teacherRepository.findTeacherByAccountId(account.getAccount_id());
                result.put("userid", Long.toString(teacher.getTeacher_id()));
                GlobalVariable.IDuser = teacher.getTeacher_id();
            }
            result.put("key", "Success");
            return result;
        };

        result.put("key", "Fail");
        return result;
    }

}
