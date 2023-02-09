package com.restapid4.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.restapid4.Service.AccountService;
import com.restapid4.dto.UserAccountDTO;
import com.restapid4.model.AccountModel;

@RestController
@RequestMapping("/userdbms")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	//Implementing CRUD operations for UserAccount
	
	//1. CREATE NEW USER ACCOUNT WITH POSTMAPPING
	@PostMapping("/create")
	@ResponseStatus(value = HttpStatus.CREATED)
	public void createAccount(@RequestBody UserAccountDTO user) {
		AccountModel accountModel=new AccountModel();
		BeanUtils.copyProperties(user, accountModel);
		accountService.save(accountModel);
	}
	
	//2. GET BY USER EMAIL
	@GetMapping("/fetch/{useremail}")
	@ResponseStatus(value = HttpStatus.OK)
	public UserAccountDTO getByEmail(@PathVariable (name = "useremail") String email) {
		UserAccountDTO userDetails=new UserAccountDTO();
		BeanUtils.copyProperties(accountService.getUserByEmail(email), userDetails);
		return userDetails;
	}
	
	
	//3. GET ALL
	@GetMapping("/fetch/all")
	@ResponseStatus(value = HttpStatus.OK)
	public List<UserAccountDTO> getAll() {
		List<UserAccountDTO> userDetails=new ArrayList<UserAccountDTO>();
		List<AccountModel> userDetailsModel= accountService.fetchAll();
		for(AccountModel entity:userDetailsModel) {
			UserAccountDTO user=new UserAccountDTO();
			BeanUtils.copyProperties(entity, user);
			userDetails.add(user);
		}
		return userDetails;
	}
	
		
	//4. UPDATE ONE ENTRY
	@PutMapping("/update/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public UserAccountDTO updateAccount(@RequestBody UserAccountDTO user, @PathVariable (name="id") Long id) {
		//try using @requestparam for id , error message : long parameter id not found
			AccountModel accountModel=accountService.getUserById(id);
			accountModel.setUserName(user.getUserName());
			accountModel.setAccountType(user.getAccountType());
			accountModel.setAddress(user.getAddress());
			accountModel.setInitialBalance(user.getInitialBalance());
			accountModel.setPhone(user.getPhone());
			accountModel.setSsn(user.getSsn());
			accountModel.setEmail(user.getEmail());
			accountService.save(accountModel);
			
			UserAccountDTO modifiedUser=new UserAccountDTO();
			BeanUtils.copyProperties(accountModel, modifiedUser);
			return modifiedUser;
	}
	
	//5. Delete one entry
	@DeleteMapping(path = "/delete")
	@ResponseStatus(value = HttpStatus.OK)
	public void deleteAccount(@RequestParam (name = "email") String email) {
		//try removing @transactional in accountRepository deleteByEmail method
		//error: https://stackoverflow.com/questions/32269192/spring-no-entitymanager-with-actual-transaction-available-for-current-thread
		//error: no entitymanager with actual transaction avl.
		accountService.deleteByEmail(email);
	}
	
	
	//5. Sort 
	//https://localhost:4444/userdbms/sort?by=colname&order=ord
	@GetMapping("/sort")
	public List<UserAccountDTO> getSortedList(@RequestParam (name="by") String columnName,@RequestParam (name = "order") String order){
		List<AccountModel> listModel=accountService.sortList(columnName,order);
		List<UserAccountDTO> listDTO=new ArrayList<UserAccountDTO>();
		for(AccountModel model:listModel) {
			UserAccountDTO user=new UserAccountDTO();
			BeanUtils.copyProperties(model, user);
			listDTO.add(user);
		}
		return listDTO;	
	}
	
	
	//6. Filter output
	////https://localhost:4444/userdbms/filter?by=colname&criteria=value
//	@GetMapping("/filter")
//	public List<UserAccountDTO> getFilteredList(@RequestParam (name="by") String columnName, @RequestParam ("criteria") String criteria){
//		List<AccountModel> filteredListModel=accountService.filteredList(columnName,criteria);
//	}
	
	
	
	
	
	
	

}
