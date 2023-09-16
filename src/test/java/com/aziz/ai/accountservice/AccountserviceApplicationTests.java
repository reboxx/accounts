package com.aziz.ai.accountservice;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.aziz.ai.accountservice.controller.AccountServiceController;
import com.aziz.ai.accountservice.dao.dto.AccountDto;
import com.aziz.ai.accountservice.dao.dto.CustomerDto;
import com.aziz.ai.accountservice.dao.entity.Account;
import com.aziz.ai.accountservice.dao.entity.Customer;
import com.aziz.ai.accountservice.service.AccountService;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author Aziz ai
 *
 */
@WebMvcTest(controllers = { AccountServiceController.class })
class AccountserviceApplicationTests {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private AccountService ser;

	@MockBean
	private Map<String, Customer> cachedCustomers;

	private ModelMapper modelMapper = new ModelMapper();
	private ObjectMapper mapper = new ObjectMapper();
	
	private AccountDto accountDto;
	private CustomerDto customerDto;
	private Customer customer;
	private Account account;
	
	@BeforeEach
	public void does() throws StreamReadException, DatabindException, IOException {
		
		accountDto = mapper.readValue(Account.class.getResourceAsStream("/account_object.json"), AccountDto.class);
		customerDto = mapper.readValue(Account.class.getResourceAsStream("/customer_object.json"), CustomerDto.class);
		account = modelMapper.map(accountDto, Account.class);
		customer = modelMapper.map(customerDto, Customer.class);
	}
	

	@Test
	void Get_Account_By_No() throws Exception {

		when(ser.getAccountByNo(accountDto.getAccountNo())).thenReturn(account);
		mvc.perform(get("/account/" + account.getAccountNo()).accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk());

	}

	@Test
	void Get_Customer_By_Civil_Id_BAD_REQUEST() throws Exception {

		when(ser.getCustomerByCid(customer.getCivilId())).thenReturn(customer);
		mvc.perform(get("/account/customer/" + customer.getCivilId()).accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isBadRequest());
	}

	@Test
	void Create_Account_Bad_Request() throws Exception {

		when(ser.getAccountByNo(accountDto.getAccountNo())).thenReturn(account);
		mvc.perform(post("/account").content(asJsonString(accountDto)).contentType(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isBadRequest());

	}
	
	
	@Test
	void Create_Customer_Ok_Request() throws Exception {

		when(ser.getAccountByNo(accountDto.getAccountNo())).thenReturn(account);
		mvc.perform(post("/account/customer").content(asJsonString(customerDto)).contentType(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isCreated());

	}

	private static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
}
