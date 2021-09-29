package za.ac.nwu.ac.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.ac.domain.dto.AccountDto;
import za.ac.nwu.ac.domain.service.GeneralResponse;
import za.ac.nwu.ac.logic.flow.CreateAccountFlow;
import za.ac.nwu.ac.logic.flow.FetchAccountFlow;

import java.util.List;

@RestController
@RequestMapping("Account")
public class AccountController {

    private final FetchAccountFlow fetchAccountFlow;
    private final CreateAccountFlow createAccountFlow;

    @Autowired
    public AccountController(FetchAccountFlow fetchAccountFlow, CreateAccountFlow createAccountFlow) {
        this.fetchAccountFlow = fetchAccountFlow;
        this.createAccountFlow = createAccountFlow;
    }

    @GetMapping("/all")
    @ApiOperation(value = "Gets all the configured Accounts.", notes = "Returns a list of accounts")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Accounts returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<List<AccountDto>>> getAll(){
        List<AccountDto> account = fetchAccountFlow.getAllAccounts();
        GeneralResponse<List<AccountDto>> response = new GeneralResponse<>(true, account);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("")
    @ApiOperation(value = "Creates a new Account.", notes = "Creates a new AccountT in the DB.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The Account was created successfully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<AccountDto>> create(
            @ApiParam(value = "Request body to create a new Account.",
                    required = true)
            @RequestBody AccountDto account){
        AccountDto accountResponse = createAccountFlow.create(account);
        GeneralResponse<AccountDto> response = new GeneralResponse<>(true, accountResponse);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("See Account Miles")
    @ApiOperation(value = "Fetches the specified Account.", notes = "Fetches the Account corresponding to the given memberId")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Goal Found", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Resource Not Found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<AccountDto>> getMilesByMemberName(
            @ApiParam(value = "The memberID that uniquely identifies the Account.",
                    required = true)
            @RequestParam("fName") final String fName, @RequestParam("lName") final String lName){
        AccountDto account= fetchAccountFlow.getMilesByMemberName(fName, lName);
        GeneralResponse<AccountDto> response = new GeneralResponse<>(true, account);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
