package com.nt.repo;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Doctor;

public interface DoctorRepo extends JpaRepository<Doctor, Integer> {
	//SQL> SELECT D_ID,HOSLOCATION,D_NAME,EMAIL,MOB,PERSONAL_ADDRS,SALARY FROM DOCTOR WHERE SALARY BETWEEN 20000 AND 30000;	
	//Iterable<Doctor>findBySalaryBetween(double start,double end);
	//SQL> SELECT D_ID,HOSLOCATION,D_NAME,EMAIL,MOB,PERSONAL_ADDRS,SALARY FROM DOCTOR WHERE SALARY>=20000 AND SALARY<=40000;
	//List<Doctor> findBySalaryGreaterThanEqualAndSalaryLessThanEqual(double min,double max);
	//SQL> SELECT D_ID,HOSLOCATION,D_NAME,EMAIL,MOB,PERSONAL_ADDRS,SALARY FROM DOCTOR WHERE D_NAME='Sanjay' OR PERSONAL_ADDRS='Goa';
	//Iterable<Doctor> findBydNameEqualsOrPersonalAddrsEquals(String name,String addrs);
	//SQL> SELECT D_ID,HOSLOCATION,D_NAME,EMAIL,MOB,PERSONAL_ADDRS,SALARY FROM DOCTOR WHERE SALARY BETWEEN 20000 AND 40000 ORDER BY 'D_ID';
  //  Iterable<Doctor> findBySalaryBetweenOrderByD_ID(double min,double max);
    //Iterable<Doctor> findBySalaryBetweenOrderBydNameDesc(double min,double max);
	//SQL> SELECT D_ID,HOSLOCATION,D_NAME,EMAIL,MOB,PERSONAL_ADDRS,SALARY FROM DOCTOR WHERE PERSONAL_ADDRS<>'jaunpur';
	//SQL> SELECT D_ID,HOSLOCATION,D_NAME,EMAIL,MOB,PERSONAL_ADDRS,SALARY FROM DOCTOR WHERE PERSONAL_ADDRS!='jaunpur';
   //Iterable<Doctor> findByPersonalAddrsNot(String Addrs);
	//SQL> SELECT D_ID,HOSLOCATION,D_NAME,EMAIL,MOB,PERSONAL_ADDRS,SALARY FROM DOCTOR WHERE PERSONAL_ADDRS IN('Jaunpur','Goa','Varanasi');
	//Iterable<Doctor> findByPersonalAddrsIn(Collection<String> cities);
	//SQL> SELECT D_ID,HOSLOCATION,D_NAME,EMAIL,MOB,PERSONAL_ADDRS,SALARY FROM DOCTOR WHERE PERSONAL_ADDRS IN('Jaunpur','Goa','Varanasi');
	Iterable<Doctor> findBydName(String name);
}

