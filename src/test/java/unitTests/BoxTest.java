package unitTests;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import algorithm.Box;
import algorithm.bean.RegisterBean;
import junit.framework.TestCase;

public class BoxTest extends TestCase {

	public BoxTest(String arg0){
		super(arg0);
	}
	
	public static void main(String[]  args){
		junit.swingui.TestRunner.run(BoxTest.class);
	}
	
	protected void setUp() throws Exception{
		super.setUp();
	}
	
	protected void tearDown() throws Exception{
		super.tearDown();
	}
	
	public void testFusion(){
		try {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		
		Calendar dateDebut = Calendar.getInstance();
		Calendar dateFin = Calendar.getInstance();
		Map<String, String> attHisto1 = new HashMap<String, String>();
		attHisto1.put("FinPrevisionnelle", "20180222");
		attHisto1.put("TypeContrat", "TQ");
		attHisto1.put("GradeAssimile", "CDD");
		attHisto1.put("TypeFinancement", "SE");
		attHisto1.put("NiveauCorps", "IR");
		String dateString = "23/02/2015";
		Calendar dateDebut1 = Calendar.getInstance();
		dateDebut1.setTime(sdf.parse(dateString));
		dateString = "31/12/9999";
		Calendar dateFin1 = Calendar.getInstance();
		dateFin1.setTime(sdf.parse(dateString));
		RegisterBean histo1 = new RegisterBean(dateDebut1, dateFin1, attHisto1);
		
		Map<String, String> attHisto2 = new HashMap<String, String>();
		attHisto2.put("FinPrevisionnelle", "20150222");
		attHisto2.put("TypeContrat", "T0");
		attHisto2.put("GradeAssimile", "CDD");
		attHisto2.put("TypeFinancement", "SE");
		dateString = "01/10/2011";
		Calendar dateDebut2 = Calendar.getInstance();
		dateDebut2.setTime(sdf.parse(dateString));
		dateString = "22/02/2015";
		Calendar dateFin2 = Calendar.getInstance();
		dateFin2.setTime(sdf.parse(dateString));
		RegisterBean histo2 = new RegisterBean(dateDebut2, dateFin2, attHisto2);
		
		Map<String, String> attPos1 = new HashMap<String, String>();
		attPos1.put("CodePositionAdministrative", "11");
		attPos1.put("CodePositionStatutaire", "AA");
		attPos1.put("RefusComptable", "NON");
		attPos1.put("TypePosition", "E");
		attPos1.put("CodeOrganisme", "560");
		attPos1.put("NumPeriode", "1");
		dateString = "01/02/2017";
		Calendar dateDebut3 = Calendar.getInstance();
		dateDebut3.setTime(sdf.parse(dateString));
		dateString = "31/12/9999";
		Calendar dateFin3 = Calendar.getInstance();
		dateFin3.setTime(sdf.parse(dateString));
		RegisterBean pos1 = new RegisterBean(dateDebut3, dateFin3, attPos1);
		
		Map<String, String> attPos2 = new HashMap<String, String>();
		attPos2.put("CodePositionAdministrative", "11");
		attPos2.put("CodePositionStatutaire", "AA");
		attPos2.put("RefusComptable", "NON");
		attPos2.put("TypePosition", "E");
		attPos2.put("CodeOrganisme", "10807");
		attPos2.put("NumPeriode", "1");
		dateString = "23/02/2015";
		Calendar dateDebut4 = Calendar.getInstance();
		dateDebut4.setTime(sdf.parse(dateString));
		dateString = "31/01/2017";
		Calendar dateFin4 = Calendar.getInstance();
		dateFin4.setTime(sdf.parse(dateString));
		RegisterBean pos2 = new RegisterBean(dateDebut4, dateFin4, attPos2);
		
		Map<String, String> attPos3 = new HashMap<String, String>();
		attPos3.put("CodePositionAdministrative", "11");
		attPos3.put("CodePositionStatutaire", "AA");
		attPos3.put("RefusComptable", "NON");
		attPos3.put("TypePosition", "E");
		attPos3.put("CodeOrganisme", "560");
		attPos3.put("NumPeriode", "1");
		dateString = "01/10/2011";
		Calendar dateDebut5 = Calendar.getInstance();
		dateDebut5.setTime(sdf.parse(dateString));
		dateString = "22/02/2015";
		Calendar dateFin5 = Calendar.getInstance();
		dateFin5.setTime(sdf.parse(dateString));
		RegisterBean pos3 = new RegisterBean(dateDebut5, dateFin5, attPos3);
		
		
		List<RegisterBean> list1 = new ArrayList<RegisterBean>();
		List<RegisterBean> list2 = new ArrayList<RegisterBean>();
		
		list1.add(histo1);
		list1.add(histo2);
		
		list2.add(pos1);
		list2.add(pos2);
		list2.add(pos3);
		
		
		List<RegisterBean> listRef = new ArrayList<RegisterBean>();
		
		Map<String, String> attRef1 = new HashMap<String, String>();
		attRef1.put("CodePositionAdministrative", "11");
		attRef1.put("CodePositionStatutaire", "AA");
		attRef1.put("RefusComptable", "NON");
		attRef1.put("TypePosition", "E");
		attRef1.put("CodeOrganisme", "560");
		attRef1.put("NumPeriode", "1");
		attRef1.put("FinPrevisionnelle", "20180222");
		attRef1.put("TypeContrat", "TQ");
		attRef1.put("GradeAssimile", "CDD");
		attRef1.put("TypeFinancement", "SE");
		attRef1.put("NiveauCorps", "IR");
		dateString = "01/02/2017";
		Calendar dateDebut6 = Calendar.getInstance();
		dateDebut6.setTime(sdf.parse(dateString));
		dateString = "31/12/9999";
		Calendar dateFin6 = Calendar.getInstance();
		dateFin6.setTime(sdf.parse(dateString));
		RegisterBean ref1 = new RegisterBean(dateDebut6, dateFin6, attRef1);
		
//		Map<String, String> attTest = new HashMap<String, String>();
//		attTest.put("CodePositionAdministrative", "11");
//		attTest.put("CodePositionStatutaire", "AA");
//		attTest.put("RefusComptable", "NON");
//		attTest.put("TypePosition", "E");
//		attTest.put("FinPrevisionnelle", "20180222");
//		attTest.put("CodeOrganisme", "560");
//		attTest.put("NumPeriode", "1");
//		attTest.put("TypeContrat", "TQ");
//		attTest.put("GradeAssimile", "CDD");
//		attTest.put("TypeFinancement", "SE");
//		attTest.put("NiveauCorps", "IR");
//		toto = "01/09/2011";
//		dateDebut.setTime(sdf.parse(toto));
//		toto = "22/02/2015";
//		dateFin.setTime(sdf.parse(toto));
//		RegisterBean refTest = new RegisterBean(dateDebut, dateFin, attTest);
		
		Map<String, String> attRef2 = new HashMap<String, String>();
		attRef2.put("CodePositionAdministrative", "11");
		attRef2.put("CodePositionStatutaire", "AA");
		attRef2.put("RefusComptable", "NON");
		attRef2.put("TypePosition", "E");
		attRef2.put("CodeOrganisme", "560");
		attRef2.put("NumPeriode", "1");
		attRef2.put("FinPrevisionnelle", "20180222");
		attRef2.put("TypeContrat", "TQ");
		attRef2.put("GradeAssimile", "CDD");
		attRef2.put("TypeFinancement", "SE");
		attRef2.put("NiveauCorps", "IR");
		dateString = "23/02/2015";
		Calendar dateDebut7 = Calendar.getInstance();
		dateDebut7.setTime(sdf.parse(dateString));
		dateString = "31/01/2017";
		Calendar dateFin7 = Calendar.getInstance();
		dateFin7.setTime(sdf.parse(dateString));
		RegisterBean ref2 = new RegisterBean(dateDebut7, dateFin7, attRef2);
		
		Map<String, String> attRef3 = new HashMap<String, String>();
		attRef3.put("CodePositionAdministrative", "11");
		attRef3.put("CodePositionStatutaire", "AA");
		attRef3.put("RefusComptable", "NON");
		attRef3.put("TypePosition", "E");
		attRef3.put("CodeOrganisme", "560");
		attRef3.put("NumPeriode", "1");
		attRef3.put("FinPrevisionnelle", "20150222");
		attRef3.put("TypeContrat", "T0");
		attRef3.put("GradeAssimile", "CDD");
		attRef3.put("TypeFinancement", "SE");
		dateString = "01/10/2011";
		Calendar dateDebut8 = Calendar.getInstance();
		dateDebut8.setTime(sdf.parse(dateString));
		dateString = "22/02/2015";
		Calendar dateFin8 = Calendar.getInstance();
		dateFin8.setTime(sdf.parse(dateString));
		RegisterBean ref3 = new RegisterBean(dateDebut8, dateFin8, attRef3);
		
		listRef.add(ref1);
		listRef.add(ref2);
		listRef.add(ref3);
		
//		for(int i = 0; i < list1.size() ; i++){
//			System.out.println("list1 debut" + i +" "+ sdf.format(list1.get(i).getDateDebut().getTime()));
//			System.out.println("list1 fin" + i +" "+ sdf.format(list1.get(i).getDateFin().getTime()) +"\n");
//		}
		
		Box box = new Box(list1, list2);
		List<RegisterBean> listTrouvee = box.fusion(list1, list2);
		System.out.println("tr " + listTrouvee.size());
		
		for(int i = 0; i < listTrouvee.size() ; i++){
			System.out.println("listTr debut" + i +" "+ sdf.format(listTrouvee.get(i).getDateDebut().getTime()));
			System.out.println("listTr fin" + i +" "+ sdf.format(listTrouvee.get(i).getDateFin().getTime()) +"\n");
		}
		
		System.out.println("ref " + listRef.size());
		
		for(int i = 0; i < listRef.size() ; i++){
			System.out.println("listRef debut" + i +" "+ sdf.format(listRef.get(i).getDateDebut().getTime()));
			System.out.println("listRef fin" + i +" "+ sdf.format(listRef.get(i).getDateFin().getTime()) +"\n");
		}
		
		List<RegisterBean> trouvList = new ArrayList<RegisterBean>(listTrouvee);
	    List<RegisterBean> revList = new ArrayList<RegisterBean>(listRef);
	    Boolean equal = false;
	    for(RegisterBean reg : trouvList){
	    	for(RegisterBean reg2 : revList){
	    		if(reg.equals(reg2)){
	    			trouvList.remove(reg);
	    			revList.remove(reg2);
	    		}
	    	}
	    }
//	    if(ref1.equals(refTest)){
		if(trouvList.isEmpty() && revList.isEmpty()){
			equal = true;
		}
		assertTrue(equal);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
