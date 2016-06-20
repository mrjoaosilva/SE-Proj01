package pt.tecnico.sise.se.insure.domain;

import java.math.BigDecimal;
//import java.time.LocalDate;
import org.joda.time.LocalDate;

public class Policy {
	
	private LocalDate now;
	private LocalDate future;
	private BigDecimal bigDecimal;

	public Policy(LocalDate now, LocalDate future, BigDecimal bigDecimal) {
		this.setNow(now);
		this.setFuture(future);
		this.setBigDecimal(bigDecimal);
	} 
public LocalDate getNow() {
		return now;
	}

	public void setNow(LocalDate now) {
		this.now = now;
	}

	public LocalDate getFuture() {
		return future;
	}

	public void setFuture(LocalDate future) {
		this.future = future;
	}

	public BigDecimal getBigDecimal() {
		return bigDecimal;
	}

	public void setBigDecimal(BigDecimal bigDecimal) {
		this.bigDecimal = bigDecimal;
	}

} 