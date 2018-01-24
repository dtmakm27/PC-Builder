package pcpartclasses;

import java.util.HashMap;

public class GPU extends Component {
	
private String grafichenProcesor;
private String proizvoditelNaChipa;
private String ObemNaPametta ; //gb
private String TipNaPametta;
private int chestotaNaPametta; // mhz
private int shirochinaNaShinata; //bit
private String slot;
private HashMap<String, Integer> intefaces;
private String DirectX;
private int chestotaNaQdroto; // mhz
private int potochniProcesori;
private String ohlajdane;
private int maksimalnaKonsumaciq; // w
private String Ekstri;
private int meseciGaranciq; //months
public GPU(){}

public String getGrafichenProcesor() {
	return grafichenProcesor;
}
public void setGrafichenProcesor(String grafichenProcesor) {
	this.grafichenProcesor = grafichenProcesor;
}
public String getProizvoditelNaChipa() {
	return proizvoditelNaChipa;
}
public void setProizvoditelNaChipa(String proizvoditelNaChipa) {
	this.proizvoditelNaChipa = proizvoditelNaChipa;
}
public int getObemNaPametta() {
	return Integer.parseInt(ObemNaPametta.replaceAll("\\D+","").trim());
}
public void setObemNaPametta(String obemNaPametta) {
	
	ObemNaPametta = obemNaPametta;
}
public String getTipNaPametta() {
	return TipNaPametta;
}
public void setTipNaPametta(String tipNaPametta) {
	TipNaPametta = tipNaPametta;
}
public int getChestotaNaPametta() {
	return chestotaNaPametta;
}
public void setChestotaNaPametta(String chestotaNaPametta) {
	this.chestotaNaPametta =Integer.parseInt(chestotaNaPametta.replaceAll("\\D+","").trim());
}
public int getShirochinaNaShinata() {
	return shirochinaNaShinata;
}
public void setShirochinaNaShinata(String shirochinaNaShinata) {
	this.shirochinaNaShinata = Integer.parseInt(shirochinaNaShinata.replaceAll("\\D+",""));
}
public String getSlot() {
	return slot;
}
public void setSlot(String slot) {
	this.slot = slot;
}
public HashMap<String, Integer>  getIntefaces() {
	return intefaces;
}
public void setIntefaces(String intefaces) {
	String newr = "";
	for (int i = 0; i < Checkers.InterfacesCheckers.length; i++) {
		if(intefaces.contains(Checkers.InterfacesCheckers[i])) {
			
			if(intefaces.indexOf(Checkers.InterfacesCheckers[i])-2>0) {
			if(intefaces.charAt(intefaces.indexOf(Checkers.InterfacesCheckers[i])-2)=='x')
			{
				newr +=intefaces.substring(intefaces.indexOf(Checkers.InterfacesCheckers[i])-4,intefaces.indexOf(Checkers.InterfacesCheckers[i]))+ Checkers.InterfacesCheckers[i] + " ";
			}
			else {
			
			newr+= "1 x "+Checkers.InterfacesCheckers[i]+ " ";
			}// same as the first one
		}
			else {
			newr+="1 x "+Checkers.InterfacesCheckers[i]+ " ";
			} // first one 
			intefaces = intefaces.replaceAll(Checkers.InterfacesCheckers[i], "");
			
		}
		
	}
	this.intefaces = Hmapping.getHmam(newr);
	//this.intefaces = intefaces;
}
public String getDirectX() {
	return DirectX;
}
public void setDirectX(String directX) {
	DirectX = directX;
}
public int getChestotaNaQdroto() {
	return chestotaNaQdroto;
}
public void setChestotaNaQdroto(String chestotaNaQdroto) {
	this.chestotaNaQdroto = Integer.parseInt(chestotaNaQdroto.replaceAll("\\D+",""));
}
public int getPotochniProcesori() {
	return potochniProcesori;
}
public void setPotochniProcesori(String potochniProcesori) {
	this.potochniProcesori = Integer.parseInt(potochniProcesori.replaceAll("\\D+",""));
}
public String getOhlajdane() {
	return ohlajdane;
}
public void setOhlajdane(String ohlajdane) {
	this.ohlajdane = ohlajdane;
}
public int getMaksimalnaKonsumaciq() {
	return maksimalnaKonsumaciq;
}
public void setMaksimalnaKonsumaciq(String maksimalnaKonsumaciq) {
	this.maksimalnaKonsumaciq = Integer.parseInt(maksimalnaKonsumaciq.replaceAll("\\D+",""));
}
public String getEkstri() {
	return Ekstri;
}
public void setEkstri(String ekstri) {
	Ekstri = ekstri;
}
public int getMeseciGaranciq() {
	return meseciGaranciq;
}
public void setMeseciGaranciq(String meseciGaranciq) {
	this.meseciGaranciq = Integer.parseInt(meseciGaranciq.replaceAll("\\D+",""));
}




}
