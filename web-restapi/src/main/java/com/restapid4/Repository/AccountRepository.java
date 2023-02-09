package com.restapid4.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.restapid4.model.AccountModel;

@Repository
public interface AccountRepository extends JpaRepository<AccountModel, Long>{

	//custom implementation for findByEmail
	public Optional<AccountModel> findByEmail(String useremail);
	
	@Transactional
	public void deleteByEmail(String email);

}
