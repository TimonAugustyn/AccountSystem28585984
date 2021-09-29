package za.ac.nwu.ac.logic.flow.impl;

import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountDto;
import za.ac.nwu.ac.domain.persistence.Account;
import za.ac.nwu.ac.logic.flow.CreateAccountFlow;
import za.ac.nwu.ac.translator.AccountTranslator;

import javax.transaction.Transactional;

@Transactional
@Component
public class CreateAccountFlowImpl implements CreateAccountFlow {
    private final AccountTranslator accountTranslator;
    public CreateAccountFlowImpl(AccountTranslator accountTranslator){
        this.accountTranslator = accountTranslator;
    }

    @Override
    public AccountDto create(AccountDto accountDto){
        Account account = accountDto.getAccount();
        return accountTranslator.save(account);
    }
}
