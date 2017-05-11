package algorithm;

import java.text.ParseException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import algorithm.bean.OutRegisterBean;
import algorithm.core.IBlackBox;
import algorithm.core.Register;

public class BlackBox implements IBlackBox{

	private List<String> discriminants;
	private List<Register> resedaEntry;
	private List<Register> sirhusEntry;
	private Stack<Register> out;
	
	public BlackBox(){
		discriminants.add(Register.EMPLOYER);
	}
	
	@Override
	public void add(Register register) {
		OutRegisterBean reg = (OutRegisterBean) register;
		reg.setAction(OutRegisterBean.ADD);
		this.out.push(register);
	}
	@Override
	public void delete(Register register, String resedaId) {
		OutRegisterBean reg = (OutRegisterBean) register;
		reg.setId(resedaId);
		reg.setAction(OutRegisterBean.DELETE);
		this.out.push(register);
	}
	@Override
	public void update(Register register, String resedaId ){
		OutRegisterBean reg = (OutRegisterBean) register;
		reg.setId(resedaId);
		reg.setAction(OutRegisterBean.UPDATE);
		this.out.push(reg);
	}
	
	public void nothing(Register register, String resedaId){
		OutRegisterBean reg = (OutRegisterBean) register;
		reg.setId(resedaId);
		reg.setAction(OutRegisterBean.NOTHING);
		this.out.push(reg);
	}
	
	/**
	 * Compare the two lists resedaEntry and sirhusEntry and call the appropriate method to push the out register in the stack
	 * @throws ParseException 
	 */
	@Override
	public void compare() throws ParseException {
		List<Register> sirhus = sirhusEntry;
		List<Register> reseda = resedaEntry;
		HashMap<String, String> sirhusAttributes;
		HashMap<String, String> resedaAttributes;
		HashMap<String, String> outAttributes;
		OutRegisterBean out;
		Calendar cal;
		
		for(Register regSir : sirhus){
			for(Register regRes : reseda){
//				Chech if the registers are equal
				if(regSir.equals(regRes)){
					nothing(regRes, regRes.getId());
//					sirhus.remove(regSir);
//					reseda.remove(regRes);
				}
				else{
					for(String dis : discriminants){
						//if the disciminants are equal : test the dates
						if(regSir.get(dis).equals(regRes.get(dis))){
							
							if(regSir.getDates().get(Register.START_DATE).equals(regRes.getDates().get(Register.START_DATE)) && regSir.getDates().get(Register.END_DATE).equals(regRes.getDates().get(Register.END_DATE))){
								//if the dates are equals : attribut diff = update else seen if register == reg	
								update(regSir,regRes.getId());									
							}//end dates ==
							
							
							//cas dates de fin différentes
							else if(regSir.getDates().get(Register.START_DATE).equals(regRes.getDates().get(Register.START_DATE)) && !regSir.getDates().get(Register.END_DATE).equals(regRes.getDates().get(Register.END_DATE))){
							//if endDate != && endDateSir > endDateRes ==> update Sinon 2 périodes
								if(regSir.getDates().get(Register.END_DATE).after(regRes.getDates().get(Register.END_DATE))){
									
									resedaAttributes = regRes.getHashMapAttributes();
									sirhusAttributes = regSir.getHashMapAttributes();
									if(!resedaAttributes.get(Register.PROVENANCE).equals(sirhusAttributes.get(Register.PROVENANCE))){
										resedaAttributes.put(Register.PROVENANCE, sirhusAttributes.get(Register.PROVENANCE));
									}
									update(regSir,regRes.getId());
								}
								else{
									resedaAttributes = regRes.getHashMapAttributes();
									sirhusAttributes = regSir.getHashMapAttributes();
									cal = regSir.getDates().get(Register.END_DATE);
									sirhusAttributes.put(Register.END_DATE, cal.toString());
									out = new OutRegisterBean(sirhusAttributes, OutRegisterBean.ADD);
									add(out);
									cal.add(Calendar.DATE, +1);
									resedaAttributes.put(Register.START_DATE, cal.toString());
									if(!resedaAttributes.get(Register.PROVENANCE).equals(sirhusAttributes.get(Register.PROVENANCE))){
										resedaAttributes.put(Register.PROVENANCE, sirhusAttributes.get(Register.PROVENANCE));
									}
									out = new OutRegisterBean(resedaAttributes, OutRegisterBean.UPDATE);
									update(out, regRes.getId());
								}
								
							}//end startDate== endDate !=
							
							
							//cas dates début différentes
							else if(!regSir.getDates().get(Register.START_DATE).equals(regRes.getDates().get(Register.START_DATE)) && regSir.getDates().get(Register.END_DATE).equals(regRes.getDates().get(Register.END_DATE))){
								
								if(regSir.getDates().get(Register.START_DATE).before(regRes.getDates().get(Register.START_DATE))){
									delete(regRes, regRes.getId());
									add(regSir);
								}
								//Si date intermédiaire : conservation de la première période et début de la seconde à la date Sirhus
								else if(regSir.getDates().get(Register.START_DATE).after(regRes.getDates().get(Register.START_DATE)) && !regSir.getDates().get(Register.START_DATE).after(regRes.getDates().get(Register.END_DATE))){
									if(!regSir.getAttributes().equals(regRes.getAttributes())){
										resedaAttributes = regRes.getHashMapAttributes();
										sirhusAttributes = regSir.getHashMapAttributes();
										cal = regSir.getDates().get(Register.START_DATE);
										cal.add(Calendar.DATE, -1);
										//conservation de la période resStartDate-SirStartDate
										resedaAttributes.put(Register.END_DATE, cal.toString());
										out = new OutRegisterBean(resedaAttributes, OutRegisterBean.UPDATE);
										update(out, regRes.getId());
										add(regSir);
									}//end if attributes =!
									else{
										update(regSir, regRes.getId());
									}
									
								}//end if sirStartDate entre resStartDate et ResEndDate
							}//end startDate != endDate== 
							
							
							
							//cas dates début et fin différentes
							else if (!regSir.getDates().get(Register.START_DATE).equals(regRes.getDates().get(Register.START_DATE)) && !regSir.getDates().get(Register.END_DATE).equals(regRes.getDates().get(Register.END_DATE))){
								//TODO: Test date avant / après
								if(regSir.getDates().get(Register.START_DATE).before(regRes.getDates().get(Register.START_DATE))){
									if(regSir.getAttributes().equals(regRes.getAttributes())){
//										update(regSir, regRes.getId());
									}//end if attributes ==
								}//end if sir startDate before
								
								
								
							}//end Dates !=
							
							
							
							//cas dates égales
							else{
								//TODO
								if(regSir.getAttributes().equals(regRes.getAttributes())){
									
								}
								update(regSir, regRes.getId());
								
								
								
							}
							
						}//end discriminants ==
						
						
						//cas discriminant différent : nouvel enregistrement
						else{
							nothing(regRes, regRes.getId());
							add(regSir);
						}
					}//end for discriminants
				}//end else equality
				
				
			}//end for reseda
		}//end for sirhus
		
		
	}//end compare
	
	public List<Register> getSirhusEntry(){
		return this.sirhusEntry;
	}
	
	public List<Register> getResedaEntry(){
		return this.resedaEntry;
	}
	
	public Stack<Register> getOut(){
		return this.out;
	}
	
	public void addSirhusEntry(Register entry){
		this.sirhusEntry.add(entry);
	}
	
	public void addResedaEntry(Register entry){
		this.resedaEntry.add(entry);
	}
	
}