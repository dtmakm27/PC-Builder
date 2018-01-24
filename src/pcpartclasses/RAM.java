package pcpartclasses;


public class RAM extends Component{
private Touple<Integer, Integer> obem; //gb
private String tip;
private int chestota; // MHz
private String taimingi;
private int meseciGaranciq;
public RAM() {}
public Touple<Integer, Integer> getObem() {
	return obem;
}
public void setObem(String obem) {
	int x,y;
	if (obem.contains("x")) {
		String[] asd = obem.split("x");
		 x = Integer.parseInt(asd[0].trim());
		 y = Integer.parseInt(asd[1].replaceAll("[^\\d.]", ""));
	}
	else {
		x = 1;
		y = Integer.parseInt(obem.replaceAll("[^\\d.]", ""));
	}
	this.obem = new Touple<Integer, Integer>(x,y);
}
public String getTip() {
	return tip;
}
public void setTip(String tip) {
	this.tip = tip;
}
public int getChestota() {
	return chestota;
}
public void setChestota(String chestota) {
	this.chestota = Integer.parseInt(chestota.replaceAll("[^\\d.]", ""));
}
public String getTaimingi() {
	return taimingi;
}
public void setTaimingi(String taimingi) {
	this.taimingi = taimingi;
}
public int getMeseciGaranciq() {
	return meseciGaranciq;
}
public void setMeseciGaranciq(String meseciGaranciq) {
	this.meseciGaranciq = Integer.parseInt(meseciGaranciq.replaceAll("[^\\d.]", ""));
}


}
