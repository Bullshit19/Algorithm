package algorithm;

import java.text.ParseException;
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
		
		for(Register regSir : sirhus){
			for(Register regRes : reseda){
//				Chech if the registers are equal
				if(regSir.equals(regRes)){
					nothing(regRes, regRes.getId());
					sirhus.remove(regSir);
					reseda.remove(regRes);
				}
				else{
					for(String dis : discriminants){
						//if the disciminants are equal : test the dates
						if(regSir.get(dis).equals(regRes.get(dis))){
							
							if(regSir.getDates().get(Register.START_DATE).equals(regRes.getDates().get(Register.START_DATE)) && regSir.getDates().get(Register.END_DATE).equals(regRes.getDates().get(Register.END_DATE))){
								//if the dates are equals : attribut diff = update else seen if register == reg	
								update(regSir,regRes.getId());									
							}//end dates ==
							
							else if(regSir.getDates().get(Register.START_DATE).equals(regRes.getDates().get(Register.START_DATE)) && !regSir.getDates().get(Register.END_DATE).equals(regRes.getDates().get(Register.END_DATE))){
							//if endDate != && endDateSir > endDateRes ==> update Sinon 2 périodes
								if(regSir.getDates().get(Register.END_DATE).before(regRes.getDates().get(Register.END_DATE))){
									update(regSir,regRes.getId());
								}
								else{
									
								}
								//TODO
							}//end startDate== endDate !=
							
							else if(!regSir.getDates().get(Register.START_DATE).equals(regRes.getDates().get(Register.START_DATE)) && regSir.getDates().get(Register.END_DATE).equals(regRes.getDates().get(Register.END_DATE))){
								//if start != ==> if attributes =! ==> 
								//TODO: Test date avant / après
								if(regSir.getDates().get(Register.START_DATE).before(regRes.getDates().get(Register.START_DATE))){
									delete(regRes, regRes.getId());
									add(regSir);
								}
								//Si date intermédiaire : conservation de la première période et début de la seconde à la date Sirhus
								//Prévoir set Date
//									if(regSir.getAttributes().equals(regRes.getAttributes())){
//										delete(regRes, regRes.getId());
//										add(regSir, null);
//									}
									else{
										//TODO:
									}
							}//end startDate != endDate== 
							
							else if (!regSir.getDates().get(Register.START_DATE).equals(regRes.getDates().get(Register.START_DATE)) && !regSir.getDates().get(Register.END_DATE).equals(regRes.getDates().get(Register.END_DATE))){
								//TODO: Test date avant / après
								if(regSir.getAttributes().equals(regRes.getAttributes())){
//									update(regSir, regRes.getId());
								}
							}//end Dates !=
						}//end discriminants ==
						
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