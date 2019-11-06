package com.accenture.lkm.business.bean;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class DateWisePurchaseReportBean {
	
	@NotNull(message="From Date cannot be empty")
	private Date fromDate;
	@NotNull(message="To Date cannot be empty")
	private Date toDate;
	public DateWisePurchaseReportBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DateWisePurchaseReportBean(Date fromDate, Date toDate) {
		super();
		this.fromDate = fromDate;
		this.toDate = toDate;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	
	

}