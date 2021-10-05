package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.ac.domain.dto.AccountDto;

public interface AddAccountMilesFlow {
    Integer add(Integer miles, String fName, String lName);
    Integer sub(Integer miles, String fName, String lName);
}
