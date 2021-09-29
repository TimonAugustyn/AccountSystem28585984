package za.ac.nwu.ac.logic.flow.impl;

import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountDto;
import za.ac.nwu.ac.domain.persistence.Account;
import za.ac.nwu.ac.logic.flow.AddAccountMilesFlow;
import za.ac.nwu.ac.translator.AccountTranslator;

import javax.transaction.Transactional;

@Transactional
@Component
public class AddAccountMilesFlowImpl implements AddAccountMilesFlow {
    private final AccountTranslator accountTranslator;
    public AddAccountMilesFlowImpl(AccountTranslator accountTranslator){
        this.accountTranslator = accountTranslator;
    }

    @Override
    public AccountDto add(AccountDto accountDto){
        Account account = accountDto.getAccount();
        return accountTranslator.save(account);
    }
}
