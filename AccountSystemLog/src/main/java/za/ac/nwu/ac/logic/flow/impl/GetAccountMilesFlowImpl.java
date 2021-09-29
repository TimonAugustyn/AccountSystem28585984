package za.ac.nwu.ac.logic.flow.impl;

import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountDto;
import za.ac.nwu.ac.domain.persistence.Account;
import za.ac.nwu.ac.logic.flow.GetAccountMilesFlow;
import za.ac.nwu.ac.translator.AccountTranslator;

import javax.transaction.Transactional;

@Transactional
@Component
public class GetAccountMilesFlowImpl implements GetAccountMilesFlow {
    private final AccountTranslator accountTranslator;
    public GetAccountMilesFlowImpl(AccountTranslator accountTranslator){
        this.accountTranslator = accountTranslator;
    }

    @Override
    public AccountDto getMilesByMemberName(String fName, String lName){
        return accountTranslator.getMilesByMemberName(fName, lName);
    }
}
