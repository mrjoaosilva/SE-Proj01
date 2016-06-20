package pt.tecnico.sise.se.insure.domain;

public class Customer {
	
	//PLACEHOLDER PARA NAO GERAR ERROS:
	
	String Name;
	String nif;
	String customerName;
	String policy;
	
	public Customer(String name, String nif, String customerName, String policy) {
		super();
		Name = name;
		this.nif = nif;
		this.customerName = customerName;
		this.policy = policy;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPolicy() {
		return policy;
	}

	public void setPolicy(String policy) {
		this.policy = policy;
	}
		

}
