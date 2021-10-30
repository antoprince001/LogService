package com.nullptrexception.backend.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nullptrexception.backend.Entity.TransactionStore;




@Repository 
public interface TransactionRepo extends JpaRepository<TransactionStore,String> {
	@Query("FROM TransactionStore WHERE borrowerUidHash=?1")
    List<TransactionStore> findByBorrower(String borrowerUidHash);
	
	@Query("FROM TransactionStore WHERE landLordUidHash=?1")
    List<TransactionStore> findByLandLord(String landLordUidHash);
	
	@Query("FROM TransactionStore WHERE borrowerUidHash=?1 and status=?2")
    List<TransactionStore> findByStatusLL(String landLordUidHash,int status);
	
	@Query("FROM TransactionStore WHERE borrowerUidHash=?1  and status=?2")
    List<TransactionStore> findByStatusBorrower(String borrowerUidHash,int status);
	
	@Query("FROM TransactionStore WHERE borrowerUidHash=?1  and landLordUidHash=?2")
    List<TransactionStore> findByBothInvolved(String borrowerUidHash,String landLordUidHash);
	
	@Query("FROM TransactionStore WHERE borrowerUidHash=?1  and landLordUidHash=?2 and status=?3")
    List<TransactionStore> findByBothInvolvedStatus(String borrowerUidHash,String landLordUidHash,int status);
	
}
