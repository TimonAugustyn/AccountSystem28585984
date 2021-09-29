package za.ac.nwu.ac.logic.flow.impl;

import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.logic.flow.CreateAccountTypeFlow;
import za.ac.nwu.ac.translator.AccountTypeTranslator;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Transactional
@Component("createAccountTypeFlowName")
public class CreateAccountTypeFlowImpl implements CreateAccountTypeFlow{
    private final AccountTypeTranslator accountTypeTranslator;
    public CreateAccountTypeFlowImpl(AccountTypeTranslator accountTypeTranslator){
        this.accountTypeTranslator = accountTypeTranslator;
    }

    @Override
    public AccountTypeDto create(AccountTypeDto accountTypeDto){
        if(null == accountTypeDto.getCreationDate()){
            accountTypeDto.setCreationDate(LocalDate.now());
        }

        AccountType accountType = accountTypeDto.getAccountType();
        Set<AccountTransaction> accountTransactions = new HashSet<>();
        AccountTransaction accountTransaction = new AccountTransaction(accountType, 123L, 50L, LocalDate.now());

        //accountTransactionRepo.save(accountTransaction);
        accountTransactions.add(accountTransaction);
        accountType.setAccountTransactions(accountTransactions);

        return accountTypeTranslator.save(accountType);
    }
}
