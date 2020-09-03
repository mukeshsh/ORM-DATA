package com.nt;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.repo.DoctorRepo;

@SpringBootApplication
public class DataProj4JpaRepositoryFinderMethodsEntityQueriesApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		DoctorRepo docRepo=null;
		ctx=SpringApplication.run(DataProj4JpaRepositoryFinderMethodsEntityQueriesApplication.class, args);
		docRepo=ctx.getBean(DoctorRepo.class);
		//docRepo.findBySalaryBetween(20000, 30000).forEach(System.out::println);
		//docRepo.findBySalaryGreaterThanEqualAndSalaryLessThanEqual(20000, 40000).forEach(System.out::println);
		//docRepo.findBydNameEqualsOrPersonalAddrsEquals("Sanjay", "Goa").forEach(System.out::println);
		//docRepo.findBySalaryBetweenOrderByD_ID(20000, 40000).forEach(System.out::println);unable to solve
		//docRepo.findBySalaryBetweenOrderBydNameDesc(20000, 40000).forEach(System.out::println);
		//docRepo.findByPersonalAddrsNot("jaunpur").forEach(System.out::println);
		//docRepo.findByPersonalAddrsIn(List.of("jaunpur", "Bihar", "Goa")).forEach(System.out::println);
		docRepo.findBydName("Sanjay").forEach(System.out::println);
		
		
	}

}
