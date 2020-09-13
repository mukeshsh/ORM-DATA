package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.repo.CustomeRepo;

@SpringBootApplication
public class DataProj10CallingProceduresApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		CustomeRepo cRepo=null;
		ctx=SpringApplication.run(DataProj10CallingProceduresApplication.class, args);
		cRepo=ctx.getBean(CustomeRepo.class);
		//invoked method
		/*int count=cRepo.fetchCustomerCountByAddrs("Hyderabad");
		System.out.println("Hyderabad Customer Count::"+count);
		*/
		int count=cRepo.GET_CUSTOMERS_COUNT_BY_ADDRS("Mumbai");
		System.out.println("No Of Customers In Given Location::"+count);
		
		//close container
		((ConfigurableApplicationContext) ctx).close();
	}
}
