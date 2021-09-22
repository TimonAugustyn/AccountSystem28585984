package za.ac.nwu.ac.translator.impl;

import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.persistence.AccountType;

import java.util.List;

public interface AccountTypeTranslator {

    List<AccountTypeDto> getAllAccountTypes();

    AccountTypeDto create(AccountTypeDto accountType);

}
