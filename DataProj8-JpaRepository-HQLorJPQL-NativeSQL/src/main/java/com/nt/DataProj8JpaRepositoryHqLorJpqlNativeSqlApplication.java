package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.repo.CustomeRepo;

@SpringBootApplication
public class DataProj8JpaRepositoryHqLorJpqlNativeSqlApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		CustomeRepo cRepo=null;
		ctx=SpringApplication.run(DataProj8JpaRepositoryHqLorJpqlNativeSqlApplication.class, args);
		cRepo=ctx.getBean(CustomeRepo.class);
		//System.out.println(cRepo.getCustomerByCname("Mukesh"));
		
		/*Object data=cRepo.getDataValuesByCname("Mukesh");
		Object data1[]=(Object[]) data;
		System.out.println(data1[0]+"  "+data1[1]+" "+ data1[2]);
		*/
		
		/*Double bAmt=cRepo.getBillAmtByCname("Mukesh");
		System.out.println("BillAmt::"+bAmt);
		*/
	   //System.out.println("Max Bill Amount::"+cRepo.findMaxBillAmt());
		/*Object[] rs=(Object[]) cRepo.findAggregateResults();
		System.out.println("Max BillAmt::"+rs[0]);
		System.out.println("Min BillAmt::"+rs[1]);
		System.out.println("Sum BillAmt::"+rs[2]);
		System.out.println("Avg BillAmt::"+rs[3]);
		System.out.println("No Of Records::"+rs[4]);
		*/
		
		//System.out.println("No of Records Updated::"+cRepo.modifyCustomerBillAmtByCity("Varanasi", 2000));
		System.out.println("No Of Records deleted::"+cRepo.deleteCustomersIfCnameIsNull());
		
		
	}

}
