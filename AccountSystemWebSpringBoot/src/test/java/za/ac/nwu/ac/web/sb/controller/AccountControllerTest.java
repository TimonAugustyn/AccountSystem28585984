package za.ac.nwu.ac.web.sb.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import za.ac.nwu.ac.domain.dto.AccountDto;
import za.ac.nwu.ac.logic.flow.CreateAccountFlow;
import za.ac.nwu.ac.logic.flow.FetchAccountFlow;
import static org.junit.Assert.assertEquals;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AccountControllerTest {

    private static final String APP_URL = "/account-system/mvc";
    private static final String ACCOUNT_CONTROLLER_URL = APP_URL + "/Account";

    @Mock
    private FetchAccountFlow fetchAccountFlow;
    @Mock
    private CreateAccountFlow createAccountFlow;

    @InjectMocks
    private AccountController controller;
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void getAll() throws Exception{
        String expectedResponse = "{\"successful\":true,\"payload\":[" +
                "{\"memberId\":28585984,\"fName\":\"Timon\",\"lName\":\"Augustyn\",\"miles\":140}]}";

        List<AccountDto> accountDtos = new ArrayList<>();
        accountDtos.add(new AccountDto(28585984L, "Timon", "Augustyn", 140));

        when(fetchAccountFlow.getAllAccounts()).thenReturn(accountDtos);

        MvcResult mvcResult = mockMvc.perform(get((String.format("%s/%s",
                        ACCOUNT_CONTROLLER_URL, "all")))
                        .servletPath(APP_URL)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                        .andReturn();
        verify(fetchAccountFlow, times(1)).getAllAccounts();
        assertEquals(expectedResponse, mvcResult.getResponse().getContentAsString());
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void create() throws Exception{
        String accountTypeToBeCreated = "{\"memberId\":28585988,\"fName\":\"Simon\",\"lName\":\"Bugustyn\",\"miles\":150}]}";
        String expectedResponse = "{\"successful\":true,\"payload\":" +
                "{\"memberId\":28585988,\"fName\":\"Simon\",\"lName\":\"Bugustyn\",\"miles\":150}}";

        AccountDto accountDto = new AccountDto(28585988L, "Simon", "Bugustyn", 150);

        when(createAccountFlow.create(eq(accountDto))).then(returnsFirstArg());
        MvcResult mvcResult = mockMvc.perform(post(ACCOUNT_CONTROLLER_URL)
                                .servletPath(APP_URL)
                                .accept(MediaType.APPLICATION_JSON)
                                .content(accountTypeToBeCreated)
                                .contentType(MediaType.APPLICATION_JSON))
                            .andExpect(status().isCreated())
                            .andReturn();
        verify(createAccountFlow, times(1)).create(eq(accountDto));
        assertEquals(expectedResponse, mvcResult.getResponse().getContentAsString());
    }
}