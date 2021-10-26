package com.bankapp.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bankapp.demo.entity.Account;
import com.bankapp.demo.entity.User;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
	
	//@Query(" select accdetl from Account accdetl where accountNumber=:accountNumber")
	public Optional<Account> findByAccountNumber(@Param("accountNumber") long accountNumber);
	
	//Account findByUserId
	
	public Optional<Account> findByUserDetails(User user);
	
}
