package pcpartclasses;

import java.util.HashMap;

public class PSU extends Component implements Hmapping {
private int moshtnost;//w
private String formFactor;
private HashMap<String, Integer> konektori;
private String ohlajdane;
private double efektivnost;
private String PFC;
private Triple<Double, Double, Double> razmeri;
private String teglo;
private int meseciGaranciq;

public int getMoshtnost() {
	return moshtnost;
}
public void setMoshtnost(String moshtnost) {
	this.moshtnost = Integer.parseInt(moshtnost.replaceAll("[^\\d.]", ""));
}
public String getFormFactor() {
	return formFactor;
}
public void setFormFactor(String formFactor) {
	this.formFactor = formFactor;
}
public HashMap<String, Integer>  getKonektori() {
	return konektori;
}
public void setKonektori(String konektori) {
	this.konektori =Hmapping.getHmam(konektori);
}
public String getOhlajdane() {
	return ohlajdane;
}
public void setOhlajdane(String ohlajdane) {
	this.ohlajdane = ohlajdane;
}
public double getEfektivnost() {
	return efektivnost;
}
public void setEfektivnost(String efektivnost) {
	this.efektivnost = Double.parseDouble(efektivnost.replaceAll("[^\\d.]", ""));
}
public String getPFC() {
	return PFC;
}
public void setPFC(String pFC) {
	PFC = pFC;
}
public Triple<Double, Double, Double> getRazmeri() {
	return razmeri;
}
public void setRazmeri(String razmeri) {
	double x = 0, y = 0,z = 0;
	String[] CeliqPoSpaces = razmeri.split(" ");
	String[] RazmeriStr  = new String[3];
	try {		
	for (int i = 0, a =0; i < CeliqPoSpaces.length; i++) {
		if(CeliqPoSpaces[i].matches(".*\\d+.*")) {
			RazmeriStr[a] = CeliqPoSpaces[i];
			a++;
		}
	}
		x = Double.parseDouble(RazmeriStr[0].trim());
		y = Double.parseDouble(RazmeriStr[1].trim());
		z = Double.parseDouble(RazmeriStr[2].trim());
		Triple<Double, Double, Double> dimensions = new Triple<Double, Double, Double>(x,y,z);
		this.razmeri = dimensions;
		
	}catch(Exception e) {
		System.out.println(e);

	}
}
public String getTeglo() {
	return teglo;
}
public void setTeglo(String teglo) {
	this.teglo = teglo;
}
public int getMeseciGaranciq() {
	return meseciGaranciq;
}
public void setMeseciGaranciq(String meseciGaranciq) {
	this.meseciGaranciq = Integer.parseInt(meseciGaranciq.replaceAll("[^\\d.]", ""));
}
}
