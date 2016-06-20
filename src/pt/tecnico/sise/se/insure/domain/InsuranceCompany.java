package pt.tecnico.sise.se.insure.domain;

import java.util.HashMap;

import pt.tecnico.sise.se.insure.domain.exception.IllegalInsuranceCompanyNameException;
import pt.tecnico.sise.se.insure.domain.exception.NIFAlreadyInUseException;
import pt.tecnico.sise.se.insure.domain.exception.EmployeeIdAlreadyInUseException;

public class InsuranceCompany {
	
	private HashMap <String, Customer> customerMap = new HashMap<String, Customer>(); //string - customerNIF key
	private HashMap <String, Employee> employeeMap = new HashMap<String, Employee>(); //string - employeeID key
	
	private final String name;

	public InsuranceCompany(String name) {
		
		if(name == null) throw new IllegalInsuranceCompanyNameException("Error: illegal name");
		
		this.name = name;
	}
	public void addCustomer(Customer customer){
		
		if (customerMap.containsKey(customer.getNIF())){
			throw new NIFAlreadyInUseException("Error: NIF already in use");
		}
		else{
			customerMap.put(customer.getNIF(), customer);
		}
		
	}
	
	public void addEmployee(Employee employee) {
		if(employeeMap.containsKey(employee.getId())) {
			throw new EmployeeIdAlreadyInUseException("Error: employee ID already in use.");
		}
		else {
			employeeMap.put(employee.getId(), employee);
		}
	} 

	public String getName() {
		return name;
	}

	public HashMap<String, Customer> getCustomerMap() {
		return customerMap;
	}

	public HashMap<String, Employee> getEmployeeMap() {
		return employeeMap;
}
}