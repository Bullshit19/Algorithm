package algorithm.core;

import java.text.ParseException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

public abstract class Register {

	public final static String NAME = "name";
	public final static String FIRST_NAME = "firstName";
	public final static String SECOND_NAME = "secondName";
	public final static String THIRD_NAME = "thirdName";
	public final static String EMPLOYER = "employer";
	public final static String START_DATE = "startDate";
	public final static String END_DATE = "endDate";
	public final static String PROVENANCE = "provenance";
	
	
	//All the get* methods remove the attribute to optimize the comparison
	//To have the complete map of the attributes, use the getHashMapAttributes method
	public String get(String attribute){
		return null;
	}
	
	public String getId(){
		return null;
	}
	
	public String getName() {
		return null;
	}
	
	public String getFirstName() {
		return null;
	}
	
	public String getSecondName() {
		return null;
	}
	
	public String getThirdName() {
		return null;
	}
	
	
	public String getEmployer() {
		return null;
	}
	
	public List<String> getAttributes() {
		return null;
	}
	
	public HashMap<String,Calendar> getDates() throws ParseException {
		return null;
	}
	
	public boolean equals(Register registerToCompareWith) {
		return false;
	}

	public HashMap<String, String> getHashMapAttributes() {
		return null;
	}
}
