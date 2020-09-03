package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.repo.CustomeRepo;

@SpringBootApplication
public class DataProj7JpaRepositoryQueryMethodsApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		CustomeRepo custRepo=null;
		ctx=SpringApplication.run(DataProj7JpaRepositoryQueryMethodsApplication.class, args);
		custRepo=ctx.getBean(CustomeRepo.class);
		//custRepo.getAllCustomers().forEach(System.out::println);
		//custRepo.getCustomerByCity("Varanasi").forEach(System.out::println);
		//custRepo.getCustomerByBillAmtRange(1000, 30000).forEach(System.out::println);
		//custRepo.getCustomersByName("Mukesh").forEach(System.out::println);
		//custRepo.getCustomersByCityNames("Varanasi", "Agra", "Mumbai").forEach(System.out::println);
		//custRepo.getCustomersByCnoRange(1, 3).forEach(System.out::println);
		//custRepo.getDataValueByCity("Agra").forEach(System.out::println);
		/*custRepo.getDataValueByCity("Agra").forEach(row->{
			//System.out.println(row[0]+" "+row[1]);
			for(Object val :row) {
				System.out.print(val+"  ");
			}
			System.out.println();
		});*/
		custRepo.geBillAmtByCityNames("Agra", "Varanasi", "Hyderabad").forEach(System.out::println);
		((ConfigurableApplicationContext) ctx).close();
	}

}
