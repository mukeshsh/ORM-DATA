package com.nt.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import com.nt.entity.Customer;

@Transactional
public interface CustomeRepo extends JpaRepository<Customer, Integer> {
	
	/*@Procedure(procedureName = "GET_CUSTOMERS_COUNT_BY_ADDRS")
	             int fetchCustomerCountByAddrs(String addrs);
	*/
	  @Procedure
	        int GET_CUSTOMERS_COUNT_BY_ADDRS(String addrs);
}
