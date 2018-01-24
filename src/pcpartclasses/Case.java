package pcpartclasses;

import java.util.ArrayList;
import java.util.HashMap;

public class Case extends Component implements Hmapping {

private String vid;

private ArrayList<String> formFactor = null;

private String zahranvane;
private HashMap<String, Integer> broiGnezda;
private HashMap<String, Integer> ventilatori;
private HashMap<String, Integer> radiatori;
private HashMap<String, Integer> portove;
private String ekstri = null;
private Triple<Double, Double, Double> razmer = null;
private String cvqt;
private int mesecigarancia;

public Case() {}

public String getVid() {
	return vid;
}
public void setVid(String vid) {
	this.vid = vid;
}
public ArrayList<String> getFormFactor() {
	return formFactor;
}
public void setFormFactor(String formFactor) {
	 ArrayList<String> forms = new ArrayList<>();
	 for (int i = 0; i < Checkers.checkers.length; i++) {
			if(formFactor.contains(Checkers.checkers[i])) {
				
				if(Checkers.checkers[i].equals("Extended-ATX")) {
					formFactor = formFactor.replace(Checkers.checkers[i], "");
				
				forms.add("E-ATX");
	}
				else if (Checkers.checkers[i].equals("Mini-ITX")) {
					formFactor = formFactor.replace(Checkers.checkers[i], "");
				
				forms.add("Mini ITX");}
				else {
					formFactor = formFactor.replace(Checkers.checkers[i], "");
				
				forms.add(Checkers.checkers[i]);}
			}
		}
	this.formFactor = forms;
}
public String getZahranvane() {
	return zahranvane;
}
public void setZahranvane(String zahranvane) {
	this.zahranvane = zahranvane;
}
public HashMap<String, Integer>  getBroiGnezda() {
	return broiGnezda;
}
public void setBroiGnezda(String broiGnezda) {
	this.broiGnezda =Hmapping.getHmam( broiGnezda);
}
public HashMap<String, Integer>  getVentilatori() {
	return ventilatori;
}
public void setVentilatori(String ventilatori) {
	this.ventilatori = Hmapping.getHmam( ventilatori);
}
public HashMap<String, Integer>  getRadiatori() {
	return radiatori;
}
public void setRadiatori(String radiatori) {
	this.radiatori = Hmapping.getHmam( radiatori);
}
public HashMap<String, Integer>  getPortove() {
	return portove;
}
public void setPortove(String portove) {
	this.portove = Hmapping.getHmam( portove);
}
public String getEkstri() {
	return ekstri;
}
public void setEkstri(String ekstri) {
	this.ekstri = ekstri;
}

public Triple<Double,Double,Double> getRazmeri() {
	return razmer;
}
public void setRazmeri(String razmeri) {
	double x = 0, y = 0,z = 0;
	String[] CeliqPoSpaces = razmeri.split(" ");
	String[] RazmeriStr  = new String[3];
	try {		
	for (int i = 0, a =0; i < CeliqPoSpaces.length; i++) {
		
		if(CeliqPoSpaces[i].matches(".*\\d+.*")) {
			String num = CeliqPoSpaces[i].replaceAll(CeliqPoSpaces[i].replaceAll("[.*\\d+.*]", ""), "");
			RazmeriStr[a] = num;
			a++;
		}
	}
		x = Double.parseDouble(RazmeriStr[0].trim());
		y = Double.parseDouble(RazmeriStr[1].trim());
		z = Double.parseDouble(RazmeriStr[2].trim());
		Triple<Double, Double, Double> dimensions = new Triple<Double, Double, Double>(x,y,z);
		this.razmer = dimensions;
		
	}catch(Exception e) {
		System.out.println(e);

	}
	
}
public String getCvqt() {
	return cvqt;
}
public void setCvqt(String cvqt) {
	this.cvqt = cvqt;
}
public int getMesecigarancia() {
	return mesecigarancia;
}
public void setMeseciGaranciq(String meseciGaranciq) {
	mesecigarancia =Integer.parseInt(meseciGaranciq.replaceAll("\\D+",""));
}




}
