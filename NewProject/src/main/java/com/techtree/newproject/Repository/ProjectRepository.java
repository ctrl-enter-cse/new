package com.techtree.newproject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.techtree.newproject.model.Employee;

@Repository
public interface ProjectRepository extends  JpaRepository<Employee,Long> {
	
	List<Employee> findByFnameOrLnameOrEmail(String fname,String lname ,String email);
	List<Employee> findByFnameContainingOrLnameContainingOrEmailContaining(String fname,String lname ,String email);
	List<Employee> findByFnameContaining(String fname);
//	List<Employee> findByFnameExacts(String fname);
//	
//	@Query("Select u from Employee u")
//	List<Employee> getallEmp();
//	
//	@Modifying
//	@Query("update  Employee e set e.fname=:n where e.id=:id ")
//	Integer  updateData(@Param("n") String name, @Param("id") Long id);
	
	
//	List<Employee> findByIdAndEmail();

//	List<Employee> findByFname
	
}
