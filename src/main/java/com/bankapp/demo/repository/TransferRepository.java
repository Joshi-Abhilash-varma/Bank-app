package com.bankapp.demo.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bankapp.demo.entity.Transaction;

@Repository
public interface TransferRepository extends JpaRepository<Transaction, Long>{
	
	public List<Transaction> findByAccountNumber(Long accountNumber);
	
	@Query(value="select * from transaction  where account_number=:fromaccount and transaction_date between :transdate1 and :transdate2", nativeQuery=true)
	public List<Transaction> getTransDataByaccountNumberAndDate(@Param("fromaccount")long fromAccount,@Param("transdate1") Timestamp transdate1, @Param("transdate2")Timestamp transdate2);
	
	//public Boolean transferByMobileNumber(String mobileNumber);
}
