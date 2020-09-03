package com.nt.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nt.entity.Customer;

public interface CustomeRepo extends JpaRepository<Customer, Integer> {
	
	//select bulk operations with positional params(Entity Queries)
	
	/*
	  @Query("FROM Customer") 
	   Iterable<Customer> getAllCustomers();
	 */
	
	/*
	  @Query("FROM Customer where cadd=?1") Iterable<Customer>
	  getCustomerByCity(String Addrs);
	 */
	
	/*
	  @Query("FROM Customer where billAmt>=?1 AND billAmt<=?2") Iterable<Customer>
	  getCustomerByBillAmtRange(double min,double max);
	 */
	
	//select Bulk Operations Through Named params(All col values)
	
	/*
	  @Query("From Customer where cname=:name") Iterable<Customer>
	   getCustomersByName(String name);
	 */
	
	/*
	  @Query("From Customer where cadd in(:city1,:city2,:city3)")
	  Iterable<Customer> getCustomersByCityNames(String city1,String city2,String city3);
	 */
	
	/*
	  @Query("From Customer where cadd in(:city1,:city2,:city3)")
	  Iterable<Customer> getCustomersByCityNames(@Param("city1")String cityOne,
	                                                                                              @Param("city2")String cityTwo,
	                                                                                              @Param("city3")String cityThree);
	 */
	
	 /*@Query("FROM Customer  WHERE cno>=?1 and cno<=:max")    //invalid query in single row operation we never use both queries at a single select query
	   Iterable<Customer>  getCustomersByCnoRange(Integer min ,@Param("max")Integer end); */
	
	 
	//Bulk Operations Through Named(Projections)

	/*@Query("SELECT cno,cname FROM Customer WHERE cadd=:city")
     	Iterable<Object[]> getDataValueByCity(String city);
	*/
	@Query("SELECT billAmt FROM Customer WHERE cadd IN(:cityOne,:cityTwo,:cityThree)")
	Iterable<Double> geBillAmtByCityNames(@Param("cityOne")String city1,
			                                                                        @Param("cityTwo")String city2,
			                                                                        @Param("cityThree")String city3);

}
