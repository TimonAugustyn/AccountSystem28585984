package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.ac.domain.dto.AccountDto;

public interface GetAccountMilesFlow {
    AccountDto getMilesByMemberName(String fName, String lName);
}
