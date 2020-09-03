package com.nt;

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
		//docRepo.findBydName("Sanjay").forEach(System.out::println);
		//docRepo.findByHoslocation("Varanasi").forEach(System.out::println);
		//docRepo.findBySalary(54000.0).forEach(System.out::println);
		//docRepo.findByemail("sj@gmail.com").forEach(System.out::println);
		//docRepo.findByPersonalAddrs("Rajapur").forEach(System.out::println);
		//docRepo.findByhoslocation("Jaunpur").forEach(System.out::println);
		//docRepo.findBySalaryGreaterThan(40000.0).forEach(System.out::println);
		//docRepo.findBySalaryLessThan(30000.0).forEach(System.out::println);
		//docRepo.findBydNameLike("%h").forEach(System.out::println);
		//docRepo.findBydNameLike("M%").forEach(System.out::println);
		//docRepo.findBydNameStartingWith("S").forEach(System.out::println);
		//docRepo.findBydNameEndingWith("a").forEach(System.out::println);
		//docRepo.findBydNameLike("%e%").forEach(System.out::println);
		//docRepo.findBydNameContaining("e").forEach(System.out::println);
		//docRepo.findBydNameIsNull().forEach(System.out::println);
		//docRepo.findBydNameNotNull().forEach(System.out::println);
		//docRepo.findBydNameIsNotNull().forEach(System.out::println);
		//docRepo.findBydNameLike("____").forEach(System.out::println);
		//docRepo.findBydNameLike("____%").forEach(System.out::println);
	}

}
