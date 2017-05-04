package algorithm.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import algorithm.core.Register;

public class SirhusRegisterBean extends Register{

	private HashMap<String, String> attributes;
	private HashMap<String, String> attributesBackup;
	
	public SirhusRegisterBean(HashMap<String, String> args) {
		attributes.putAll(args);
		attributesBackup.putAll(args);
	}
	
	@Override
	public HashMap<String, String> getHashMapAttributes(){
		return attributesBackup;
	}
	
	@Override
	public String get(String attribute){
		String value = attributes.get(attribute);
		attributes.remove(attribute);
		return value;
	}
	
	@Override
	public String getName() {
		String value = attributes.get(Register.NAME);
		attributes.remove(Register.NAME);
		return value;
	}

	@Override
	public String getFirstName() {
		String value = attributes.get(Register.FIRST_NAME);
		attributes.remove(Register.FIRST_NAME);
		return value;
	}

	@Override
	public String getSecondName() {
		String value = attributes.get(Register.SECOND_NAME);
		attributes.remove(Register.SECOND_NAME);
		return value;
	}

	@Override
	public String getThirdName() {
		String value = attributes.get(Register.THIRD_NAME);
		attributes.remove(Register.THIRD_NAME);
		return value;
	}

	@Override
	public String getEmployer() {
		String value = attributes.get(Register.EMPLOYER);
		attributes.remove(Register.EMPLOYER);
		return value;
	}
	

	@Override
	public List<String> getAttributes() {
		List<String> attribut = (List<String>) attributes.values();
		return attribut;
	}

	@Override
	public HashMap<String,Calendar> getDates() throws ParseException {
		HashMap<String, Calendar> dates = new HashMap<String,Calendar>();
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE);
		cal.setTime(sdf.parse(attributes.get(Register.START_DATE)));
		dates.put(Register.START_DATE, cal);
		attributes.remove(Register.START_DATE);
		
		cal.setTime(sdf.parse(attributes.get(Register.END_DATE)));
		dates.put(Register.END_DATE, cal);
		attributes.remove(Register.END_DATE);
		return dates;
	}

	@Override
	public boolean equals(Register registerToCompareWith) {
		boolean result = false;
		if(this.getHashMapAttributes().equals(registerToCompareWith.getHashMapAttributes())){
			result = true;
		}
		return result;
	}

}
