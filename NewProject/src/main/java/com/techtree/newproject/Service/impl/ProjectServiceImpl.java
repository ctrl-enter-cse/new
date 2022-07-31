package com.techtree.newproject.Service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.techtree.newproject.Repository.ProjectRepository;
import com.techtree.newproject.Service.ProjectService;
import com.techtree.newproject.model.Employee;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	ProjectRepository projectrepo;

	@Override
	public ResponseEntity<Object> saveEmployee(Employee employee) {
		if(employee!=null) {
		return new ResponseEntity<Object>(projectrepo.save(employee),HttpStatus.OK);
		}else {
			return new ResponseEntity<Object>("data not found",HttpStatus.OK);	
		}
	}

	@Override
	public ResponseEntity<Object> getemployeelist() {

		Map<String, List<Employee>> res = new HashMap<String, List<Employee>>();
		List<Employee> list = projectrepo.findAll();
		if (list != null) {
			res.put("data found", list);
			return new ResponseEntity<Object>(res, HttpStatus.FOUND);
		} else {
			res.put("data not found", new ArrayList<Employee>());
			return new ResponseEntity<Object>(res, HttpStatus.NOT_FOUND);
		}

	}

	@Override
	public ResponseEntity<Object> getemployeebyid(long id) {

		Map<String, Optional<Employee>> res = new HashMap<String, Optional<Employee>>();
		// Optional<Employee> Data=employeeRepository.findById(id);
		// if (Data != null) {

		res.put("data found", projectrepo.findById(id));
		return new ResponseEntity<Object>(res, HttpStatus.FOUND);
//		} else {
//			res.put("data found", Data);
//			return new ResponseEntity<Object>(res, HttpStatus.NOT_FOUND);
//		}

	}

	@Override
	public ResponseEntity<Object> deleteEmployee(long id) {
		projectrepo.deleteById(id);

		return new ResponseEntity<Object>("delete is done on id:" + id, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> Searchdata(String data1,String data2,String data3) {
		List<Employee> emplist = projectrepo.findByFnameOrLnameOrEmail(data1,data2,data3);

		Map<String, Object> res = new HashMap<String, Object>();
								
		if (emplist != null) {
			res.put("data found ", emplist);
			return new ResponseEntity<Object>(res, HttpStatus.FOUND);
		} else {
			res.put("data  not found ", new ArrayList<>());
			return new ResponseEntity<Object>(res, HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public ResponseEntity<Object> updateemp(String name, long id) {
			int i=	projectrepo.updateData(name, id);
			System.out.println(i);
		 Employee updateddata=projectrepo.getById(id);

		Map<String,Employee> res = new HashMap<String, Employee>();							
		if (i >0) {
			res.put("data updtated found ", updateddata);
			return new ResponseEntity<Object>(res, HttpStatus.FOUND);
		} else {
			res.put("data  not found ", null);
			return new ResponseEntity<Object>(res, HttpStatus.NOT_FOUND);
		}
		
		
	}
	@Override
	public ResponseEntity<Object> getAllEmp(){
		List<Employee> list = projectrepo.getallEmp();
		return new ResponseEntity<Object>(list,HttpStatus.FOUND);
		
	}

	@Override
	public ResponseEntity<Object> findEmployeeWithSorting(String field,String order) {
		Map<String, List<Employee>> res = new HashMap<String, List<Employee>>();
		if(order.equalsIgnoreCase("asc")) {
		res.put("list foound by asc order", projectrepo.findAll(Sort.by(Sort.Direction.ASC,field)));
		
		}else if(order.equalsIgnoreCase("desc")){
			res.put("list foound by asc order", projectrepo.findAll(Sort.by(Sort.Direction.DESC,field)));
		}
		return new ResponseEntity<Object>(res,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> findByfnameContaining(String fname) {
		 if(fname !=null) {
		List<Employee> emplist = projectrepo.findByFnameContaining(fname);	
		return new ResponseEntity<Object>(emplist,HttpStatus.FOUND);
		 }else {
			 return new ResponseEntity<Object>("enter the fname",HttpStatus.NOT_FOUND);
		 }
	}

	@Override
	public ResponseEntity<Object> findByfnameexactContaining(String fname) {
//		 if(fname !=null) {
//				List<Employee> emplist = projectrepo.findByFnameExacts(fname);	
//				return new ResponseEntity<Object>(emplist,HttpStatus.FOUND);
//				 }else {
//					 return new ResponseEntity<Object>("enter the fname",HttpStatus.NOT_FOUND);
//				 }
//		 
		return null;
	}

	@Override
	public ResponseEntity<Object> findEmpByPagination(int offset, int pagesize) {			
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("sortebd by offset",projectrepo.findAll(PageRequest.of(offset, pagesize)));
		return  new ResponseEntity<Object> (res,HttpStatus.FOUND);
	}

	@Override
	public ResponseEntity<Object> SearchdataLikes(String data1, String data2, String data3) {
		List<Employee> emplist = projectrepo.findByFnameContainingOrLnameContainingOrEmailContaining(data1,data2,data3);
		Map<String, Object> res = new HashMap<String, Object>();						
		if (emplist.isEmpty() == false) {
			res.put(" No such Values:", new ArrayList<>());
			return new ResponseEntity<Object>(res, HttpStatus.NOT_FOUND);	
			}else{
			res.put("values: ", emplist);		
			return new ResponseEntity<Object>(res, HttpStatus.FOUND);
		
			}
	
	}

}
