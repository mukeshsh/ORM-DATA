package com.nt.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.dto.ProjectDTO;
import com.nt.service.ProjectMgmtService;

public class ORMHibernateTest {

	public static void main(String[] args) {
		   ApplicationContext ctx=null;
		   ProjectMgmtService  service=null;
		   ProjectDTO dto=null;
		   //create IOC container
		   ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		   
		   //get Service class object
		   service=ctx.getBean("projService",ProjectMgmtService.class);
		/*   try {
			   //create DTO
			    dto=new ProjectDTO();
			    dto.setProjName("Power System"); 
			    dto.setTeamSize(40);
			    dto.setCompany("Wipro"); 
			    dto.setCost(1370000.0);
			    dto.setLocation("Mumbai");
			   //use service
			   System.out.println(service.registerProject(dto));
		   }
		   catch(DataAccessException dae) {
			   dae.printStackTrace();
		   }*/
		   /*System.out.println("--------------------------------------------------");
		   System.out.println("Project Details::"+service.fetchRecordsById(7));
		   */
		  /* System.out.println("---------------------------------------------");
		   System.out.println("Project Updation::"+service.updateProectById(5, 41, 4000000));
		   */
		 /*  System.out.println("-------------------------------------------------");
		   System.out.println("Project deletion::"+service.removeProjectById(3));
		   */
		   System.out.println("-----------------------------------------------------");
		   List<ProjectDTO> listDTO=service.fetchRecordsByRange(1000000, 4000000);
		   listDTO.forEach(dto1->{
			   System.out.println(dto1);//for Each
		   });
		   System.out.println("-----------------------------------");
		   listDTO.forEach(System.out::println);//method reference
		   System.out.println("----------------------------");
		   System.out.println(listDTO);//toString()
		   System.out.println("-------------------------------");
		   listDTO.stream().forEach(System.out::println);//stream api
	//close container
		   ((AbstractApplicationContext) ctx).close();

	}//main
}//class
