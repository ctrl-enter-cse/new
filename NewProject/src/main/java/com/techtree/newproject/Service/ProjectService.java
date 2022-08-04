package com.techtree.newproject.Service;




import org.springframework.http.ResponseEntity;

import com.techtree.newproject.model.EmpBean;






public interface ProjectService {

	public ResponseEntity<Object> saveEmployee(EmpBean employee);

	public ResponseEntity<Object> getemployeelist();

	public ResponseEntity<Object> getemployeebyid(long id);

	public ResponseEntity<Object> deleteEmployee(long id);

	ResponseEntity<Object> Searchdataexact(String data1,String data2,String data3);
	
	ResponseEntity<Object> SearchdataLikes(String data1,String data2,String data3);
	

	ResponseEntity<Object> updateemp(EmpBean data, long id);

//search by feild 
	public ResponseEntity<Object> findEmployeeWithSorting(String field, String order);

// like from with jpa onlu
	ResponseEntity<Object> findByfnameContaining(String data);

//exact search
	ResponseEntity<Object> findByexact(String fname);

// seach by pageniation
	public ResponseEntity<Object> findEmpByPagination(int offset, int pagesize);
	public ResponseEntity<Object> getAllEmp();
	
	

}