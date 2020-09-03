package com.nt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

	//----------------------------static projection-----------------------------------------
	
	interface ResultsView1 extends View{
		Integer getCno();
		String getCname();
	}
	List<ResultsView1> findByCadd(String addrs);
	
	interface ResultsView2 extends View{
		String getCname();
		Double getBillAmt();
	}
	List<ResultsView2> findByCnoBetween(int min,int max);
	
	//-------------------------Dynamic Projections
	interface View{
		
	}
	//design the method with generics projections
	//<T>List<T> findByCadd(String addrs,Class<T> clazz);
	<T extends View>List<T>findByCadd(String addrs,Class<T>clazz);
}
