package com.nt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.dto.CustomerDTO;
import com.nt.service.CustomerMgmtService;

@SpringBootApplication
public class DataProj1BootApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		CustomerMgmtService service=null;
		CustomerDTO dto=null,dto1=null,dto2=null,dto3=null;
		List<CustomerDTO> listDTO=null;
		ctx=SpringApplication.run(DataProj1BootApplication.class, args);
		service=ctx.getBean("custService", CustomerMgmtService.class);
		//invoked
		/*
		  try {
		   dto=new CustomerDTO(); 
		  dto.setCname("Shiva");
		  dto.setCadd("Kanpur");
		  dto.setBillAmt(45600); 
		  System.out.println(service.customerRegister(dto)); }
		  catch(DataAccessException dae) {
			  dae.printStackTrace();
			  }
		  ((AbstractApplicationContext) ctx).close();
		 */
		/*System.out.println("----------------------------------");
		dto=new CustomerDTO();
		dto.setCname("Pankaj");dto.setCadd("Agra");dto.setBillAmt(25890);
		dto1=new CustomerDTO();
		dto1.setCname("MayaShankar");dto1.setCadd("Rajapur");dto1.setBillAmt(22500);
		dto2=new CustomerDTO();
		dto2.setCname("Suraj");dto2.setCadd("MP");	dto2.setBillAmt(30405);
		dto3=new CustomerDTO();
		dto3.setCname("Kanika");dto3.setCadd("Jhansi");dto3.setBillAmt(56000);
		try {
			//System.out.println(service.groupRegisterCustomer(Arrays.asList(dto,dto1,dto2,dto3)));//old
			System.out.println(service.groupRegisterCustomer(List.of(dto, dto1, dto2,dto3)));//java9
			listDTO=new ArrayList<CustomerDTO>();
			listDTO.add(dto);listDTO.add(dto1);listDTO.add(dto2);listDTO.add(dto3);
			//System.out.println(service.groupRegisterCustomer(listDTO));//old
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}*/
	/*	System.out.println("---------------------------------------------");
		System.out.println("Delete Customers :"+service.removeCustomerById(17));*/
		/*System.out.println("----------------------------------------------");
		System.out.println("Delete few Customers::"+service.removeBulkCustomers(List.of(new CustomerDTO(11),new CustomerDTO(12))));
		*/
		/*System.out.println("-----------------------------------------------------");
		System.out.println("No Of Customer Present::"+service.fetchCountRecords());*/
		System.out.println("---------------------------------------------------");
		//System.out.println("Fetch All Customer records :"+service.fetchAllCustmores());
		//service.fetchAllCustmores().forEach(System.out::println);//java8
		service.fetchAllCustmores().forEach(dt->{
			System.out.println(dt);
		});
		((AbstractApplicationContext) ctx).close();
	}
}
