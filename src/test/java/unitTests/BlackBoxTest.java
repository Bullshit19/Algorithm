package unitTests;

import java.awt.List;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Stack;

import algorithm.BlackBox;
import algorithm.bean.OutRegisterBean;
import algorithm.bean.ResedaRegisterBean;
import algorithm.bean.SirhusRegisterBean;
import algorithm.core.Register;
import junit.framework.TestCase;

public class BlackBoxTest extends TestCase{
		
	public BlackBoxTest(String arg0){
		super(arg0);
	}
	
	public static void main(String[]  args){
		junit.swingui.TestRunner.run(BlackBoxTest.class);
	}
	
	protected void setUp() throws Exception{
		super.setUp();
	}
	
	protected void tearDown() throws Exception{
		super.tearDown();
	}
	
	public void testAdd(){
		
		HashMap<String, String> arg1 = new HashMap<>();
		arg1.put("employer","employer");
		arg1.put("name","name");
		arg1.put("firstName","firstName");
		arg1.put("secondName","secondName");
		arg1.put("thirdName","thirdName");
		arg1.put("provenance","sirhus");
		arg1.put("startDate","01/01/2005");
		arg1.put("endDate","01/01/2017");
		arg1.put("attribute","attribut1");
		HashMap<String, String> arg1DateDebutAnterieure = new HashMap<>();
		arg1.put("employer","employer");
		arg1.put("name","name");
		arg1.put("firstName","firstName");
		arg1.put("secondName","secondName");
		arg1.put("thirdName","thirdName");
		arg1.put("provenance","sirhus");
		arg1.put("startDate","05/09/2004");
		arg1.put("endDate","01/01/2017");
		arg1.put("attribute","attribut1");

		
		
		HashMap<String, String> arg2 = new HashMap<>();
		arg2.put("employer","employer2");
		arg2.put("name","name2");
		arg2.put("firstName","firstName2");
		arg2.put("secondName","");
		arg2.put("thirdName","");
		arg2.put("provenance","reseda");
		arg2.put("startDate","05/09/2004");
		arg2.put("endDate","01/01/2018");
		arg2.put("attribute","attribut12");
		HashMap<String, String> arg2Provenance = new HashMap<>();
		arg2Provenance.put("employer","employer2");
		arg2Provenance.put("name","name2");
		arg2Provenance.put("firstName","firstName2");
		arg2Provenance.put("secondName","");
		arg2Provenance.put("thirdName","");
		arg2Provenance.put("provenance","sirhus");
		arg2Provenance.put("startDate","05/09/2004");
		arg2Provenance.put("endDate","01/01/2018");
		arg2Provenance.put("attribute","attribut12");


		
		HashMap<String, String> arg3 = new HashMap<>();
		arg3.put("employer","employer3");
		arg3.put("name","name3");
		arg3.put("firstName","firstName3");
		arg3.put("secondName","secondName3");
		arg3.put("thirdName","thirdName3");
		arg3.put("provenance","reseda");
		arg3.put("startDate","01/01/2005");
		arg3.put("endDate","01/01/2017");
		arg3.put("attribute","attribut13");
		HashMap<String, String> arg3ProvenanceEtAttribut = new HashMap<>();
		arg3ProvenanceEtAttribut.put("employer","employer3");
		arg3ProvenanceEtAttribut.put("name","name3");
		arg3ProvenanceEtAttribut.put("firstName","firstName3");
		arg3ProvenanceEtAttribut.put("secondName","secondName3");
		arg3ProvenanceEtAttribut.put("thirdName","thirdName3");
		arg3ProvenanceEtAttribut.put("provenance","sirhus");
		arg3ProvenanceEtAttribut.put("startDate","01/01/2005");
		arg3ProvenanceEtAttribut.put("endDate","01/01/2017");
		arg3ProvenanceEtAttribut.put("attribute","attribut130");
		


		HashMap<String, String> arg4 = new HashMap<>();
		arg4.put("employer","employer4");
		arg4.put("name","name4");
		arg4.put("firstName","firstName4");
		arg4.put("secondName","secondNam4e");
		arg4.put("thirdName","thirdName4");
		arg4.put("provenance","sirhus");
		arg4.put("startDate","01/01/2005");
		arg4.put("endDate","01/01/2017");
		arg4.put("attribute","attribut14");
		HashMap<String, String> arg4DateFinPosterieure = new HashMap<>();
		arg4DateFinPosterieure.put("employer","employer4");
		arg4DateFinPosterieure.put("name","name4");
		arg4DateFinPosterieure.put("firstName","firstName4");
		arg4DateFinPosterieure.put("secondName","secondName4");
		arg4DateFinPosterieure.put("thirdName","thirdName4");
		arg4DateFinPosterieure.put("provenance","sirhus");
		arg4DateFinPosterieure.put("startDate","01/01/2005");
		arg4DateFinPosterieure.put("endDate","01/01/2018");
		arg4DateFinPosterieure.put("attribute","attribut14");

		
		
		HashMap<String, String> arg5 = new HashMap<>();
		arg5.put("employer","employer5");
		arg5.put("name","name5");
		arg5.put("firstName","firstName5");
		arg5.put("secondName","secondName5");
		arg5.put("thirdName","thirdName5");
		arg5.put("provenance","sirhus");
		arg5.put("startDate","01/01/2005");
		arg5.put("endDate","01/01/2017");
		arg5.put("attribute","attribut15");
		HashMap<String, String> arg5DateDebutEtFinPosterieures = new HashMap<>();
		arg5DateDebutEtFinPosterieures.put("employer","employer5");
		arg5DateDebutEtFinPosterieures.put("name","name5");
		arg5DateDebutEtFinPosterieures.put("firstName","firstName5");
		arg5DateDebutEtFinPosterieures.put("secondName","secondName5");
		arg5DateDebutEtFinPosterieures.put("thirdName","thirdName5");
		arg5DateDebutEtFinPosterieures.put("provenance","sirhus");
		arg5DateDebutEtFinPosterieures.put("startDate","02/01/2017");
		arg5DateDebutEtFinPosterieures.put("endDate","01/01/2018");
		arg5DateDebutEtFinPosterieures.put("attribute","attribut15");

		
		
		HashMap<String, String> arg6 = new HashMap<>();
		arg6.put("employer","employer6");
		arg6.put("name","name6");
		arg6.put("firstName","firstName6");
		arg6.put("secondName","secondName6");
		arg6.put("thirdName","thirdName6");
		arg6.put("provenance","sirhus");
		arg6.put("startDate","01/01/2005");
		arg6.put("endDate","01/01/2017");
		arg6.put("attribute","attribut16");
		HashMap<String, String> arg6PeriodePosterieureEtAttribut = new HashMap<>();
		arg6PeriodePosterieureEtAttribut.put("employer","employer6");
		arg6PeriodePosterieureEtAttribut.put("name","name6");
		arg6PeriodePosterieureEtAttribut.put("firstName","firstName6");
		arg6PeriodePosterieureEtAttribut.put("secondName","secondName6");
		arg6PeriodePosterieureEtAttribut.put("thirdName","thirdName6");
		arg6PeriodePosterieureEtAttribut.put("provenance","sirhus");
		arg6PeriodePosterieureEtAttribut.put("startDate","02/01/2017");
		arg6PeriodePosterieureEtAttribut.put("endDate","01/01/2018");
		arg6PeriodePosterieureEtAttribut.put("attribute","attribut161");



		
		HashMap<String, String> arg7 = new HashMap<>();
		arg7.put("employer","employer7");
		arg7.put("name","name7");
		arg7.put("firstName","firstName7");
		arg7.put("secondName","secondName7");
		arg7.put("thirdName","thirdName7");
		arg7.put("provenance","sirhus");
		arg7.put("startDate","01/01/2005");
		arg7.put("endDate","01/01/2017");
		arg7.put("attribute","attribut17");
		HashMap<String, String> arg7DateFinAnterieure = new HashMap<>();
		arg7DateFinAnterieure.put("employer","employer7");
		arg7DateFinAnterieure.put("name","name7");
		arg7DateFinAnterieure.put("firstName","firstName7");
		arg7DateFinAnterieure.put("secondName","secondName7");
		arg7DateFinAnterieure.put("thirdName","thirdName7");
		arg7DateFinAnterieure.put("provenance","sirhus");
		arg7DateFinAnterieure.put("startDate","01/01/2005");
		arg7DateFinAnterieure.put("endDate","01/01/2016");
		arg7DateFinAnterieure.put("attribute","attribut17");
		
		
		
		HashMap<String, String> arg8 = new HashMap<>();
		arg8.put("employer","employer8");
		arg8.put("name","name8");
		arg8.put("firstName","firstName8");
		arg8.put("secondName","secondName8");
		arg8.put("thirdName","thirdName8");
		arg8.put("provenance","sirhus");
		arg8.put("startDate","01/01/2005");
		arg8.put("endDate","01/01/2017");
		arg8.put("attribute","attribut18");
		HashMap<String, String> arg8DateDebutInterEtAttributUpdated = new HashMap<>();
		arg8DateDebutInterEtAttributUpdated.put("employer","employer8");
		arg8DateDebutInterEtAttributUpdated.put("name","name8");
		arg8DateDebutInterEtAttributUpdated.put("firstName","firstName8");
		arg8DateDebutInterEtAttributUpdated.put("secondName","secondName8");
		arg8DateDebutInterEtAttributUpdated.put("thirdName","thirdName8");
		arg8DateDebutInterEtAttributUpdated.put("provenance","sirhus");
		arg8DateDebutInterEtAttributUpdated.put("startDate","01/01/2005");
		arg8DateDebutInterEtAttributUpdated.put("endDate","31/12/2007");
		arg8DateDebutInterEtAttributUpdated.put("attribute","attribut18");
		HashMap<String, String> arg8DateDebutInterEtAttribut = new HashMap<>();
		arg8DateDebutInterEtAttribut.put("employer","employer8");
		arg8DateDebutInterEtAttribut.put("name","name8");
		arg8DateDebutInterEtAttribut.put("firstName","firstName8");
		arg8DateDebutInterEtAttribut.put("secondName","secondName8");
		arg8DateDebutInterEtAttribut.put("thirdName","thirdName8");
		arg8DateDebutInterEtAttribut.put("provenance","sirhus");
		arg8DateDebutInterEtAttribut.put("startDate","01/01/2008");
		arg8DateDebutInterEtAttribut.put("endDate","01/01/2017");
		arg8DateDebutInterEtAttribut.put("attribute","attribut181");
		
		
		
		HashMap<String, String> arg9 = new HashMap<>();
		arg9.put("employer","employer9");
		arg9.put("name","name9");
		arg9.put("firstName","firstName9");
		arg9.put("secondName","secondName9");
		arg9.put("thirdName","thirdName9");
		arg9.put("provenance","sirhus");
		arg9.put("startDate","01/01/2005");
		arg9.put("endDate","01/01/2017");
		arg9.put("attribute","attribut19");
		HashMap<String, String> arg9EmployeurEtPeriode = new HashMap<>();
		arg9EmployeurEtPeriode.put("employer","employer91");
		arg9EmployeurEtPeriode.put("name","name9");
		arg9EmployeurEtPeriode.put("firstName","firstName9");
		arg9EmployeurEtPeriode.put("secondName","secondName9");
		arg9EmployeurEtPeriode.put("thirdName","thirdName9");
		arg9EmployeurEtPeriode.put("provenance","sirhus");
		arg9EmployeurEtPeriode.put("startDate","01/01/2017");
		arg9EmployeurEtPeriode.put("endDate","01/01/2018");
		arg9EmployeurEtPeriode.put("attribute","attribut19");
		


		
		HashMap<String, String> arg10 = new HashMap<>();
		arg10.put("employer","employer10");
		arg10.put("name","name10");
		arg10.put("firstName","firstName10");
		arg10.put("secondName","secondName10");
		arg10.put("thirdName","thirdName10");
		arg10.put("provenance","sirhus");
		arg10.put("startDate","01/01/2005");
		arg10.put("endDate","01/01/2017");
		arg10.put("attribute","attribut110");
		HashMap<String, String> arg10Employeur = new HashMap<>();
		arg10Employeur.put("employer","employer102");
		arg10Employeur.put("name","name10");
		arg10Employeur.put("firstName","firstName10");
		arg10Employeur.put("secondName","secondName10");
		arg10Employeur.put("thirdName","thirdName10");
		arg10Employeur.put("provenance","sirhus");
		arg10Employeur.put("startDate","01/01/2005");
		arg10Employeur.put("endDate","01/01/2017");
		arg10Employeur.put("attribute","attribut110");
		
		


		HashMap<String, String> arg11 = new HashMap<>();
		arg11.put("employer","employer11");
		arg11.put("name","name11");
		arg11.put("firstName","firstName11");
		arg11.put("secondName","secondName11");
		arg11.put("thirdName","thirdName11");
		arg11.put("provenance","sirhus");
		arg11.put("startDate","01/01/2005");
		arg11.put("endDate","01/01/2017");
		arg11.put("attribute","attribut111");
		HashMap<String, String> arg11Attribut = new HashMap<>();
		arg11Attribut.put("employer","employer11");
		arg11Attribut.put("name","name11");
		arg11Attribut.put("firstName","firstName11");
		arg11Attribut.put("secondName","secondName11");
		arg11Attribut.put("thirdName","thirdName11");
		arg11Attribut.put("provenance","sirhus");
		arg11Attribut.put("startDate","01/01/2005");
		arg11Attribut.put("endDate","01/01/2017");
		arg11Attribut.put("attribute","attribut111");
		
		


		HashMap<String, String> arg12 = new HashMap<>();
		arg12.put("employer","employer12");
		arg12.put("name","name12");
		arg12.put("firstName","firstName12");
		arg12.put("secondName","secondName12");
		arg12.put("thirdName","thirdName12");
		arg12.put("provenance","reseda");
		arg12.put("startDate","15/12/2005");
		arg12.put("endDate","01/01/2017");
		arg12.put("attribute","attribut112");
		HashMap<String, String> arg12ProvenanceEtDateFinPosterieure = new HashMap<>();
		arg12ProvenanceEtDateFinPosterieure.put("employer","employer12");
		arg12ProvenanceEtDateFinPosterieure.put("name","name12");
		arg12ProvenanceEtDateFinPosterieure.put("firstName","firstName12");
		arg12ProvenanceEtDateFinPosterieure.put("secondName","secondName12");
		arg12ProvenanceEtDateFinPosterieure.put("thirdName","thirdName12");
		arg12ProvenanceEtDateFinPosterieure.put("provenance","sirhus");
		arg12ProvenanceEtDateFinPosterieure.put("startDate","15/12/2005");
		arg12ProvenanceEtDateFinPosterieure.put("endDate","01/03/2017");
		arg12ProvenanceEtDateFinPosterieure.put("attribute","attribut112");
		


		HashMap<String, String> arg13 = new HashMap<>();
		arg13.put("employer","employer13");
		arg13.put("name","name13");
		arg13.put("firstName","firstName13");
		arg13.put("secondName","secondName13");
		arg13.put("thirdName","thirdName13");
		arg13.put("provenance","reseda");
		arg13.put("startDate","01/01/2005");
		arg13.put("endDate","01/01/2017");
		arg13.put("attribute","attribut113");
		HashMap<String, String> arg13ProvenanceEtDateFinPosterieureEtAttribut = new HashMap<>();
		arg13ProvenanceEtDateFinPosterieureEtAttribut.put("employer","employer13");
		arg13ProvenanceEtDateFinPosterieureEtAttribut.put("name","name13");
		arg13ProvenanceEtDateFinPosterieureEtAttribut.put("firstName","firstName13");
		arg13ProvenanceEtDateFinPosterieureEtAttribut.put("secondName","secondName13");
		arg13ProvenanceEtDateFinPosterieureEtAttribut.put("thirdName","thirdName13");
		arg13ProvenanceEtDateFinPosterieureEtAttribut.put("provenance","sirhus");
		arg13ProvenanceEtDateFinPosterieureEtAttribut.put("startDate","01/01/2005");
		arg13ProvenanceEtDateFinPosterieureEtAttribut.put("endDate","01/03/2017");
		arg13ProvenanceEtDateFinPosterieureEtAttribut.put("attribute","attribut1131");

		
		
		HashMap<String, String> arg14 = new HashMap<>();
		arg14.put("employer","employer14");
		arg14.put("name","name14");
		arg14.put("firstName","firstName14");
		arg14.put("secondName","secondName14");
		arg14.put("thirdName","thirdName14");
		arg14.put("provenance","reseda");
		arg14.put("startDate","01/01/2005");
		arg14.put("endDate","01/01/2017");
		arg14.put("attribute","attribut114");
		HashMap<String, String> arg14ProvenanceEtDateDebutPosterieureEtAttribut = new HashMap<>();
		arg14ProvenanceEtDateDebutPosterieureEtAttribut.put("employer","employer14");
		arg14ProvenanceEtDateDebutPosterieureEtAttribut.put("name","name14");
		arg14ProvenanceEtDateDebutPosterieureEtAttribut.put("firstName","firstName14");
		arg14ProvenanceEtDateDebutPosterieureEtAttribut.put("secondName","secondName14");
		arg14ProvenanceEtDateDebutPosterieureEtAttribut.put("thirdName","thirdName14");
		arg14ProvenanceEtDateDebutPosterieureEtAttribut.put("provenance","sirhus");
		arg14ProvenanceEtDateDebutPosterieureEtAttribut.put("startDate","01/08/2005");
		arg14ProvenanceEtDateDebutPosterieureEtAttribut.put("endDate","01/01/2017");
		arg14ProvenanceEtDateDebutPosterieureEtAttribut.put("attribute","attribut1141");

		
		
		
		HashMap<String, String> arg15 = new HashMap<>();
		arg15.put("employer","employer15");
		arg15.put("name","name15");
		arg15.put("firstName","firstName15");
		arg15.put("secondName","secondName15");
		arg15.put("thirdName","thirdName15");
		arg15.put("provenance","sirhus");
		arg15.put("startDate","01/01/2005");
		arg15.put("endDate","01/01/2017");
		arg15.put("attribute","attribut115");

		
		
		
		HashMap<String, String> arg16 = new HashMap<>();
		arg16.put("employer","employer16");
		arg16.put("name","name16");
		arg16.put("firstName","firstName16");
		arg16.put("secondName","secondName16");
		arg16.put("thirdName","thirdName16");
		arg16.put("provenance","sirhus");
		arg16.put("startDate","15/11/2009");
		arg16.put("endDate","31/12/2020");
		arg16.put("attribute","attribut116");
		
		
		
		HashMap<String, String> arg17 = new HashMap<>();
		arg17.put("employer","employer17");
		arg17.put("name","name17");
		arg17.put("firstName","firstName17");
		arg17.put("secondName","secondName17");
		arg17.put("thirdName","thirdName17");
		arg17.put("provenance","sirhus");
		arg17.put("startDate","15/11/2009");
		arg17.put("endDate","31/12/2012");
		arg17.put("attribute","attribut117");
		HashMap<String, String> arg17b = new HashMap<>();
		arg17b.put("employer","employer17");
		arg17b.put("name","name17");
		arg17b.put("firstName","firstName17");
		arg17b.put("secondName","secondName17");
		arg17b.put("thirdName","thirdName17");
		arg17b.put("provenance","sirhus");
		arg17b.put("startDate","15/11/2013");
		arg17b.put("endDate","31/12/2020");
		arg17b.put("attribute","attribut117b");
		HashMap<String, String> arg17PremiereDateFinPosterieurEtPeriodeChevauchanteSurDeuxiemeEntreeUpdated = new HashMap<>();
		arg17PremiereDateFinPosterieurEtPeriodeChevauchanteSurDeuxiemeEntreeUpdated.put("employer","employer17");
		arg17PremiereDateFinPosterieurEtPeriodeChevauchanteSurDeuxiemeEntreeUpdated.put("name","name17");
		arg17PremiereDateFinPosterieurEtPeriodeChevauchanteSurDeuxiemeEntreeUpdated.put("firstName","firstName17");
		arg17PremiereDateFinPosterieurEtPeriodeChevauchanteSurDeuxiemeEntreeUpdated.put("secondName","secondName17");
		arg17PremiereDateFinPosterieurEtPeriodeChevauchanteSurDeuxiemeEntreeUpdated.put("thirdName","thirdName17");
		arg17PremiereDateFinPosterieurEtPeriodeChevauchanteSurDeuxiemeEntreeUpdated.put("provenance","sirhus");
		arg17PremiereDateFinPosterieurEtPeriodeChevauchanteSurDeuxiemeEntreeUpdated.put("startDate","01/01/2016");
		arg17PremiereDateFinPosterieurEtPeriodeChevauchanteSurDeuxiemeEntreeUpdated.put("endDate","31/12/2020");
		arg17PremiereDateFinPosterieurEtPeriodeChevauchanteSurDeuxiemeEntreeUpdated.put("attribute","attribut117");
		HashMap<String, String> arg17PremiereDateFinPosterieurEtPeriodeChevauchanteSurDeuxiemeEntree = new HashMap<>();
		arg17PremiereDateFinPosterieurEtPeriodeChevauchanteSurDeuxiemeEntree.put("employer","employer17");
		arg17PremiereDateFinPosterieurEtPeriodeChevauchanteSurDeuxiemeEntree.put("name","name17");
		arg17PremiereDateFinPosterieurEtPeriodeChevauchanteSurDeuxiemeEntree.put("firstName","firstName17");
		arg17PremiereDateFinPosterieurEtPeriodeChevauchanteSurDeuxiemeEntree.put("secondName","secondName17");
		arg17PremiereDateFinPosterieurEtPeriodeChevauchanteSurDeuxiemeEntree.put("thirdName","thirdName17");
		arg17PremiereDateFinPosterieurEtPeriodeChevauchanteSurDeuxiemeEntree.put("provenance","sirhus");
		arg17PremiereDateFinPosterieurEtPeriodeChevauchanteSurDeuxiemeEntree.put("startDate","15/11/2009");
		arg17PremiereDateFinPosterieurEtPeriodeChevauchanteSurDeuxiemeEntree.put("endDate","31/12/2015");
		arg17PremiereDateFinPosterieurEtPeriodeChevauchanteSurDeuxiemeEntree.put("attribute","attribut117");
		
		
		
		
		
		
		BlackBox myBlackBox = new BlackBox();
		Stack<Register> wantedRegisters = new Stack<Register>();
		
		//add
		Register sirhusOnly = new SirhusRegisterBean(arg16);
		myBlackBox.addSirhusEntry(sirhusOnly);
		Register wantedRegisterOnly = new OutRegisterBean(arg16, OutRegisterBean.ADD);
		wantedRegisters.push(wantedRegisterOnly);
		
		
		//nothing and add
		Register resedaEmployeur = new ResedaRegisterBean(arg10, "10");
		Register sirhusEmployeur = new SirhusRegisterBean(arg10Employeur);
		myBlackBox.addResedaEntry(resedaEmployeur);
		myBlackBox.addSirhusEntry(sirhusEmployeur);
		Register wantedRegisterEmployeurReseda = new OutRegisterBean(arg10, OutRegisterBean.NOTHING);
		Register wantedRegisterEmployeurSirhus = new OutRegisterBean(arg10Employeur, OutRegisterBean.ADD);
		wantedRegisters.push(wantedRegisterEmployeurReseda);
		wantedRegisters.push(wantedRegisterEmployeurSirhus);
		
		Register resedaEmployeurEtPeriode = new ResedaRegisterBean(arg9, "9");
		Register sirhusEmployeurEtPeriode = new SirhusRegisterBean(arg9EmployeurEtPeriode);
		myBlackBox.addResedaEntry(resedaEmployeurEtPeriode);
		myBlackBox.addSirhusEntry(sirhusEmployeurEtPeriode);
		Register wantedRegisterEmployeurEtPeriodeReseda = new OutRegisterBean(arg9, OutRegisterBean.NOTHING);
		Register wantedRegisterEmployeurEtPeriodeSirhus = new OutRegisterBean(arg9EmployeurEtPeriode, OutRegisterBean.ADD);
		wantedRegisters.push(wantedRegisterEmployeurEtPeriodeReseda);
		wantedRegisters.push(wantedRegisterEmployeurEtPeriodeSirhus);
		
		Register resedaProvenanceEtDateDebutPosterieureEtAttribut = new ResedaRegisterBean(arg14, "14");
		Register sirhusProvenanceEtDateDebutPosterieureEtAttribut = new SirhusRegisterBean(arg14ProvenanceEtDateDebutPosterieureEtAttribut);
		myBlackBox.addResedaEntry(resedaProvenanceEtDateDebutPosterieureEtAttribut);
		myBlackBox.addSirhusEntry(sirhusProvenanceEtDateDebutPosterieureEtAttribut);
		Register wantedRegisterProvenanceEtDateDebutPosterieureEtAttributReseda = new OutRegisterBean(arg14, OutRegisterBean.NOTHING);
		Register wantedRegisterProvenanceEtDateDebutPosterieureEtAttributSirhus = new OutRegisterBean(arg14ProvenanceEtDateDebutPosterieureEtAttribut, OutRegisterBean.ADD);
		wantedRegisters.push(wantedRegisterProvenanceEtDateDebutPosterieureEtAttributReseda);
		wantedRegisters.push(wantedRegisterProvenanceEtDateDebutPosterieureEtAttributSirhus);
		
		
		//delete and add
		Register resedaDateDebutAnterieure = new ResedaRegisterBean(arg1, "1");
		Register sirhusDateDebutAnterieure = new SirhusRegisterBean(arg1DateDebutAnterieure);
		myBlackBox.addResedaEntry(resedaDateDebutAnterieure);
		myBlackBox.addSirhusEntry(sirhusDateDebutAnterieure);
		Register wantedRegisterDateDebutAnterieureReseda = new OutRegisterBean(arg1, OutRegisterBean.DELETE);
		Register wantedRegisterDateDebutAnterieureSirhus = new OutRegisterBean(arg1DateDebutAnterieure, OutRegisterBean.ADD);
		wantedRegisters.push(wantedRegisterDateDebutAnterieureReseda);
		wantedRegisters.push(wantedRegisterDateDebutAnterieureSirhus);
		
		Register resedaDateDebutEtFinPosterieures = new ResedaRegisterBean(arg5, "5");
		Register sirhusDateDebutEtFinPosterieures = new SirhusRegisterBean(arg5DateDebutEtFinPosterieures);
		myBlackBox.addResedaEntry(resedaDateDebutEtFinPosterieures);
		myBlackBox.addSirhusEntry(sirhusDateDebutEtFinPosterieures);
		Register wantedRegisterDateDebutEtFinPosterieuresReseda = new OutRegisterBean(arg5, OutRegisterBean.DELETE);
		Register wantedRegisterDateDebutEtFinPosterieuresSirhus = new OutRegisterBean(arg5DateDebutEtFinPosterieures, OutRegisterBean.ADD);
		wantedRegisters.push(wantedRegisterDateDebutEtFinPosterieuresReseda);
		wantedRegisters.push(wantedRegisterDateDebutEtFinPosterieuresSirhus);
		
		
		//nothing and add
		Register resedaProvenance = new ResedaRegisterBean(arg2, "2");
		Register sirhusProvenance = new SirhusRegisterBean(arg2Provenance);
		myBlackBox.addResedaEntry(resedaProvenance);
		myBlackBox.addSirhusEntry(sirhusProvenance);
		Register wantedRegisterProvenanceReseda = new OutRegisterBean(arg2, OutRegisterBean.NOTHING);
		Register wantedRegisterProvenanceSirhus = new OutRegisterBean(arg2Provenance, OutRegisterBean.ADD);
		wantedRegisters.push(wantedRegisterProvenanceReseda);
		wantedRegisters.push(wantedRegisterProvenanceSirhus);
		
		Register resedaPeriodePosterieureEtAttribut = new ResedaRegisterBean(arg6, "6");
		Register sirhusPeriodePosterieureEtAttribut = new SirhusRegisterBean(arg6PeriodePosterieureEtAttribut);
		myBlackBox.addResedaEntry(resedaPeriodePosterieureEtAttribut);
		myBlackBox.addSirhusEntry(sirhusPeriodePosterieureEtAttribut);
		Register wantedRegisterPeriodePosterieureEtAttributReseda = new OutRegisterBean(arg6, OutRegisterBean.NOTHING);	
		Register wantedRegisterPeriodePosterieureEtAttributSirhus = new OutRegisterBean(arg6PeriodePosterieureEtAttribut, OutRegisterBean.ADD);
		wantedRegisters.push(wantedRegisterPeriodePosterieureEtAttributReseda);
		wantedRegisters.push(wantedRegisterPeriodePosterieureEtAttributSirhus);
		
		//nothing
		Register resedaIdentique = new ResedaRegisterBean(arg15, "15");
		Register sirhusIdentique = new SirhusRegisterBean(arg15);
		myBlackBox.addResedaEntry(resedaIdentique);
		myBlackBox.addSirhusEntry(sirhusIdentique);
		Register wantedRegisterIdentique = new OutRegisterBean(arg15, OutRegisterBean.NOTHING);
		wantedRegisters.push(wantedRegisterIdentique);
		
		
		//update
		Register resedaDateFinPosterieure = new ResedaRegisterBean(arg4, "4");
		Register sirhusDateFinPosterieure = new SirhusRegisterBean(arg4DateFinPosterieure);
		myBlackBox.addResedaEntry(resedaDateFinPosterieure);
		myBlackBox.addSirhusEntry(sirhusDateFinPosterieure);
		Register wantedRegisterDateFinPosterieure = new OutRegisterBean(arg4DateFinPosterieure, OutRegisterBean.UPDATE);
		wantedRegisters.push(wantedRegisterDateFinPosterieure);
		
		Register resedaAttribut = new ResedaRegisterBean(arg11, "11");
		Register sirhusAttribut = new SirhusRegisterBean(arg11Attribut);
		myBlackBox.addResedaEntry(resedaAttribut);
		myBlackBox.addSirhusEntry(sirhusAttribut);
		Register wantedRegisterAttribut = new OutRegisterBean(arg11Attribut, OutRegisterBean.UPDATE);
		wantedRegisters.push(wantedRegisterAttribut);
		
		Register resedaProvenanceEtAttribut = new ResedaRegisterBean(arg3, "3");
		Register sirhusProvenanceEtAttribut = new SirhusRegisterBean(arg3ProvenanceEtAttribut);
		myBlackBox.addResedaEntry(resedaProvenanceEtAttribut);
		myBlackBox.addSirhusEntry(sirhusProvenanceEtAttribut);
		Register wantedRegisterProvenanceEtAttribut = new OutRegisterBean(arg3ProvenanceEtAttribut, OutRegisterBean.UPDATE);
		wantedRegisters.push(wantedRegisterProvenanceEtAttribut);
		
		Register resedaDateFinAnterieure = new ResedaRegisterBean(arg7, "7");
		Register sirhusDateFinAnterieure = new SirhusRegisterBean(arg7DateFinAnterieure);
		myBlackBox.addResedaEntry(resedaDateFinAnterieure);
		myBlackBox.addSirhusEntry(sirhusDateFinAnterieure);
		Register wantedRegisterDateFinAnterieure = new OutRegisterBean(arg7DateFinAnterieure, OutRegisterBean.UPDATE);
		wantedRegisters.push(wantedRegisterDateFinAnterieure);
		
		Register resedaProvenanceEtDateFinPosterieure = new ResedaRegisterBean(arg12, "12");
		Register sirhusProvenanceEtDateFinPosterieure = new SirhusRegisterBean(arg12ProvenanceEtDateFinPosterieure);
		myBlackBox.addResedaEntry(resedaProvenanceEtDateFinPosterieure);
		myBlackBox.addSirhusEntry(sirhusProvenanceEtDateFinPosterieure);
		Register wantedRegisterProvenanceEtDateFinPosterieure = new OutRegisterBean(arg12ProvenanceEtDateFinPosterieure, OutRegisterBean.UPDATE);
		wantedRegisters.push(wantedRegisterProvenanceEtDateFinPosterieure);
		
		Register resedaProvenanceEtDateFinPosterieureEtAttribut = new ResedaRegisterBean(arg13, "13");
		Register sirhusProvenanceEtDateFinPosterieureEtAttribut = new SirhusRegisterBean(arg13ProvenanceEtDateFinPosterieureEtAttribut);
		myBlackBox.addResedaEntry(resedaProvenanceEtDateFinPosterieureEtAttribut);
		myBlackBox.addSirhusEntry(sirhusProvenanceEtDateFinPosterieureEtAttribut);
		Register wantedRegisterProvenanceEtDateFinPosterieureEtAttribut = new OutRegisterBean(arg13ProvenanceEtDateFinPosterieureEtAttribut, OutRegisterBean.UPDATE);
		wantedRegisters.push(wantedRegisterProvenanceEtDateFinPosterieureEtAttribut);
		
		//update and add

		
		
		Register resedaDateDebutInterEtAttribut = new ResedaRegisterBean(arg8, "8");
		Register sirhusDateDebutInterEtAttribut = new SirhusRegisterBean(arg8DateDebutInterEtAttribut);
		myBlackBox.addResedaEntry(resedaDateDebutInterEtAttribut);
		myBlackBox.addSirhusEntry(sirhusDateDebutInterEtAttribut);
		Register wantedRegisterDateDebutInterEtAttributReseda = new OutRegisterBean(arg8DateDebutInterEtAttributUpdated, OutRegisterBean.UPDATE);	
		Register wantedRegisterDateDebutInterEtAttributSirhus = new OutRegisterBean(arg8DateDebutInterEtAttribut, OutRegisterBean.ADD);
		wantedRegisters.push(wantedRegisterDateDebutInterEtAttributReseda);
		wantedRegisters.push(wantedRegisterDateDebutInterEtAttributSirhus);
		
		
		//update, delete and add
		Register resedPremiereDateFinPosterieurEtPeriodeChevauchanteSurDeuxiemeEntree = new ResedaRegisterBean(arg17, "17");
		Register resedPremiereDateFinPosterieurEtPeriodeChevauchanteSurDeuxiemeEntree2 = new ResedaRegisterBean(arg17b, "172");
		Register sirhusPremiereDateFinPosterieurEtPeriodeChevauchanteSurDeuxiemeEntree = new SirhusRegisterBean(arg17PremiereDateFinPosterieurEtPeriodeChevauchanteSurDeuxiemeEntree);
		myBlackBox.addResedaEntry(resedPremiereDateFinPosterieurEtPeriodeChevauchanteSurDeuxiemeEntree);
		myBlackBox.addResedaEntry(resedPremiereDateFinPosterieurEtPeriodeChevauchanteSurDeuxiemeEntree2);
		myBlackBox.addSirhusEntry(sirhusPremiereDateFinPosterieurEtPeriodeChevauchanteSurDeuxiemeEntree);
		Register wantedRegisterPremiereDateFinPosterieurEtPeriodeChevauchanteSurDeuxiemeEntreeReseda = new OutRegisterBean(arg17PremiereDateFinPosterieurEtPeriodeChevauchanteSurDeuxiemeEntree, OutRegisterBean.UPDATE);
		Register wantedRegisterPremiereDateFinPosterieurEtPeriodeChevauchanteSurDeuxiemeEntreeReseda2 = new OutRegisterBean(arg17b, OutRegisterBean.DELETE);
		Register wantedRegisterPremiereDateFinPosterieurEtPeriodeChevauchanteSurDeuxiemeEntreeSirhus = new OutRegisterBean(arg17PremiereDateFinPosterieurEtPeriodeChevauchanteSurDeuxiemeEntreeUpdated, OutRegisterBean.ADD);
		wantedRegisters.push(wantedRegisterPremiereDateFinPosterieurEtPeriodeChevauchanteSurDeuxiemeEntreeReseda);
		wantedRegisters.push(wantedRegisterPremiereDateFinPosterieurEtPeriodeChevauchanteSurDeuxiemeEntreeReseda2);
		wantedRegisters.push(wantedRegisterPremiereDateFinPosterieurEtPeriodeChevauchanteSurDeuxiemeEntreeSirhus);
		
		
		try {
			myBlackBox.compare();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(wantedRegisters.equals(myBlackBox.getOut()));
	}
	

}