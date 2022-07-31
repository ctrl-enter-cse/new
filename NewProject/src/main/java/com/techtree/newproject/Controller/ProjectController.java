package com.techtree.newproject.Controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techtree.newproject.Service.ProjectService;
import com.techtree.newproject.Service.impl.ProjectServiceImpl;
import com.techtree.newproject.model.Employee;

@RestController
@RequestMapping("/home")
public class ProjectController {

	@Autowired
	private ProjectService Projectservice;

	// build create emplye restapi
	@PostMapping("/saveemployee")
	public ResponseEntity<Object> saveEmployee(@RequestBody Employee employee) {
		System.out.println(employee);
		return Projectservice.saveEmployee(employee);
	}

	@GetMapping("/getemployeelist")
	public ResponseEntity<Object> getemployeelist() {
		return Projectservice.getemployeelist();
	}

	@GetMapping("/byid/{id}")
	public ResponseEntity<Object> getEmployeebyid(@PathVariable("id") long id) {
		return Projectservice.getemployeebyid(id);

	}

	@PutMapping("/updateemployee/{id}")
	public ResponseEntity<Object> updateEmployee(@PathVariable("id") long id, @RequestBody String name) {
		return new ResponseEntity<Object>(Projectservice.updateemp(name, id), HttpStatus.OK);

	}

	@DeleteMapping("/deleteEmp/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id) {
		Projectservice.deleteEmployee(id);
		return new ResponseEntity<String>("Deleted ", HttpStatus.OK);
	}

	@GetMapping("/searchdata")
	public ResponseEntity<Object> searchdata(@RequestParam("data") String data) {
		return Projectservice.Searchdata(data, data, data);
	}

	@GetMapping("/searchdataLikes")
	public ResponseEntity<Object> searchdataLike(@RequestParam("data") String data) {
		return Projectservice.SearchdataLikes(data, data, data);
	}
//		@PostMapping("/newlist")
//		public  List<Employee> saveEmployee1( @RequestBody  List<Employee> employee){
//			
//			return employeeservice.saveEmployee1( employee);	
//		}

	@PutMapping("/updatefname/{id}")
	public ResponseEntity<Object> updatename(@RequestBody String name, @PathVariable("id") long id) {

		return new ResponseEntity<Object>(Projectservice.updateemp(name, id), HttpStatus.OK);
	}

	@PostMapping("/searchby")
	public ResponseEntity<Object> findByTitleContaining(@RequestParam("title") String title) {
		return new ResponseEntity<Object>(Projectservice.findByfnameContaining(title), HttpStatus.OK);

	}

	@PostMapping("/searchbyexact")
	public ResponseEntity<Object> findByTitleLike(@RequestParam("title") String title) {
		return new ResponseEntity<Object>(Projectservice.findByfnameexactContaining(title), HttpStatus.OK);
	}

	@GetMapping("/{field}/{order}")
	public ResponseEntity<Object> sortbyfield(@PathVariable("field") String field, @RequestParam String order) {
		return Projectservice.findEmployeeWithSorting(field,order);
	}

	@GetMapping("/pagination/{offset}/{size}")
	public ResponseEntity<Object> findEmpByPagination(@PathVariable int offset, @PathVariable int size) {
		return Projectservice.findEmpByPagination(offset, size);
	}
	@GetMapping("/getlistjpql")	
	public ResponseEntity<Object> getAllEmp(){
		return Projectservice.getAllEmp();
		
	}
}
