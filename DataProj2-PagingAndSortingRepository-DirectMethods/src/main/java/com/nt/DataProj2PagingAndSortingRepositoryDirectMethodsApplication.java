package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.nt.service.DoctorMgmtService;

@SpringBootApplication
public class DataProj2PagingAndSortingRepositoryDirectMethodsApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		DoctorMgmtService service=null;
		
		//IOC Conatiner
	    ctx=SpringApplication.run(DataProj2PagingAndSortingRepositoryDirectMethodsApplication.class, args);
	    //get service class
	    service=ctx.getBean("docService", DoctorMgmtService.class);
	    //invoked b. method
	   // service.fetchAllRecordsSortByProperty("dId",true).forEach(System.out::println);
	    /*System.out.println("-----------------------------------------------------------");
	    service.fetchAllREcordsSortByProperties(true, "dName","email","salary").forEach(System.out::println);
	    */
	   /* System.out.println("-----------------------------------------");
	    service.fetchRecordsBypageNoAndPageSize(0, 4).forEach(System.out::println);
	    */
	    System.out.println("-------------------------------------------------");
	    service.fetchRecordsByPagination(2);
	    ((AbstractApplicationContext) ctx).close();
	}

}
