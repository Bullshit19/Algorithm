package algorithm;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import algorithm.bean.RegisterBean;

public class Box {

	List<RegisterBean> list;
	List<RegisterBean> listToCompareWith;
	
	public Box(List<RegisterBean> listToCompare, List<RegisterBean> listToCompareToo){
		this.list = listToCompare;
		this.listToCompareWith = listToCompareToo;
	}
	
	
	public List<RegisterBean> fusion(List<RegisterBean> list1, List<RegisterBean> list2){
		List<RegisterBean> listFusionnee = new ArrayList<RegisterBean>();
		Map<String, String> newAttributes;
		RegisterBean newRegister;
		RegisterBean newRegisterBis;
		
		for(RegisterBean register : list2){
			for (RegisterBean registerToCompareWith : list1){
				
				//Si dates égales
				if(register.getDateDebut().equals(registerToCompareWith.getDateDebut()) && register.getDateFin().equals(registerToCompareWith.getDateFin())){
					newAttributes = new HashMap<>();
					//Check clé commune
					for(String key : register.getAttributsMap().keySet()){
						if(registerToCompareWith.getAttributsMap().containsKey(key)){
							
						}
						else{
							newAttributes.put(key, register.getAttributsMap().get(key));
						}
					}//end foreach key
					
					newRegister = new RegisterBean(register.getDateDebut(), register.getDateFin(), newAttributes);
					listFusionnee.add(newRegister);
					
				}//end if dates égales
				
				
				
				//si dates début égales date fin 1 inter
				else if(register.getDateDebut().equals(registerToCompareWith.getDateDebut()) && register.getDateFin().before(registerToCompareWith.getDateFin())){
					newAttributes = new HashMap<>();
					//Check clé commune
					for(String key : register.getAttributsMap().keySet()){
						if(registerToCompareWith.getAttributsMap().containsKey(key)){
							
						}
						else{
							newAttributes.put(key, register.getAttributsMap().get(key));
						}
					}//end foreach key
					
					newRegister = new RegisterBean(register.getDateDebut(), register.getDateFin(), newAttributes);
					Calendar cal = register.getDateFin();
					cal.add(Calendar.DATE, 1);
					newRegisterBis = new RegisterBean(cal, registerToCompareWith.getDateFin(), registerToCompareWith.getAttributsMap());
					
					listFusionnee.add(newRegister);
					listFusionnee.add(newRegisterBis);
				}
				
				
				
				//si dates début égales date fin 2 inter
				else if(register.getDateDebut().equals(registerToCompareWith.getDateDebut()) && registerToCompareWith.getDateFin().before(register.getDateFin())){
					newAttributes = new HashMap<>();
					//Check clé commune
					for(String key : register.getAttributsMap().keySet()){
						if(registerToCompareWith.getAttributsMap().containsKey(key)){
							
						}
						else{
							newAttributes.put(key, register.getAttributsMap().get(key));
						}
					}//end foreach key
					
					newRegister = new RegisterBean(register.getDateDebut(), registerToCompareWith.getDateFin(), newAttributes);
					Calendar cal = registerToCompareWith.getDateFin();
					cal.add(Calendar.DATE, 1);
					newRegisterBis = new RegisterBean(cal, register.getDateFin(), register.getAttributsMap());
					
					listFusionnee.add(newRegister);
					listFusionnee.add(newRegisterBis);
				}
				
				
				
				//si dates fin égales date debut 1 inter
				else if(register.getDateFin().equals(registerToCompareWith.getDateFin()) && register.getDateDebut().after(registerToCompareWith.getDateDebut())){
					newAttributes = new HashMap<>();
					//Check clé commune
					for(String key : register.getAttributsMap().keySet()){
						if(registerToCompareWith.getAttributsMap().containsKey(key)){
							
						}
						else{
							newAttributes.put(key, register.getAttributsMap().get(key));
						}
					}//end foreach key
					
					newRegister = new RegisterBean(register.getDateDebut(), register.getDateFin(), newAttributes);
					Calendar cal = register.getDateDebut();
					cal.add(Calendar.DATE, -1);
					newRegisterBis = new RegisterBean(registerToCompareWith.getDateDebut(), cal, registerToCompareWith.getAttributsMap());
					
					listFusionnee.add(newRegister);
					listFusionnee.add(newRegisterBis);
				}
				
				
				
				//si dates fin égales date début 2 inter
				else if(register.getDateFin().equals(registerToCompareWith.getDateFin()) && registerToCompareWith.getDateDebut().after(register.getDateDebut())){
					newAttributes = new HashMap<>();
					//Check clé commune
					for(String key : register.getAttributsMap().keySet()){
						if(registerToCompareWith.getAttributsMap().containsKey(key)){
							
						}
						else{
							newAttributes.put(key, register.getAttributsMap().get(key));
						}
					}//end foreach key
					
					newRegister = new RegisterBean(registerToCompareWith.getDateDebut(), register.getDateFin(), newAttributes);
					Calendar cal = registerToCompareWith.getDateDebut();
					cal.add(Calendar.DATE, -1);
					newRegisterBis = new RegisterBean(register.getDateDebut(), cal, register.getAttributsMap());
					
					listFusionnee.add(newRegister);
					listFusionnee.add(newRegisterBis);
				}
				else{
					listFusionnee.add(register);
					listFusionnee.add(registerToCompareWith);
				}
				
				
			}//end foreach
		}//end foreach
		
		if(hasCommonDates(listFusionnee)){
//			List<RegisterBean> list1AModif = new ArrayList<RegisterBean>();
//			List<RegisterBean> list2AModif = new ArrayList<RegisterBean>();
			List<RegisterBean> listFusionAModif = new ArrayList<RegisterBean>(listFusionnee);
			for(RegisterBean reg : listFusionnee){
				for(RegisterBean reg2 : listFusionAModif){
					if(reg.getDateDebut().after(reg2.getDateDebut()) && reg.getDateDebut().before(reg2.getDateFin())){
						list1.add(reg);
						list2.add(reg2);
					}
					if(reg.getDateFin().before(reg2.getDateFin()) && reg.getDateFin().after(reg2.getDateDebut())){
						list1.add(reg);
						list2.add(reg2);
					}
					if(reg2.getDateFin().before(reg.getDateFin()) && reg2.getDateFin().after(reg.getDateDebut())){
						list1.add(reg);
						list2.add(reg2);
					}
					if(reg2.getDateDebut().after(reg.getDateDebut()) && reg2.getDateDebut().before(reg.getDateFin())){
						list1.add(reg);
						list2.add(reg2);
					}
					if(reg.getDateDebut().compareTo(reg2.getDateDebut()) == 0 && reg.getDateFin().compareTo(reg2.getDateFin()) == 0){
						list1.add(reg);
						list2.add(reg2);
					}
				}
			}
			fusion(list1, list2);
		}
		
		
		return listFusionnee;
	}
	
	public Boolean hasCommonDates(List<RegisterBean> list1){
		Boolean hasCommon = false;
		List<RegisterBean> list2 = new ArrayList<RegisterBean>(list1);
		for(RegisterBean reg : list1){
			for(RegisterBean reg2 : list2){
				if(reg.getDateDebut().after(reg2.getDateDebut()) && reg.getDateDebut().before(reg2.getDateFin())){
					hasCommon = true;
				}
				if(reg.getDateFin().before(reg2.getDateFin()) && reg.getDateFin().after(reg2.getDateDebut())){
					hasCommon = true;
				}
				if(reg2.getDateFin().before(reg.getDateFin()) && reg2.getDateFin().after(reg.getDateDebut())){
					hasCommon = true;
				}
				if(reg2.getDateDebut().after(reg.getDateDebut()) && reg2.getDateDebut().before(reg.getDateFin())){
					hasCommon = true;
				}
				if(reg.getDateDebut().compareTo(reg2.getDateDebut()) == 0 && reg.getDateFin().compareTo(reg2.getDateFin()) == 0){
					hasCommon = true;
				}
			}
		}
		return hasCommon;
	}
}
