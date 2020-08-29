package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.dto.DoctorDTO;
import com.nt.service.DoctorMgmtService;

@SpringBootApplication
public class DataProj3JpaRepositoryDirectMethodsApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		DoctorMgmtService service=null;
		DoctorDTO dto=null;
		ctx=SpringApplication.run(DataProj3JpaRepositoryDirectMethodsApplication.class, args);
		service=ctx.getBean("docService", DoctorMgmtService.class);
	/*	dto=new DoctorDTO();
		//dto.setSalary(54000.0);
		//dto.setPersonalAddrs("jaunpur");
		service.fetchAllGivenRecordsByExample(dto).forEach(System.out::println);
		*/
		System.out.println("--------------------------------------");
		System.out.println(service.removeAllDoctors());
	}

}
