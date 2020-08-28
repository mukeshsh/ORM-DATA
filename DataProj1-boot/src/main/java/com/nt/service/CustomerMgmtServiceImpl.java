package com.nt.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dto.CustomerDTO;
import com.nt.entity.Customer;
import com.nt.repo.CustomerRepo;

@Service("custService")
public class CustomerMgmtServiceImpl implements CustomerMgmtService {

	@Autowired
	private CustomerRepo custRepo;
	
	@Override
	public String customerRegister(CustomerDTO dto) {
		System.out.println(custRepo.getClass()+"---->"+Arrays.toString(custRepo.getClass().getInterfaces()));
		Customer cust=null;
		//convert dto to entity
		cust=new Customer();
		BeanUtils.copyProperties(dto,cust);
		//use repo
		cust=custRepo.save(cust);
		return  cust!=null?"Object saved with id :"+cust.getCno():"Object not saved";
		
	}

	@Override
	public String groupRegisterCustomer(List<CustomerDTO> listDTO) {
     List<Customer> listEntities=new ArrayList();
     List<Customer> listEntities1=null;
     String ids=new String();
     //convert listDto to listEntites
     listDTO.forEach(dto->{
    	 Customer entity=new Customer();
    	 BeanUtils.copyProperties(dto, entity);
    	 listEntities.add(entity);
     });
     //use repository
     listEntities1=(List<Customer>) custRepo.saveAll(listEntities);
  /* for(Customer e:listEntities1) {
    	 ids=ids+",  "+e.getCno();
    	 }*/
    	 ids=listEntities1.stream().map(e->e.getCno()).collect(Collectors.toList()).toString();
     
		return listEntities1!=null?"Batch insertion done with ide's"+ids:" Batch insertion is not done";
	}

	@Override
	public String removeCustomerById(int cno) {
     boolean flag=false;
     flag=custRepo.existsById(cno);
     if(flag)
    	 custRepo.deleteById(cno);
		return  flag?cno+" customer is deleted":"customer not exist";
	}

	@Override
	public String removeBulkCustomers(Iterable<CustomerDTO> itDTO) {
     Iterable<Customer> itEntities=new ArrayList();
     itDTO.forEach(dto->{
    	 Customer cst=new Customer(); 
    	 BeanUtils.copyProperties(dto, cst);
    	 ((List<Customer>) itEntities).add(cst);
     });
		//use repo
     custRepo.deleteAll(itEntities);
     return "Bulk Records are deleted";
	}

	@Override
	public long fetchCountRecords() {
       //use repo
		return   custRepo.count();
	}

	@Override
	public Iterable<CustomerDTO> fetchAllCustmores() {
      Iterable<Customer> itCust=null;
      Iterable<CustomerDTO> itDTO=new ArrayList();
		//use repo
      itCust=custRepo.findAll();
      //convert list entity to listdto
      itCust.forEach(entity->{
    	  CustomerDTO dto=new CustomerDTO();
    	  BeanUtils.copyProperties(entity, dto);
    	  ((List<CustomerDTO>) itDTO).add(dto);
      });
		return itDTO;
	}

}
