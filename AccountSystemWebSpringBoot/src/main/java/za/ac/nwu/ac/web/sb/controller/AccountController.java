package za.ac.nwu.ac.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.ac.domain.dto.AccountDto;
import za.ac.nwu.ac.domain.service.GeneralResponse;
import za.ac.nwu.ac.logic.flow.CreateAccountFlow;
import za.ac.nwu.ac.logic.flow.FetchAccountFlow;
import za.ac.nwu.ac.logic.flow.impl.CreateAccountFlowImpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("Account")
public class AccountController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);

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
        long startTime = System.nanoTime();
        LOGGER.debug("Create a new Account");
        List<AccountDto> account = fetchAccountFlow.getAllAccounts();
        GeneralResponse<List<AccountDto>> response = new GeneralResponse<>(true, account);
        LOGGER.info("Response time: {}", ((System.nanoTime() - startTime) / 1000000L));
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
        long startTime = System.nanoTime();
        LOGGER.debug("Create a new Account");
        AccountDto accountResponse = createAccountFlow.create(account);
        GeneralResponse<AccountDto> response = new GeneralResponse<>(true, accountResponse);
        LOGGER.info("Response time: {}", ((System.nanoTime() - startTime) / 1000000L));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("See Account Miles")
    @ApiOperation(value = "Fetches the specified Account.", notes = "Fetches the Account corresponding to the given member fName and lName")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Goal Found", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Resource Not Found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<AccountDto>> getMilesByMemberName(
            @ApiParam(value = "The first and last name that uniquely identifies the Account.",
                    required = true)
            @RequestParam("fName") final String fName, @RequestParam("lName") final String lName){
        long startTime = System.nanoTime();
        LOGGER.debug("Create a new Account");
        AccountDto account= fetchAccountFlow.getMilesByMemberName(fName, lName);
        GeneralResponse<AccountDto> response = new GeneralResponse<>(true, account);
        LOGGER.info("Response time: {}", ((System.nanoTime() - startTime) / 1000000L));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("Add Miles To Account")
    @ApiOperation(value = "Adds the specified amount of Miles to the Account.", notes = "Adds the specified amount of Miles to the Account")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Goal Found", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Resource Not Found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<Integer>> add(
            @ApiParam(value = "The first and last name that uniquely identifies the Account.",
                    required = true)
            @RequestParam("fName") final String fName, @RequestParam("lName") final String lName, @RequestParam("miles") final Integer miles){
        long startTime = System.nanoTime();
        LOGGER.debug("Create a new Account");
        Integer account= fetchAccountFlow.add(miles, fName, lName);
        GeneralResponse<Integer> response = new GeneralResponse<>(true, account);
        LOGGER.info("Response time: {}", ((System.nanoTime() - startTime) / 1000000L));
        LOGGER.info("Date miles where added: {}", LocalDate.now());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("Subtract Miles From Account")
    @ApiOperation(value = "Subtracts the specified amount of Miles from the Account.", notes = "Subtracts the specified amount of Miles from the Account")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Goal Found", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Resource Not Found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<Integer>> sub(
            @ApiParam(value = "The first and last name that uniquely identifies the Account.",
                    required = true)
            @RequestParam("fName") final String fName, @RequestParam("lName") final String lName, @RequestParam("miles") final Integer miles){
        long startTime = System.nanoTime();
        LOGGER.debug("Create a new Account");
        Integer account= fetchAccountFlow.sub(miles, fName, lName);
        GeneralResponse<Integer> response = new GeneralResponse<>(true, account);
        LOGGER.info("Response time: {}", ((System.nanoTime() - startTime) / 1000000L));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
