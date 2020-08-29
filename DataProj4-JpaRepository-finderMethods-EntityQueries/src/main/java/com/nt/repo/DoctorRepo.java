package com.nt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Doctor;

public interface DoctorRepo extends JpaRepository<Doctor, Integer> {
	 /*select d_id,hoslocation,d_name,email,mob,personal_addrs,salary from doctor where d_name='Sanjay';
    =>if no condition is taken default condition is Where with  " is " or "="  
    if wrong property name is given in findByXxx method then we get 
           "Invalid derived query! No property dName1 found for type Doctor! Did you mean 'dName'" 
	       */
	      // List<Doctor> findBydName(String cname);
	    
	/*//select d_id,hoslocation,d_name,email,mob,personal_addrs,salary from doctor where hoslocation='Manali';
	         
	          List<Doctor> findByHoslocation(String addrs);
	      */
	
	/*//select d_id,hoslocation,d_name,email,mob,personal_addrs,salary from doctor where salary=23789;
	//List<Doctor>findBySalary(Double sal);
	 */
	
	/*//SQL> select d_id,hoslocation,d_name,email,mob,personal_addrs,salary from doctor where email='ss@gmail.com';
	List<Doctor> findByemail(String mail);
	*/
	
	/*//SQL> select d_id,hoslocation,d_name,email,mob,personal_addrs,salary from doctor where personal_Addrs='Rajapur';
	List<Doctor> findByPersonalAddrs(String personalAddrs);
	*/
	
	/*//SQL> select d_id,hoslocation,d_name,email,mob,personal_addrs,salary from doctor where salary>=40000;
	      List<Doctor>findBySalaryGreaterThan(Double salary);
	*/
	
	/*
	//SQL> SELECT D_ID,HOSLOCATION,D_NAME,EMAIL,MOB,PERSONAL_ADDRS,SALARY FROM DOCTOR WHERE SALARY<=30000;
	   List<Doctor>findBySalaryLessThan(Double salary);
	   */
	
	/*//SQL> SELECT D_ID,HOSLOCATION,D_NAME,EMAIL,MOB,PERSONAL_ADDRS,SALARY FROM DOCTOR WHERE d_Name like '%h';
	    Iterable<Doctor>findBydNameLike(String lastChars);
	*/
	
	/*//SQL> SELECT D_ID,HOSLOCATION,D_NAME,EMAIL,MOB,PERSONAL_ADDRS,SALARY FROM DOCTOR WHERE d_Name like 'M%';
	       List<Doctor> findBydNameLike(String initChars);
	 */
	//List<Doctor> findBydNameStartingWith(String initChars);
	//List<Doctor>findBydNameEndingWith(String lastChars);
	
	/*//SQL> SELECT D_ID,HOSLOCATION,D_NAME,EMAIL,MOB,PERSONAL_ADDRS,SALARY FROM DOCTOR WHERE d_Name like '%e%';
       List<Doctor>findBydNameContaining(String chars);
    */
	
	/*//SQL> SELECT D_ID,HOSLOCATION,D_NAME,EMAIL,MOB,PERSONAL_ADDRS,SALARY FROM DOCTOR WHERE d_Name like '%e%';
	List<Doctor>findBydNameLike(String chars);
	List<Doctor>findBydNameContaining(String chars);
	*/
	/*//SQL> SELECT D_ID,HOSLOCATION,D_NAME,EMAIL,MOB,PERSONAL_ADDRS,SALARY FROM DOCTOR WHERE D_NAME IS NULL;
	List<Doctor>findBydNameIsNull();
	*/
	//SQL> SELECT D_ID,HOSLOCATION,D_NAME,EMAIL,MOB,PERSONAL_ADDRS,SALARY FROM DOCTOR WHERE D_NAME IS NOT NULL;
	  Iterable<Doctor> findBydNameIsNotNull();
	//Iterable<Doctor>findBydNameNotNull();
}
