package com.nullptrexception.backend.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table
public class TransactionStore {
	
	@Id
	@Column(unique=true)
    private String txnID;
	
	@Column(nullable = false)
	private String borrowerUidHash;
	
	@Column(nullable = false)
	private String landLordUidHash;
	
	@Column(nullable = false)
	private int status; // Pending : 0, Accepted : 1 , Rejected : -1 , AddressReqForMinorChange  : 2 , AdmitMinorChange : 3 , RejectMinorChange : 4 
	
	@Column(nullable = false)
	private int entryDay;
	
	@Column(nullable = false)
	private int entryMonth;
	
	@Column(nullable = false)
	private int entryYear;
	
	@Column(nullable = false)
	private int entryHour;
	
	@Column(nullable = false)
	private int entryMinute;
	
	@Column(nullable = false)
	private int category; 
	
	
	public String getTxnID() {
		return txnID;
	}

	public void setTxnID(String txnID) {
		this.txnID = txnID;
	}

	public String getBorrowerUidHash() {
		return borrowerUidHash;
	}

	public void setBorrowerUidHash(String borrowerUidHash) {
		this.borrowerUidHash = borrowerUidHash;
	}

	public String getLandLordUidHash() {
		return landLordUidHash;
	}

	public void setLandLordUidHash(String landLordUidHash) {
		this.landLordUidHash = landLordUidHash;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getEntryDay() {
		return entryDay;
	}

	public void setEntryDay(int entryDay) {
		this.entryDay = entryDay;
	}

	public int getEntryMonth() {
		return entryMonth;
	}

	public void setEntryMonth(int entryMonth) {
		this.entryMonth = entryMonth;
	}

	public int getEntryYear() {
		return entryYear;
	}

	public void setEntryYear(int entryYear) {
		this.entryYear = entryYear;
	}

	public int getEntryHour() {
		return entryHour;
	}

	public void setEntryHour(int entryHour) {
		this.entryHour = entryHour;
	}

	public int getEntryMinute() {
		return entryMinute;
	}

	public void setEntryMinute(int entryMinute) {
		this.entryMinute = entryMinute;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	
	/*
	 * Borrower Request - 0
	 * Suspicious Request - 1
	 * Required address not in landlord aadhaar - 2
	 * spam request - 3
	 * 
	 */

}

