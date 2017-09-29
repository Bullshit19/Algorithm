package algorithm.bean;

import java.util.Calendar;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;


public class RegisterBean{

	private Calendar dateDebut;
	private Calendar dateFin;
	private Map<String, String> attributs;
	
	public RegisterBean(Calendar startDate, Calendar endDate, Map<String, String> attributes){
		this.dateDebut = startDate;
		this.dateFin = endDate;
		this.attributs = attributes;
	}
	
	public Calendar getDateDebut(){
		return this.dateDebut;
	}
	
	public Calendar getDateFin(){
		return this.dateFin;
	}
	
	public Map<String, String> getAttributsMap(){
		return this.attributs;
	}
	
	public void setDateDebut(Calendar newDate){
		this.dateDebut = newDate;
	}
	
	public void setDateFin(Calendar newDate){
		this.dateFin = newDate;
	}
	
	public void setAttributsMap(Map<String, String> newAttributes){
		this.attributs = newAttributes;
	}
	
	public void setAttribut(String key, String value){
		this.attributs.put(key, value);
	}
	

	
	public boolean equals(RegisterBean reg){
		boolean isEqual = true;
		if(this.dateDebut.equals(reg.dateDebut) && this.dateFin.equals(reg.dateFin)){
			if(this.attributs.size() == reg.attributs.size()){
				Set<String> keys = this.attributs.keySet();
				for(String key : keys){
					if(reg.attributs.containsKey(key)){
						if(!reg.attributs.get(key).equals(this.attributs.get(key))){
							isEqual = false;
						}
					}
					else{
						isEqual = false;
					}
				}
			}
			else{
				isEqual = false;
			}
			
		}
		else{
			isEqual = false;
		}
		
		return isEqual;
	}

	
}
