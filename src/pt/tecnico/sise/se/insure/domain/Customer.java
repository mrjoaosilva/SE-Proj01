package pt.tecnico.sise.se.insure.domain;

import pt.tecnico.sise.se.insure.domain.exception.IllegalNIFException;
import pt.tecnico.sise.se.insure.domain.exception.IllegalNameException;
import pt.tecnico.sise.se.insure.domain.exception.IllegalPolicyException;
import pt.tecnico.sise.se.insure.domain.exception.MissingInsuranceCompanyException;

public class Customer {
	
	private InsuranceCompany insuranceCompany;
	private String nif;
	private String name;
	private Policy policy;

	public Customer(InsuranceCompany insuranceCompany,String nif,String name, Policy policy) {
		
		if(nif == null || nif.length() != 9 || !nif.matches("[0-9]*\\d+.*") ) throw new IllegalNIFException("Error: illegal nif");
		if(name == null || !name.trim().contains(" ")) throw new IllegalNameException("Error: illegal name");
		if(insuranceCompany == null) throw new MissingInsuranceCompanyException("Error: invalid company");
		if (policy == null) throw new IllegalPolicyException("Error: invalid policy");
				
	    this.nif = nif;
	    this.name = name;
	    this.policy= policy;
	    this.insuranceCompany = insuranceCompany;
	    insuranceCompany.addCustomer(this);
	}

	public String getNIF() {
		
		return this.nif;
	}

	public String getName() {
		return this.name;
	}

	public Policy getPolicy() {
		
		return this.policy;
	}
}
