package pcpartclasses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.LongStream;

import javax.xml.crypto.dsig.spec.HMACParameterSpec;

public class MotherBoard extends Component implements Hmapping{
	private String soket;
	private String model;
	private String chipset;
	private String podyrjaniProces;
	private String podyrjanaPamet;
	private int ChestotaNaPamet; // in MHz
	private int BroiSlotoveZaPamet;
	private String ZvukovaKarta;
	private String LAN;
	private HashMap<String, Integer> Intefaces;
	private HashMap<String, Integer> Ports;
	private String FormFactor;
	private Triple<Double,Double,Boolean> razmer = null;
	private String paketirovka;
	private int mesecigaranciq;

	public MotherBoard() {}

	public String getSoket() {
		return soket;
	}
	public void setSoket(String soket) {
		this.soket = soket;
	}
	public String getChipset() {
		return chipset;
	}
	public void setChipset(String chipset) {
		this.chipset = chipset;
	}
	public String getPodyrjaniProces() {
		return podyrjaniProces;
	}
	public void setPodyrjaniProces(String podyrjaniProces) {
		this.podyrjaniProces = podyrjaniProces;
	}
	public String getPodyrjanaPamet() {
		return podyrjanaPamet;
	}
	public void setPodyrjanaPamet(String podyrjanaPamet) {
		this.podyrjanaPamet = podyrjanaPamet;
	}


	public int getChestotaNaPamet() {
		return ChestotaNaPamet;
	}
	public void setChestotaNaPamet(String chestotaNaPamet) {
		int chestota = Integer.parseInt(chestotaNaPamet.replaceAll("\\D+",""));
		ChestotaNaPamet = chestota;
	}


	public int getBroiSlotoveZaPamet() {
		return BroiSlotoveZaPamet;
	}
	public void setBroiSlotoveZaPamet(String broiSlotoveZaPamet) {
		BroiSlotoveZaPamet = Integer.parseInt(broiSlotoveZaPamet);
	}
	public String getZvukovaKarta() {
		return ZvukovaKarta;
	}
	public void setZvukovaKarta(String zvukovaKarta) {
		ZvukovaKarta = zvukovaKarta;
	}
	public String getLAN() {
		return LAN;
	}
	public void setLAN(String lAN) {
		LAN = lAN;
	}
	public HashMap<String, Integer> getIntefaces() {
		return Intefaces;
	}
	public void setIntefaces(String intefaces) {
		Intefaces = Hmapping.getHmam(intefaces);
		
	}
	public HashMap<String, Integer> getPorts() {
		return Ports;
	}
	public void setPorts(String ports) {
		
		Ports = Hmapping.getHmam(ports);
	}
	public String getFormFactor() {
		return FormFactor;
	}
	public void setFormFactor(String formFactor) {
		FormFactor = formFactor;
	}
	public Triple<Double, Double, Boolean> getRazmeri() {
		return razmer;
	}
	public void setRazmer(String razmeri) {
		double x = 0;
		double y = 0;
		Boolean z = false;

		String[] CeliqPoSpaces = razmeri.split(" ");
		String[] RazmeriStr  = new String[2];
		try {

			for (int i = 0, a =0; i < CeliqPoSpaces.length; i++) {
				if(CeliqPoSpaces[i].matches(".*\\d+.*")) {
					RazmeriStr[a] = CeliqPoSpaces[i];
					a++;
				}
			}
			x = Double.parseDouble(RazmeriStr[0].trim());
			y = Double.parseDouble(RazmeriStr[1].trim());
			if(x!=0&&y!=0) {
				z = true;
			}
			Triple<Double, Double, Boolean> dimensions = new Triple<Double, Double, Boolean>(x,y,z);
			this.razmer = dimensions;

		}catch(Exception e) {
			System.out.println(e);

		}

	}

	public String getPaketirovka() {
		return paketirovka;
	}
	public void setPaketirovka(String paketirovka) {
		this.paketirovka = paketirovka;
	}
	public int getMeseciGaranciq() {
		return mesecigaranciq;
	}
	public void setMeseciGaranciq(String mesecigaranciq) {
		this.mesecigaranciq = Integer.parseInt(mesecigaranciq.replaceAll("\\D+",""));

	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

}

