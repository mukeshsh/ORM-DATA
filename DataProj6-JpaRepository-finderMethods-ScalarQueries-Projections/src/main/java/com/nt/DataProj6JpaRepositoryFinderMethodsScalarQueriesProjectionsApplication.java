package com.nt;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.repo.CustomerRepo;
import com.nt.repo.CustomerRepo.ResultsView1;
import com.nt.repo.CustomerRepo.ResultsView2;

@SpringBootApplication
public class DataProj6JpaRepositoryFinderMethodsScalarQueriesProjectionsApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		CustomerRepo custRepo=null;
		ctx=SpringApplication.run(DataProj6JpaRepositoryFinderMethodsScalarQueriesProjectionsApplication.class, args);
		custRepo=ctx.getBean(CustomerRepo.class);
		System.out.println(custRepo.getClass());
		/*List<ResultsView1> view1List=custRepo.findByCadd("Kolkata");
		for(ResultsView1 v :view1List) {
			System.out.println(v.getCno()+"  "+v.getCname());
		}*/
	/*	System.out.println("-------------------------------------");
		List<ResultsView2> listView2=custRepo.findByCnoBetween(101,104);
		/*for(ResultsView2 v :listView2) {
			System.out.println(v.getCname()+"  "+v.getBillAmt());
		}
		listView2.forEach(v->{
			System.out.println(v.getCname()+"   "+v.getBillAmt());
		});*/
		
		/*List<ResultsView1> view1List=custRepo.findByCadd("Varanasi",ResultsView1.class);
		for(ResultsView1 v :view1List) {
			System.out.println(v.getCname()+"  "+v.getCno());
		}*/
		/*
		List<ResultsView2> view2List=custRepo.findByCadd("Agra", ResultsView2.class);
		view2List.forEach(v->{
			System.out.println(v.getBillAmt()+"  "+v.getCname());
		});
		*/
		
		List<ResultsView1> view1List=custRepo.findByCadd("Varanasi",ResultsView1.class);
		for(ResultsView1 v :view1List) {
			System.out.println(v.getCname()+"  "+v.getCno());
		}
		List<ResultsView2> view2List=custRepo.findByCadd("Agra", ResultsView2.class);
		view2List.forEach(v->{
			System.out.println(v.getBillAmt()+"  "+v.getCname());
		});
		//close Container
		((ConfigurableApplicationContext) ctx).close();
	}
  
}
