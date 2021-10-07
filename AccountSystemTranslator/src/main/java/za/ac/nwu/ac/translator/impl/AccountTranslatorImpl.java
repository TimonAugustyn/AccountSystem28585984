package za.ac.nwu.ac.translator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountDto;
import za.ac.nwu.ac.domain.persistence.Account;
import za.ac.nwu.ac.repo.persistence.AccountRepository;
import za.ac.nwu.ac.translator.AccountTranslator;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountTranslatorImpl implements AccountTranslator {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountTranslatorImpl(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @Override
    public List<AccountDto> getAllAccounts(){
        List<AccountDto> accountDtos = new ArrayList<>();
        try {
            for (Account account : accountRepository.findAll()){
                accountDtos.add(new AccountDto(account));
            }
        }catch (Exception e){
            throw new RuntimeException("Unable to read from the DB", e);
        }
        return accountDtos;
    }

    @Override
    public AccountDto save(Account account) {
        try {
            return new AccountDto(accountRepository.save(account));
        }catch (Exception e){
            throw new RuntimeException("Unable to save to the DB", e);
        }
    }

    @Override
    public AccountDto getMilesByMemberName(String fName, String lName){
        try {
            Account account = accountRepository.getMilesByMemberName(fName, lName);
            return new AccountDto(account);
        }catch (Exception e) {
            throw new RuntimeException("Unable to find in DB", e);
        }
    }

    @Override
    public Integer add(Integer miles, String fName, String lName){
        try {

            Integer account = accountRepository.add(miles, fName, lName);
            return new Integer(account);
        }catch (Exception e) {
            throw new RuntimeException("Unable to find in DB", e);
        }
    }

    @Override
    public Integer sub(Integer miles, String fName, String lName){
        try {

            Integer account = accountRepository.sub(miles, fName, lName);
            return new Integer(account);
        }catch (Exception e) {
            throw new RuntimeException("Unable to find in DB", e);
        }
    }
}
