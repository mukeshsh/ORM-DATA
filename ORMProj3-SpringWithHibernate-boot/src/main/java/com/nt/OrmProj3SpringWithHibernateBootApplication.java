package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.dto.ProjectDTO;
import com.nt.service.ProjectMgmtService;

@SpringBootApplication
public class OrmProj3SpringWithHibernateBootApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		ProjectMgmtService service=null;
		ProjectDTO dto=null;
		ctx= SpringApplication.run(OrmProj3SpringWithHibernateBootApplication.class, args);
		service=ctx.getBean("projService", ProjectMgmtService.class);
		try {
			   //create DTO
			     dto = new ProjectDTO();
			    dto.setProjName("openFx2"); dto.setTeamSize(13);
			    dto.setCompany("POLARIS1"); dto.setCost(100000000.0);
			    dto.setLocation("hyd1");
			   //use service
			   System.out.println(service.registerProject(dto));
			}
			catch(DataAccessException dae) {
			   dae.printStackTrace();
			}
			
         ((AbstractApplicationContext) ctx).close();
	}

}
