package pt.tecnico.sise.se.insure.domain.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import pt.tecnico.sise.se.insure.domain.InsuranceCompany;
import pt.tecnico.sise.se.insure.domain.exception.IllegalInsuranceCompanyNameException;

public class TestInsuranceCompany {

	private static final String VALID_INSURANCE_COMPANY_NAME = "Sebulba Insurances";
	
	@Test
	public void testSuccessfullyCreateInsuranceCompany() {
		InsuranceCompany insuranceCompany = new InsuranceCompany(VALID_INSURANCE_COMPANY_NAME);
		assertEquals(VALID_INSURANCE_COMPANY_NAME, insuranceCompany.getName());
	}
	
	@Test(expected=IllegalInsuranceCompanyNameException.class)
	public void testCreationFailOnIllegalInsuranceCompanyName() {
		new InsuranceCompany(null);
		fail("This line should never be reached.");
	}

}
