package com.techtree.newproject.Service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.techtree.newproject.Repository.ProjectRepository;
import com.techtree.newproject.Service.ProjectService;
import com.techtree.newproject.model.EmpBean;
import com.techtree.newproject.model.Employee;
import com.techtree.newproject.model.lapBean;
import com.techtree.newproject.model.laptop;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	ProjectRepository projectrepo;

	@Override
	public ResponseEntity<Object> saveEmployee(Employee employee) {
		try {
			if (employee != null) {
				Employee e = new Employee();
				e.setId(employee.getId());
				e.setFname(employee.getFname());
				e.setLname(employee.getLname());
				e.setEmail(employee.getEmail());
				List<lapBean> list = employee.getLaptop();
				laptop l1 = new laptop();
				for (int i = 0; i < list.size(); i++) {
					laptop lap = list.get(i);
					l1.setId(lap.getId());
					l1.setLaptopName(lap.getLaptopName());
				}
				e.setLaptop(list);
//					l1.setId(employee.getLaptop();
////					l1.setId(employee.getLaptop());
//					l1.setLaptopName(employee.getLaptop());
//					l.setEmp(e);
				System.out.println(e.getLaptop());
				Employee e1 = projectrepo.save(e);

				return new ResponseEntity<Object>(e1.getId(), HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>("data not found:" + employee, HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>("error Or internal server issue", HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@Override
	public ResponseEntity<Object> getemployeelist() {
		try {
			Map<String, List<Employee>> res = new HashMap<String, List<Employee>>();
			List<Employee> list = projectrepo.findAll();
			if (list.isEmpty() != true) { // null check
				res.put("data found", list);
				return new ResponseEntity<Object>(res, HttpStatus.FOUND);
			} else {
				res.put("data not found", new ArrayList<Employee>());
				return new ResponseEntity<Object>(res, HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>("error Or internal server issue", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<Object> getemployeebyid(long id) {

		try {
			Map<String, Object> res = new HashMap<String, Object>();

//			Optional<Employee> emp = projectrepo.findById(id);
//			if (emp.isPresent()) {
			Employee emp = projectrepo.getById(id);

			EmpBean empBean = new EmpBean();
			empBean.setId(emp.getId());
			empBean.setFname(emp.getFname());
			empBean.setLname(emp.getLname());
			empBean.setEmail(emp.getEmail());
//		empBean.setLaptop(emp.getLaptop());
			Gson g = new Gson();
			String json = g.toJson(empBean);
			JSONObject js = new JSONObject(json);
			js.put("key", 101);
			System.out.println(js);

			Employee e = g.fromJson(js.toString(), Employee.class);
			// res.put("data found ",emp);
			System.out.println(e);
			res.put("values:", js.toString());
			return new ResponseEntity<Object>(res, HttpStatus.OK);

		}
//			else{
//				return new ResponseEntity<Object>("No recod found", HttpStatus.BAD_REQUEST);
//				}
//			}

		catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>("error Or internal server issue", HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@Override
	public ResponseEntity<Object> deleteEmployee(long id) {
		try {
			projectrepo.deleteById(id);
			// check after dele
			if (projectrepo.findById(id).isPresent()) {
				return new ResponseEntity<Object>("delete is not done" + id, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<Object>("delete is done on id:" + id, HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>("error Or internal server issue", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<Object> Searchdataexact(String data1, String data2, String data3) {
		try {
			List<Employee> emplist = projectrepo.findByFnameOrLnameOrEmail(data1, data2, data3);

			Map<String, Object> res = new HashMap<String, Object>();

			if (!emplist.isEmpty()) {
				res.put("data found ", emplist);
				return new ResponseEntity<Object>(res, HttpStatus.FOUND);
			} else {
				res.put("data  not found ", new ArrayList<>());
				return new ResponseEntity<Object>(res, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>("error Or internal server issue", HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@Override
	public ResponseEntity<Object> updateemp(Employee data, long id) {
		try {
			Optional<Employee> updateddata = projectrepo.findById(id);

//		updateddata.setFname(name);
//		Map<String, Employee> res = new HashMap<String, Employee>();
			if (updateddata.isPresent() || data != null) {

				EmpBean empBean = new EmpBean();
				empBean.setId(updateddata.get().getId());
				empBean.setFname(updateddata.get().getFname());
				empBean.setLname(updateddata.get().getLname());
				empBean.setLname(updateddata.get().getLname());
				empBean.setEmail(updateddata.get().getEmail());
//				empBean.setLaptop(updateddata.get().getLaptop());
				return new ResponseEntity<Object>("data updtated found: " + empBean, HttpStatus.OK);

//			res.put("data updtated found ", empBean);
//			return new ResponseEntity<Object>(res, HttpStatus.FOUND);
			} else {
				// res.put("data not found ", null);
				return new ResponseEntity<Object>("data  not found ", HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>("error Or internal server issue", HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@Override
	public ResponseEntity<Object> getAllEmp() {
//		List<Employee> list = projectrepo.findByIdAndEmail();
//		List<Employee> list = projectrepo.getallEmp();
//		if (list.isEmpty()== false) {
//			return new ResponseEntity<Object>(list, HttpStatus.FOUND);
//		} else {
//			return new ResponseEntity<Object>("list is empty", HttpStatus.FOUND);
//		}

		return new ResponseEntity<Object>("error Or internal server issue", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<Object> findEmployeeWithSorting(String field, String order) {

		Map<String, List<Employee>> res = new HashMap<String, List<Employee>>();
		if (order.equalsIgnoreCase("asc")) {
			res.put("list foound by asc order", projectrepo.findAll(Sort.by(Sort.Direction.ASC, field)));

		} else if (order.equalsIgnoreCase("desc")) {
			res.put("list found by desc order", projectrepo.findAll(Sort.by(Sort.Direction.DESC, field)));
		}
		return new ResponseEntity<Object>(res, HttpStatus.OK);

	}

	@Override
	public ResponseEntity<Object> findByfnameContaining(String fname) {
		if (fname != null) {
			List<Employee> emplist = projectrepo.findByFnameContaining(fname);
			return new ResponseEntity<Object>(emplist, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<Object>("enter the fname", HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public ResponseEntity<Object> findByexact(String data) {
		if (data != null) {
			List<Employee> emplist = projectrepo.findByFnameOrLnameOrEmail(data, data, data);
			return new ResponseEntity<Object>(emplist, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<Object>("enter the fname", HttpStatus.NOT_FOUND);
		}

	}

	@Override
	public ResponseEntity<Object> findEmpByPagination(int offset, int pagesize) {
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("sortebd by offset",
				projectrepo.findAll(PageRequest.of(offset, pagesize, Sort.by("fname").descending()))); // spcif value
																										// check in db
		return new ResponseEntity<Object>(res, HttpStatus.FOUND);
	}

	@Override
	public ResponseEntity<Object> SearchdataLikes(String data1, String data2, String data3) {
		try {
			List<Employee> emplist = projectrepo.findByFnameContainingOrLnameContainingOrEmailContaining(data1, data2,
					data3);
			Map<String, Object> res = new HashMap<String, Object>();
			if (emplist.isEmpty() == false) {
				res.put(" No such Values:", new ArrayList<>());
				return new ResponseEntity<Object>(res, HttpStatus.NOT_FOUND);
			} else {
				res.put("values: ", emplist);
				return new ResponseEntity<Object>(res, HttpStatus.FOUND);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>("error Or internal server issue", HttpStatus.INTERNAL_SERVER_ERROR);

	}
}
