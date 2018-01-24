package pcpartclasses;


public class CPU extends Component {
private String model;
private String soket;
private double rabotnaChestota; // GHz
private double turboBoost; // GHz
private int fizicheskiQdra;
private int logicheskiQdra;
private String KeshPamet;
private int mnojitel;
private int proizvodstvenProcess; // nm
private int maxKonsumaciq; //w
private String grafichnoQdro;
private String ohladitel;
private String paketirovka;
private int meseciGaranciq;
public CPU() {}
public String getModel() {
	return model;
}
public void setModel(String model) {
	this.model = model;
}
public String getSoket() {
	return soket;
}
public void setSoket(String soket) {
	this.soket = soket;
}
public double getRabotnaChestota() {
	return rabotnaChestota;
}
public void setRabotnaChestota(String rabotnaChestota) {
	this.rabotnaChestota = Double.parseDouble(rabotnaChestota.replaceAll("[^\\d.]", ""));
}
public int getFizicheskiQdra() {
	return fizicheskiQdra;
}
public void setFizicheskiQdra(String fizicheskiQdra) {
	this.fizicheskiQdra = Integer.parseInt(fizicheskiQdra);
}
public int getLogicheskiQdra() {
	return logicheskiQdra;
}
public void setLogicheskiQdra(String logicheskiQdra) {
	this.logicheskiQdra = Integer.parseInt(logicheskiQdra);
}
public String getKeshPamet() {
	return KeshPamet;
}
public void setKeshPamet(String keshPamet) {
	KeshPamet = keshPamet;
}
public int getMnojitel() {
	return mnojitel;
}
public void setMnojitel(String mnojitel) {
	this.mnojitel = Integer.parseInt(mnojitel);
}
public int getProizvodstvenProcess() {
	return proizvodstvenProcess;
}
public void setProizvodstvenProcess(String proizvodstvenProcess) {
	this.proizvodstvenProcess = Integer.parseInt(proizvodstvenProcess.replaceAll("[^\\d.]", ""));
}
public int getMaxKonsumaciq() {
	return maxKonsumaciq;
}
public void setMaxKonsumaciq(String maxKonsumaciq) {
	this.maxKonsumaciq = Integer.parseInt(maxKonsumaciq.replaceAll("[^\\d.]", ""));
}
public String getGrafichnoQdro() {
	return grafichnoQdro;
}
public void setGrafichnoQdro(String grafichnoQdro) {
	this.grafichnoQdro = grafichnoQdro;
}
public String getOhladitel() {
	return ohladitel;
}
public void setOhladitel(String ohladitel) {
	this.ohladitel = ohladitel;
}
public String getPaketirovka() {
	return paketirovka;
}
public void setPaketirovka(String paketirovka) {
	this.paketirovka = paketirovka;
}
public int getMeseciGaranciq() {
	return meseciGaranciq;
}
public void setMeseciGaranciq(String meseciGaranciq) {
	this.meseciGaranciq = Integer.parseInt(meseciGaranciq.replaceAll("[^\\d.]", ""));
}
public double getTurboBoost() {
	return turboBoost;
}
public void setTurboBoost(String turboBoost) {
	this.turboBoost = Double.parseDouble(turboBoost.replaceAll("[^\\d.]", ""));
}


}
