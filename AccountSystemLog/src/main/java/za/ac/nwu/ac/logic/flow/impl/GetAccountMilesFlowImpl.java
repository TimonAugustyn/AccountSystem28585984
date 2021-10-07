package za.ac.nwu.ac.logic.flow.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountDto;
import za.ac.nwu.ac.domain.persistence.Account;
import za.ac.nwu.ac.logic.flow.GetAccountMilesFlow;
import za.ac.nwu.ac.translator.AccountTranslator;

import javax.transaction.Transactional;

@Transactional
@Component
public class GetAccountMilesFlowImpl implements GetAccountMilesFlow {
    private static final Logger LOGGER = LoggerFactory.getLogger(GetAccountMilesFlowImpl.class);
    private final AccountTranslator accountTranslator;
    public GetAccountMilesFlowImpl(AccountTranslator accountTranslator){
        this.accountTranslator = accountTranslator;
    }

    @Override
    public AccountDto getMilesByMemberName(String fName, String lName){
        return accountTranslator.getMilesByMemberName(fName, lName);
    }
}
