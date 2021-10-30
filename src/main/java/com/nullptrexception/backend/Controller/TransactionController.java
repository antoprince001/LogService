package com.nullptrexception.backend.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nullptrexception.backend.Entity.TransactionStore;
import com.nullptrexception.backend.Repositories.TransactionRepo;

@RestController
@CrossOrigin
public class TransactionController {

	
	//@Autowired
	TransactionRepo transRepo;
	
	
	@GetMapping("/transaction")
	public Optional<TransactionStore> findById(@RequestParam(name = "id") String id) {
		return transRepo.findById(id);
	}
	
	@GetMapping("/transactionsByLandLord")
	public List<TransactionStore> findByLandLordHash(@RequestParam(name = "id") String id) {
	
	    return transRepo.findByLandLord(id);
	}
	
	@GetMapping("/transactionsByBorrower")
	public List<TransactionStore> findByBorrowerHash(@RequestParam(name = "id") String id) {
	
	    return transRepo.findByBorrower(id);
	}
	
	@GetMapping("/transactionsByLandLordStatus")
	public List<TransactionStore> findByLandLordHashStatus(@RequestParam(name = "id") String id,@RequestParam(name = "status") int status) {
	
	    return transRepo.findByStatusLL(id,status);
	}
	
	@GetMapping("/transactionsByBorrowerStatus")
	public List<TransactionStore> findByBorrowerHashStatus(@RequestParam(name = "id") String id,@RequestParam(name = "status") int status) {
	
	    return transRepo.findByStatusBorrower(id,status);
	}
	
	
	@GetMapping("/transactionsByBoth")
	public List<TransactionStore> findByBoth(@RequestParam(name = "bid") String bid,@RequestParam(name = "lid") String lid) {
	
	    return transRepo.findByBothInvolved(bid,lid);
	}
	
	@GetMapping("/transactionsByBothStatusr")
	public List<TransactionStore> findByBothStatus(@RequestParam(name = "bid") String bid,@RequestParam(name = "lid") String lid,@RequestParam(name = "status") int status) {
	
	    return transRepo.findByBothInvolvedStatus(bid,lid,status);
	}
	
	
	
	
	// To create new transaction log in table as a row
	@ResponseBody
	@PostMapping("/logTransaction")
    public String addAsset(@RequestBody TransactionStore tx ) {
        
        try { 
        if(tx.getEntryYear() <1900 || tx.getEntryYear() > 3000){
        	return "Invalid year";
        }
        if(tx.getEntryDay() > 31 || tx.getEntryDay() < 1) {
        	return "Invalid Date";
        }
        if(tx.getEntryMonth() > 12 || tx.getEntryMonth() < 1) {
        	return "Invalid Month";
        }
        if(transRepo.existsById(tx.getTxnID())){
            //Throw your Exception
        	throw new Exception();
        }
        transRepo.save(tx);
        return "Transaction with id : "+tx.getTxnID()+" is successful";
        }
        catch(Exception e) {
        	
        	System.out.println(e.getMessage());
        	return "Error with transaction:"+tx.getTxnID();
        }
        
    }
	
//	@GetMapping("/transactionbydate")
//	public List<Transaction> getAssetByDate(@RequestParam(name="year") int year,@RequestParam(name="month") int month) {
//		
//	    return assetRepository.findByDate(month,year);
//	}
//	
}
