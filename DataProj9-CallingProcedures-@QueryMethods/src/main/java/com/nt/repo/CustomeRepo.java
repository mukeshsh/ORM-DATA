package com.nt.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.Customer;

@Transactional
public interface CustomeRepo extends JpaRepository<Customer, Integer> {
	
	@Query(nativeQuery=true,value="{call GET_CUSTOMER_BY_ADDRS(?)}")
	    Iterable<Customer> fetchCustomerDataByAddrs(String addrs);
	
}
