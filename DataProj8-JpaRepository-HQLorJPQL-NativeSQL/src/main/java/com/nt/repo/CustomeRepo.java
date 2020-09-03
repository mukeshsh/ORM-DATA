package com.nt.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.Customer;

@Transactional
public interface CustomeRepo extends JpaRepository<Customer, Integer> {
	
	//Single row select operations using HQL/JPQL(Entity Query)
	/*@Query("From Customer where cname:name")
	Customer getCustomerByCname(String name);
	*/
	
	/*@Query("Select cno,cadd,billAmt from Customer where cname=:name")
	Object getDataValuesByCname(String name);
	*/
	
	/*
	@Query("Select billAmt from Customer where cname=:name")
	Double getBillAmtByCname(String name);
	*/
	
	//---------------Select Query Aggregate function-------------------------
	/*@Query("Select max(billAmt) from Customer")
	Double findMaxBillAmt();
	*/
	
	/*@Query("Select max(billAmt),min(billAmt),sum(billAmt),avg(billAmt),count(*) from Customer")
	Object findAggregateResults();
	*/
	//---------------------------------update operation-------------------
	@Modifying
	@Query("update Customer set billAmt=billAmt+ :extraAmt where cadd=:city")
	int modifyCustomerBillAmtByCity(String city,double extraAmt);
	    
	    //-------------------delete operation
	@Modifying
	@Query("delete from Customer where cname is Null")
	int deleteCustomersIfCnameIsNull();
}
