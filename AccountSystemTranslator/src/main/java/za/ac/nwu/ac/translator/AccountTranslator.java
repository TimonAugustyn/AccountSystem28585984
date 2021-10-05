package za.ac.nwu.ac.translator;

import za.ac.nwu.ac.domain.dto.AccountDto;
import za.ac.nwu.ac.domain.persistence.Account;

import java.util.List;

public interface AccountTranslator {
    List<AccountDto> getAllAccounts();

    AccountDto save(Account account);

    AccountDto getMilesByMemberName(String fName, String lName);

    Integer add(Integer miles, String fName, String lName);

    Integer sub(Integer miles, String fName, String lName);
}
