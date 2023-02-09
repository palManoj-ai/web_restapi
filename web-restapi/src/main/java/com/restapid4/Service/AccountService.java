package com.restapid4.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mysql.cj.x.protobuf.MysqlxCrud.Order;
import com.restapid4.Repository.AccountRepository;
import com.restapid4.model.AccountModel;

@Service
public class AccountService {
	//service layer

	@Autowired
	private AccountRepository accountRepository;
	
	//creating try catch block
	public void save(AccountModel accountModel) {
			accountRepository.save(accountModel);	
	}

	public AccountModel getUserByEmail(String useremail) {
		return accountRepository.findByEmail(useremail).get();
		//remember .get() with optional<>
		//see exception returned in case .get() is false
	}

//	public void deleteUserByEmail(String emailToDelete) {
//		accountRepository.deleteByEmail(emailToDelete);
//	}

//	public void deleteByUsername(String userName) {
//		accountRepository.deleteByusername(userName);
//	}

	public void update( AccountModel accountModel) {
		accountRepository.save(accountModel);
		
	}

	public AccountModel getUserById(Long id) {
		return accountRepository.findById(id).get();
	}

	public void deleteByEmail(String email) {
		accountRepository.deleteByEmail(email);
		
	}

	public List<AccountModel> fetchAll() {
		return accountRepository.findAll();
	}

	public List<AccountModel>  sortList(String columnName, String order) {
		List<AccountModel> sortedList=new ArrayList<AccountModel>();
		if(order.equalsIgnoreCase("asc")) {
			sortedList=accountRepository.findAll(Sort.by(Sort.Direction.ASC, columnName));
		}else if(order.equalsIgnoreCase("desc")) {
			sortedList=accountRepository.findAll(Sort.by(Sort.Direction.DESC, columnName));
		}else {
			//
		}
		return sortedList;
			
	}

//	public List<AccountModel> filteredList(String columnName, String criteria) {
//		accountRepository.filter
//		return null;
//	}
	
	
	

}

