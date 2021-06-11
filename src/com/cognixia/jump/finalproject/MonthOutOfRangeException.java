package com.cognixia.jump.finalproject;

public class MonthOutOfRangeException extends Exception {
	
	

//	public MonthOutOfRangeException(int a, int b, String month, String year) {
//		
//		super();
//		
//		//System.out.println("Please Enter Days for " + month + " of " + year + " (" + a + "-" + b +")");
//		
//	}
	
/**
	 * 
	 */
	private static final long serialVersionUID = 2944128774276116123L;

public MonthOutOfRangeException(int a, int b, String month, String year) {
		
		super("Please Enter Days for " + month + " of " + year + " (" + a + "-" + b +")");
		
		//System.out.println("Please Enter Days for " + month + " of " + year + " (" + a + "-" + b +")");
		
	}
}
