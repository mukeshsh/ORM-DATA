package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.repo.CustomeRepo;

@SpringBootApplication
public class DataProj9CallingProceduresApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		CustomeRepo cRepo=null;
		ctx=SpringApplication.run(DataProj9CallingProceduresApplication.class, args);
		cRepo=ctx.getBean(CustomeRepo.class);
		//invoked method
		//int count=cRepo.fetchCustomerByAddrs("Hyderabad");
		//System.out.println("Hyderabad Customer Count::"+count);
		cRepo.fetchCustomerDataByAddrs("Hyderabad").forEach(System.out::println);
	}
}
