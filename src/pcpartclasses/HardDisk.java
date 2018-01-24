package pcpartclasses;


public class HardDisk extends Component{
	//ako nqkoe ot teq lipsva(s izkliuchenie na ekstri nego moje da go nqma) trqbva da ne pravish objecta
	private String Prednaznachenie; // vinagi she ima nastolen komp
	
	private String Type; //HDD vutreshen
	private String FormFactor; //3.5" or 2.5"
	private int Kapacitet; // ## Terabytes/GygaBytes she go merish v gb ti vrushta int na gigs
	private String SkorostNaVurtene; // ## rpm vrushta int v rpm
	private int ObemNaKeshPamet;//## mb vrushta int na mb tite
	private String Interfaces; //SATA 3 (6Gb/s) only available
	private String ekstri = null; // moje da go ima i                       moje da go nqma
	private Triple<Double, Double, Double> Razmeri = null; // golemina first x second x third mm              moje da nqmat
	private int teglo = -1; // v grama                                         moje da nqmat
	private int MeseciGaranciq; // meseci garanciq prosto ue tapag
	private String SkorostNaChetene;
	private String SkorostNaZapis;

	public HardDisk() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getPrednaznachenie() {
		return Prednaznachenie;
	}
	public void setPrednaznachenie(String prednaznachenie) {
		Prednaznachenie = prednaznachenie;
	} 
	// prednaznachenie ima zaduljitelno nastolen komp, moje da ima i drug shit ama za sq go ostavi taka ne ti trqq
	
	public String getType() {
		return Type;
	}
		
	public void setType(String type) {
		Type = type;
	}
	// tipa si go napravil da e samo HDD vutreshen
	
	
	public String getFormFactor() {
		return FormFactor;
	}
	public void setFormFactor(String formFactor) {
		FormFactor = formFactor;
	}
	// trqbva da moje da e samo 2.5" ili 3.5" za sq go ostavi string posle moje da go tweeknesh na final edikakvosita ako ti e po-lesno
	
	
	public int getKapacitet() {
		return Kapacitet;
	}
	
	public void setKapacitet(String kapacitet) {
		int gigs = 0;
		kapacitet = kapacitet.toUpperCase();
		if (kapacitet.contains("TB")) {
			gigs = Integer.parseInt(kapacitet.replaceAll("\\D+",""))*1024;
		}
		else if (kapacitet.contains("GB")) {
			gigs = Integer.parseInt(kapacitet.replaceAll("\\D+",""));
		}
		else {
			System.out.println("Pametta ne e v gb ili tb");
		}
		Kapacitet = gigs;
		
	}
	// Vrushta ti chislo + tb , ti iskash da vzemesh samo chisloto v gb edinici
	
	
	public int getSkorostNaVurtene() {
		return Integer.parseInt(SkorostNaVurtene.replaceAll("\\D+",""));
	}
	public void setSkorostNaVurtene(String skorostNaVurtene) {
		SkorostNaVurtene = skorostNaVurtene;
		
	}
	//vrushta skorost na vurtene int v RPM
	
	
	
	
	public int getObemNaKeshPamet() {
		return ObemNaKeshPamet;
	}
	public void setObemNaKeshPamet(String obemNaKeshPamet) {
		int ObemNaKesh= Integer.parseInt(obemNaKeshPamet.replaceAll("\\D+",""));
		
		ObemNaKeshPamet = ObemNaKesh;
	}
	// vrushta obem na kesh int v mb-ti 
	
	
	
	
	
	public String getInterfaces() {
		return Interfaces;
	}
	public void setInterfaces(String interfaces) {
		Interfaces = interfaces;
	}
	//ima samo SATA 3 (6Gb/s) za tva che vrushta samo takiva stringove
	
	
	
	public String getEkstri() {
		return ekstri;
	}
	public void setEkstri(String ekstri) {
		this.ekstri = ekstri;
	}
	//moje da ima ili da nqma ekstri za sq go ostavqm string zashtoto nz kakvo moje da se pravi s nego
	
	
	
	public Triple<Double, Double, Double> getRazmeri() {
		return Razmeri;
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
			this.Razmeri = dimensions;
			
		}catch(Exception e) {
			System.out.println(e);

		}
		
	}
//	public void setRazmeri(String razmeri) {
//
//		String[] RazmeriStr = razmeri.split("x");
//		try {
//			double x = Double.parseDouble(RazmeriStr[0].trim());
//			double y = Double.parseDouble(RazmeriStr[1].trim());
//			double z = Double.parseDouble((RazmeriStr[2].replaceAll("[^.0-9]", "")).trim());
//			Triple<Double, Double, Double> dimensions = new Triple<Double, Double, Double>(x,y,z);
//			Razmeri = dimensions;
//
//		}catch(IndexOutOfBoundsException e) {
//			System.err.println("Greshen Format na razmeri x y z");		
//		}
//
//		
//	}
	// hvurlq mu string kato 147 x 101.85 x 26.11 мм zima go i gi razdelq na x y z sled tova ti vrushta triple-a 
	// nqkoi nqmat razmeri...

	public int getTeglo() {
		return teglo;
	}

	public void setTeglo(String teglo) {
		int gr = Integer.parseInt(teglo.replaceAll("\\D+",""));
		this.teglo = gr;
	}
	//idva v string kato 200 грама  ne znam dali ima i kg biva da ima exception
	//moje da nqmmat
	
	
	public int getMeseciGaranciq() {
		return MeseciGaranciq;
	}
	public void setMeseciGaranciq(String meseciGaranciq) {
		MeseciGaranciq =Integer.parseInt(meseciGaranciq.replaceAll("\\D+",""));
	}
	// prosto mesecite v koito e v garanciq 

	
	public int getSkorostNaChetene() {
		return  Integer.parseInt(SkorostNaChetene.replaceAll("\\D+",""));
	}
	public void setSkorostNaChetene(String skorostNaChetene) {		
		SkorostNaChetene = skorostNaChetene;
	}
	//vrushta skorost na chetene mb/s
	
	
	public int getSkorostNaZapis() {
		return Integer.parseInt(SkorostNaZapis.replaceAll("\\D+",""));
	}
	public void setSkorostNaZapis(String skorostNaZapis) {
		
		SkorostNaZapis = skorostNaZapis;
	}
	// vrushta skorost na zapis mb/s 
}
