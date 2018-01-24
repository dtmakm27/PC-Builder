package pcpartclasses;


public class CPUCOOLER extends Component {
private String tipOhladitel;
private String suvmestimiSoketi;
private String konektor;
private int naprejenie; // V
private String nominalenTok; // a opravi go v double
private double moshtnost; // w 
private int OborotiNaVentilatora; // rpm
private double VuzdushenPotok; // CFM
private double nivoNaShum; //dBA
private double Ventilatori;
private String razmeri;   // napravi go v triple
private String produljitelnostNaJivot;
private String drugi;
private String teglo;
private int MeseciGaranciq; // months

public CPUCOOLER() {}

public String getTipOhladitel() {
	return tipOhladitel;
}
public void setTipOhladitel(String tipOhladitel) {
	this.tipOhladitel = tipOhladitel;
}
public String getSuvmestimiSoketi() {
	return suvmestimiSoketi;
}
public void setSuvmestimiSoketi(String suvmestimiSoketi) {
	this.suvmestimiSoketi = suvmestimiSoketi;
}
public String getKonektor() {
	return konektor;
}
public void setKonektor(String konektor) {
	this.konektor = konektor;
}
public int getNaprejenie() {
	return naprejenie;
}
public void setNaprejenie(String naprejenie) {
	this.naprejenie = Integer.parseInt(naprejenie.replaceAll("\\D+",""));
}
public String getNominalenTok() {
	return nominalenTok;
}
public void setNominalenTok(String nominalenTok) {
	this.nominalenTok =  nominalenTok;
}
public double getMoshtnost() {
	return moshtnost;
}
public void setMoshtnost(String moshtnost) {
	this.moshtnost = Double.parseDouble(moshtnost.replaceAll("[^\\d.]", ""));
}
public int getOborotiNaVentilatora() {
	return OborotiNaVentilatora;
}
public void setOborotiNaVentilatora(String oborotiNaVentilatora) {
	OborotiNaVentilatora = Integer.parseInt(oborotiNaVentilatora.replaceAll("\\D+",""));
}
public double getVuzdushenPotok() {
	return VuzdushenPotok;
}
public void setVuzdushenPotok(String vuzdushenPotok) {
	VuzdushenPotok =  Double.parseDouble(vuzdushenPotok.replaceAll("[^\\d.]", ""));
}
public double getNivoNaShum() {
	return nivoNaShum;
}
public void setNivoNaShum(String nivoNaShum) {
	this.nivoNaShum = Double.parseDouble(nivoNaShum.replaceAll("[^\\d.]", ""));
}
public double getVentilatori() {
	return Ventilatori;
}
public void setVentilatori(String ventilatori) {
	Ventilatori =Double.parseDouble(ventilatori.replaceAll("[^\\d.]", "")) ;
}
public String getRazmeri() {
	return razmeri;
}
public void setRazmeri(String razmeri) {
	this.razmeri = razmeri;
}
public String getProduljitelnostNaJivot() {
	return produljitelnostNaJivot;
}
public void setProduljitelnostNaJivot(String produljitelnostNaJivot) {
	this.produljitelnostNaJivot = produljitelnostNaJivot;
}
public String getDrugi() {
	return drugi;
}
public void setDrugi(String drugi) {
	this.drugi = drugi;
}
public String getTeglo() {
	return teglo;
}
public void setTeglo(String teglo) {
	this.teglo = teglo;
}
public int getMeseciGaranciq() {
	return MeseciGaranciq;
}
public void setMeseciGaranciq(String meseciGaranciq) {
	MeseciGaranciq = Integer.parseInt(meseciGaranciq.replaceAll("\\D+",""));
}


}
