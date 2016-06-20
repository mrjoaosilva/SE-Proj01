package pt.tecnico.sise.se.insure.domain;

import java.util.HashMap;

import pt.tecnico.sise.se.insure.domain.exception.NIFAlreadyInUseException;
import pt.tecnico.sise.se.insure.domain.test.Customer;

public class InsuranceCompany {
	
	
	private HashMap<String, Customer> customerMap;

	public void addCustomer(Customer customer){
		
		if (customerMap.containsKey(customer.getNif())){
			throw new NIFAlreadyInUseException("Error: NIF already in use");
		}
		else{
			customerMap.put(customer.getNif(), customer);
		}
		
	}

}
