package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.ac.domain.dto.AccountDto;
import za.ac.nwu.ac.domain.persistence.Account;

import java.util.List;

public interface FetchAccountFlow {
    List<AccountDto> getAllAccounts();
    AccountDto getMilesByMemberName(String fName, String lName);
    Integer add(Integer miles, String fName, String lName);
    Integer sub(Integer miles, String fName, String lName);
}
