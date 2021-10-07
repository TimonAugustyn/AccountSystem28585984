package za.ac.nwu.ac.logic.flow.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountDto;
import za.ac.nwu.ac.domain.persistence.Account;
import za.ac.nwu.ac.logic.flow.CreateAccountFlow;
import za.ac.nwu.ac.translator.AccountTranslator;

import javax.transaction.Transactional;

@Transactional
@Component
public class CreateAccountFlowImpl implements CreateAccountFlow {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreateAccountFlowImpl.class);

    private final AccountTranslator accountTranslator;
    public CreateAccountFlowImpl(AccountTranslator accountTranslator){
        this.accountTranslator = accountTranslator;
    }

    @Override
    public AccountDto create(AccountDto accountDto){
        if (LOGGER.isInfoEnabled()) {
            String outputForLogging = "null";
            if ((null != accountDto) && (null != accountDto.getAccount())){
                outputForLogging = accountDto.getAccount().toString();
            }
            LOGGER.warn("The input object was {} and the details are {}", accountDto, outputForLogging);
        }
        Account account = accountDto.getAccount();
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Got Account for {} and the memberID is {}", accountDto.getAccount(), accountDto.getMemberId());
        }
        return accountTranslator.save(account);
    }
}
