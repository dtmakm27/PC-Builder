import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

import javax.print.Doc;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.select.Evaluator.Id;

import pcpartclasses.*;
public class ScrapeRun {

	public static void main(String[] args) throws IOException {
		//		
		//			Document compDodc = Jsoup.connect("https://ardes.bg/product/cooler-master-cosmos-ii-1200-cheren-45516").timeout(6000).get();// connects to a component link
		//		Elements table = compDodc.getElementsByClass("table-container ");
		//			 int a =1;
		//			
		//			 for (Element row : table.select("tr")) {
		//			 System.out.print(row.select("th").text()+ " " );
		//			
		//			 for (Element column : row.select("td")) {
		//			
		//			 if (a%2==0)
		//			 System.out.println(column.text());
		//			 a++;
		//			
		//			 }
		//			
		//			 } 
		// TODO Auto-generated method stub

		ArrayList<String> PartLinks = new ArrayList<String>();
		String HardDisk = "https://ardes.bg/komponenti/tvardi-diskove/hdd-vatreshen/prednaznachenie-za-nastolen-kompyutar";
		String Case = "https://ardes.bg/komponenti/kompyutarni-kutii";
		String MotherBoards = "https://ardes.bg/komponenti/danni-platki";
		String CPU = "https://ardes.bg/komponenti/protsesori";
		String RAM = "https://ardes.bg/komponenti/pamet";
		String GPU = "https://ardes.bg/komponenti/video-karti";	
		String CPUCOOLER = "https://ardes.bg/komponenti/ventilatori/ohladitel,voden-ohladitel";
		String PSU = "https://ardes.bg/komponenti/zahranvane";


		PartLinks.add(Case);//0
		PartLinks.add(MotherBoards);//1
		PartLinks.add(CPU);//2
		PartLinks.add(RAM);//3
		PartLinks.add(GPU);//4
		PartLinks.add(CPUCOOLER);//5
		PartLinks.add(PSU);//6
		PartLinks.add(HardDisk);//7

		//		E:\\\\\\\\componentsNO0.ser
				int ComponentNumber;
				String filePath;
				 for (int i = 0; i < PartLinks.size(); i++) {
					 ComponentNumber= i;
					 filePath = "E:\\\\componentsNO"+ComponentNumber +".ser";
					 ArrayList<Component> Components = GetSpecs(PartLinks.get(i));
					 serializeComponent(Components, filePath);
					 
				 }   //write ArrayList to file  
				 
		//		serializeComponent((GetSpecs(GPU)), "E:\\\\\\\\componentsNO4.ser");
		//https://www.google.bg/search?q=

 
		 for (int i = 0; i < PartLinks.size(); i++) {
			 ComponentNumber= i;
			 filePath = "E:\\\\componentsNO"+ComponentNumber +".ser";
			 ArrayList<Component> mobs = deserializeComponent(filePath);
			 for (Component component : mobs) {
				System.out.println(component.getName());
			}
//			 ArrayList<Component> Components = GetSpecs(PartLinks.get(i));
//			 serializeComponent(Components, filePath);
		}
		
//		for (int i = 190; i < mobs.size(); i++) {
//			Component component = mobs.get(i);
//			//System.out.println(i);
//
//			//System.out.println(component.getCompLink());
//			String[] ar = component.getName().split(",");
//			String caselink = ar[0].replaceAll("Кутия ", "").replaceAll(" ", "+");
//			Document doc = null;
//			String con = null;
//			try{
//				//System.out.println(caselink);
//				
//				 con = "https://www.google.bg/search?q=" + caselink +"+site:pcgarage.ro";
//				doc =    Jsoup.connect(con).timeout(10000).get();
//				Elements links = doc.select("div.g");
//				String linki = null;
//				for (Element link : links) {
//					if (link.select("h3.r").select("a[href]").attr("href").contains("pcgarage")) {
//						linki = link.select("h3.r").select("a[href]").attr("href");
//						break;
//					}
//				}
//				if (linki!=null) {
//				//System.out.println(linki);
//				doc = Jsoup.connect(linki).timeout(10000).get();
//				links = doc.select("table.specs-table");
//				//System.out.println(links);
//
//				for (Element row : links.select("tr")) {
//					//System.out.println(row.select("th").text());
//					for (int i1 = 0; i1 < row.select("td").size(); i1++) {
//						Element column = row.select("td").get(i1);
//						if(column.text().contains("Lungime video GPU")) {			
//							//System.out.println(column.text());
//							System.out.println( row.select("td").get(i1+1).text());
//							
//						}
//						//System.out.println(column.text());
//					}
//				}
//				
//				}
//				else {System.out.println("No links found");}
//			}
//			catch (IOException e) {
//				System.out.println(e);
//				e.printStackTrace();
//				System.out.println("bad link");
//				System.out.println(con);
//			}
//		} // get info from another site to fill info gaps

		
//		String con = "https://www.google.bg/search?q=search";
//Document		doc =    Jsoup.connect(con).get();


		//		GPU newmob = new GPU();
		//		newmob.setIntefaces("HDMI DisplayPort DVI");
		//		System.out.println(newmob.getIntefaces().toString());

		//	Set set = hmap.entrySet();
		//    Iterator iterator = set.iterator();
		//    while(iterator.hasNext()) {
		//       Map.Entry mentry = (Map.Entry)iterator.next();
		//       System.out.print("key is: "+ mentry.getKey() + " & Value is: ");
		//       System.out.println(mentry.getValue());
		//    } 		view ports and interfaces









		//ArrayList<Component> mobos = deserializeComponent("E:\\\\\\\\componentsNO1.ser");
		//ArrayList<Component> cases = deserializeComponent("E:\\\\\\\\componentsNO0.ser");
		//		for (Component component : cases) {
		//			//System.out.println(((Case)component).getPortove());
		//			((Case)component).getPortove().split("x");
		//
		//		}
		//		String form;
		//		Component mos = mobos.get(0);
		//			form =( (MotherBoard)mos).getFormFactor();
		//		for (Component component : cases) {
		//			if(((Case)component).getFormFactor()!=null) {
		//			for (String str : ((Case)component).getFormFactor()) {
		//				if(form.equals(str)) {
		//					System.out.println(mos.getName() + "  " + component.getName() + "  " + "with the form of:  " + form);
		//				}
		//			
		//			}   
		//		}
		//		} 			//matches case form factor with mobo form factor


		//		for (Component component : newlist) {
		//			ArrayList<String> asd = ((Case)component).getFormFactor();
		//			for (String string : asd) {
		//				System.out.println(string);
		//			}
//
	}

	@SuppressWarnings("finally")
	public static ArrayList<Component> GetSpecs(String LinkToComponentType) {

		ArrayList<Component> Parts = new ArrayList<Component>();
		try {
			Document compDoc;
			@SuppressWarnings("unused")
			Document pagesCycleDoc;
			Document doc = Jsoup.connect(LinkToComponentType).get();
			Elements el;
			// get the doc page from which to start searching for pages and components
			Elements elements = doc.getElementsByClass("number no-margin");
			// get the last page from n.no-marg
			// System.out.println(elements.text()); last page num
			int LastPage = Integer.parseInt(elements.text()); // last page

			for (int i = 1; i <= LastPage; i++) {
				pagesCycleDoc = Jsoup.connect(LinkToComponentType + "/page/" + i).get(); // connects to each page from 1
				// to last and gets each
				// component link
				System.out.println(LinkToComponentType + "/page/" + i);
				el = pagesCycleDoc.getElementsByClass("title clearfix"); // gets each component from page
				//				System.out.println(el.size());
				for (Element element : el) {				
					String Elementlink = element.select("a").attr("abs:href");
					compDoc = Jsoup.connect(Elementlink).timeout(6000).get();// connects to a component link
					Elements table = compDoc.getElementsByClass("table-container "); // gets content from info table
					String TipChast = compDoc.select("div#help_nav").select("li").select("a").select("span").get(1).text();
					//					System.out.println(TipChast);				
					System.out.println(Elementlink);
					//					 int a =1;
					//			 for (Element row : table.select("tr")) {
					//					 System.out.print(row.select("th").text()+ " " );
					//					
					//					 for (Element column : row.select("td")) {
					//					
					//					 if (a%2==0)
					//					 System.out.println(column.text());
					//					 a++;
					//					
					//					 }
					//					
					//					 }			
					//				

					if (TipChast.equals("Твърди дискове")) {
						HardDisk NewHardDrive =Storage(table, compDoc, Elementlink);
						if(NewHardDrive.getKapacitet() != 0 || NewHardDrive.getInterfaces()  != null) {	

							Parts.add(NewHardDrive);
						}

					}
					if (TipChast.equals("Компютърни кутии")) {			

						Case NewCase = Case(table, compDoc, Elementlink);
						if (NewCase.getFormFactor()!=null) {
							Parts.add(NewCase);	
						}

					}
					if(TipChast.equals("Дънни платки")) {
						MotherBoard mobo = Mobos(table, compDoc, Elementlink);
						Parts.add(mobo);	
					}
					if (TipChast.equals("Процесори")) {
						CPU NewCPU = CPU(table, compDoc, Elementlink);
						Parts.add(NewCPU);	
					}
					if (TipChast.equals("Памет")) {
						RAM NewRAM = RAM(table, compDoc, Elementlink);
						if(NewRAM.getObem().getY()!=512) {
							Parts.add(NewRAM);
						}
					}
					if (TipChast.equals("Видео карти")) {
						GPU NewGpu = GPU(table, compDoc, Elementlink);
						Parts.add(NewGpu);
					}
					if (TipChast.equals("Вентилатори")) {
						CPUCOOLER NewGpu = CPUCOOLER(table, compDoc, Elementlink);
						Parts.add(NewGpu);
					}
					if (TipChast.equals("Захранване")) {
						PSU NewPsu = PSU(table, compDoc, Elementlink);
						Parts.add(NewPsu);
					}



				}


			}
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		finally {
			return Parts;
		}

	}///////////////////// full code getspecs

	public static PSU PSU(Elements table,Document compDoc, String Elementlink) {


		PSU Component = new PSU();
		//System.out.println(Elementlink);
		Component.setCompLink(Elementlink);


		//System.out.println("name: "+ compDoc.getElementsByClass("truncated").text()); // get the name
		Component.setName(compDoc.getElementsByClass("truncated").text());

		//System.out.println("ID: "+ table.select("table").attr("id"));// get the id of object
		Component.setID(table.select("table").attr("id"));


		//System.out.println("price: "+ compDoc.getElementsByClass("display-prices container-fluid").select("span").first().text()); //get the price
		Component.setPrice(compDoc.getElementsByClass("display-prices container-fluid").select("span").first().text());

		//System.out.println(compDoc.select("div#help_nav").select("li").select("a").select("span").get(1).text());
		Component.setChast(compDoc.select("div#help_nav").select("li").select("a").select("span").get(1).text());


		int a = 1; // gets rid of whitespaces
		// Cycles thru info and spits it out
		for (Element row : table.select("tr")) {
			// System.out.println(row.text()); // full row
			switch (row.select("th").text()) {

			case "Мощност:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces

						Component.setMoshtnost(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "Форм фактор:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces

						Component.setFormFactor(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
			case "Конектори:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces

						Component.setKonektori(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "Охлаждане:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces
						Component.setOhlajdane(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "Ефективност:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces
						Component.setEfektivnost(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "PFC:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces
						Component.setPFC(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "Размери:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces
						Component.setRazmeri(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "Тегло:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces
						Component.setTeglo(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "Гаранционен срок:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces
						Component.setMeseciGaranciq(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;

			default:
				break;
			}
		}
		return Component;

	}
	public static CPUCOOLER CPUCOOLER(Elements table,Document compDoc, String Elementlink) {


		CPUCOOLER Component = new CPUCOOLER();
		//System.out.println(Elementlink);
		Component.setCompLink(Elementlink);


		//System.out.println("name: "+ compDoc.getElementsByClass("truncated").text()); // get the name
		Component.setName(compDoc.getElementsByClass("truncated").text());

		//System.out.println("ID: "+ table.select("table").attr("id"));// get the id of object
		Component.setID(table.select("table").attr("id"));


		//System.out.println("price: "+ compDoc.getElementsByClass("display-prices container-fluid").select("span").first().text()); //get the price
		Component.setPrice(compDoc.getElementsByClass("display-prices container-fluid").select("span").first().text());

		//System.out.println(compDoc.select("div#help_nav").select("li").select("a").select("span").get(1).text());
		Component.setChast(compDoc.select("div#help_nav").select("li").select("a").select("span").get(1).text());


		int a = 1; // gets rid of whitespaces
		// Cycles thru info and spits it out
		for (Element row : table.select("tr")) {
			// System.out.println(row.text()); // full row
			switch (row.select("th").text()) {
			case "Тип:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces

						Component.setTipOhladitel(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "Съвместими сокети:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces

						Component.setSuvmestimiSoketi(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
			case "Конектор:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces

						Component.setKonektor(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "Напрежение:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces
						Component.setNaprejenie(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "Номинален ток:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces
						Component.setNominalenTok(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "Мощност:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) 
						// gets rid of whitespaces
						Component.setMoshtnost(column.text());
					//System.out.println(NewHardDrive.getKapacitet());


					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "Обороти на вентилатора:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces
						Component.setOborotiNaVentilatora(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "Въздушен поток:": 
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces
						Component.setVuzdushenPotok((column.text()));
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "Ниво на шум:": 
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces
						Component.setNivoNaShum(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "Вентилатори:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces
						Component.setVentilatori(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "Размери:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces
						Component.setRazmeri(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "Тегло:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces
						Component.setTeglo(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;

			case "Гаранционен срок:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces
						Component.setMeseciGaranciq(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "Продължителност на живот:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces
						Component.setProduljitelnostNaJivot(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "Други:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces
						Component.setDrugi(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;

			default:
				break;
			}
		}
		return Component;

	}
	public static GPU GPU(Elements table,Document compDoc, String Elementlink) {


		GPU Component = new GPU();
		//System.out.println(Elementlink);
		Component.setCompLink(Elementlink);


		//System.out.println("name: "+ compDoc.getElementsByClass("truncated").text()); // get the name
		Component.setName(compDoc.getElementsByClass("truncated").text());

		//System.out.println("ID: "+ table.select("table").attr("id"));// get the id of object
		Component.setID(table.select("table").attr("id"));


		//System.out.println("price: "+ compDoc.getElementsByClass("display-prices container-fluid").select("span").first().text()); //get the price
		Component.setPrice(compDoc.getElementsByClass("display-prices container-fluid").select("span").first().text());

		//System.out.println(compDoc.select("div#help_nav").select("li").select("a").select("span").get(1).text());
		Component.setChast(compDoc.select("div#help_nav").select("li").select("a").select("span").get(1).text());


		int a = 1; // gets rid of whitespaces
		// Cycles thru info and spits it out
		for (Element row : table.select("tr")) {
			// System.out.println(row.text()); // full row
			switch (row.select("th").text()) {
			case "Графичен процесор:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces

						Component.setGrafichenProcesor(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "Производител на чипа:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces

						Component.setProizvoditelNaChipa(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
			case "Обем на паметта:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces

						Component.setObemNaPametta(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "Тип на паметта:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces
						Component.setTipNaPametta(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "Честота на паметта:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces
						Component.setChestotaNaPametta(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "Широчина на шината:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) 
						// gets rid of whitespaces
						Component.setShirochinaNaShinata(column.text());
					//System.out.println(NewHardDrive.getKapacitet());


					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "Слот:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces
						Component.setSlot(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "Интерфейси:": 
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces
						Component.setIntefaces((column.text()));
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "DirectX поддръжка:": 
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces
						Component.setDirectX(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "Честота на ядрото:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces
						Component.setChestotaNaQdroto(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "Поточни процесори:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces
						Component.setPotochniProcesori(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "Охлаждане:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces
						Component.setOhlajdane(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;

			case "Максимална консумация (TDP):":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces
						Component.setMaksimalnaKonsumaciq(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "Екстри:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces
						Component.setEkstri(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "Гаранционен срок:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces
						Component.setMeseciGaranciq(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;

			default:
				break;
			}
		}
		return Component;

	}
	public static RAM RAM(Elements table,Document compDoc, String Elementlink) {


		RAM Component = new RAM();
		//System.out.println(Elementlink);
		Component.setCompLink(Elementlink);


		//System.out.println("name: "+ compDoc.getElementsByClass("truncated").text()); // get the name
		Component.setName(compDoc.getElementsByClass("truncated").text());

		//System.out.println("ID: "+ table.select("table").attr("id"));// get the id of object
		Component.setID(table.select("table").attr("id"));


		//System.out.println("price: "+ compDoc.getElementsByClass("display-prices container-fluid").select("span").first().text()); //get the price
		Component.setPrice(compDoc.getElementsByClass("display-prices container-fluid").select("span").first().text());

		//System.out.println(compDoc.select("div#help_nav").select("li").select("a").select("span").get(1).text());
		Component.setChast(compDoc.select("div#help_nav").select("li").select("a").select("span").get(1).text());


		int a = 1; // gets rid of whitespaces
		// Cycles thru info and spits it out
		for (Element row : table.select("tr")) {
			// System.out.println(row.text()); // full row
			switch (row.select("th").text()) {
			case "Обем:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces

						Component.setObem(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "Тип:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces

						Component.setTip(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
			case "Честота:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces

						Component.setChestota(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "Тайминги:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces
						Component.setTaimingi(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "Гаранционен срок:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces
						Component.setMeseciGaranciq(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;

			default:
				break;
			}
		}
		return Component;

	}
	public static CPU CPU(Elements table,Document compDoc, String Elementlink) {


		CPU Component = new CPU();
		//System.out.println(Elementlink);
		Component.setCompLink(Elementlink);


		//System.out.println("name: "+ compDoc.getElementsByClass("truncated").text()); // get the name
		Component.setName(compDoc.getElementsByClass("truncated").text());

		//System.out.println("ID: "+ table.select("table").attr("id"));// get the id of object
		Component.setID(table.select("table").attr("id"));


		//System.out.println("price: "+ compDoc.getElementsByClass("display-prices container-fluid").select("span").first().text()); //get the price
		Component.setPrice(compDoc.getElementsByClass("display-prices container-fluid").select("span").first().text());

		//System.out.println(compDoc.select("div#help_nav").select("li").select("a").select("span").get(1).text());
		Component.setChast(compDoc.select("div#help_nav").select("li").select("a").select("span").get(1).text());


		int a = 1; // gets rid of whitespaces
		// Cycles thru info and spits it out
		for (Element row : table.select("tr")) {
			// System.out.println(row.text()); // full row
			switch (row.select("th").text()) {
			case "Модел:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces

						Component.setModel(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "Сокет:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces

						Component.setSoket(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
			case "Работна честота:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces

						Component.setRabotnaChestota(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "Turbo Boost до:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces
						Component.setTurboBoost(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "Физически ядра:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces
						Component.setFizicheskiQdra(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "Логически ядра:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) 
						// gets rid of whitespaces
						Component.setLogicheskiQdra(column.text());
					//System.out.println(NewHardDrive.getKapacitet());


					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "Кеш памет:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces
						Component.setKeshPamet(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "Множител:": 
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces
						Component.setMnojitel((column.text()));
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "Производствен процес:": 
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces
						Component.setProizvodstvenProcess(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "Максимална консумация (TDP):":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces
						Component.setMaxKonsumaciq(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "Графично ядро:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces
						Component.setGrafichnoQdro(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "Охладител:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces
						Component.setOhladitel(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;

			case "Окомплектовка:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces
						Component.setPaketirovka(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "Гаранционен срок:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces
						Component.setMeseciGaranciq(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;

			default:
				break;
			}
		}
		return Component;

	}
	public static MotherBoard Mobos(Elements table,Document compDoc, String Elementlink) {


		MotherBoard Component = new MotherBoard();
		//System.out.println(Elementlink);
		Component.setCompLink(Elementlink);


		//System.out.println("name: "+ compDoc.getElementsByClass("truncated").text()); // get the name
		Component.setName(compDoc.getElementsByClass("truncated").text());

		//System.out.println("ID: "+ table.select("table").attr("id"));// get the id of object
		Component.setID(table.select("table").attr("id"));


		//System.out.println("price: "+ compDoc.getElementsByClass("display-prices container-fluid").select("span").first().text()); //get the price
		Component.setPrice(compDoc.getElementsByClass("display-prices container-fluid").select("span").first().text());

		//System.out.println(compDoc.select("div#help_nav").select("li").select("a").select("span").get(1).text());
		Component.setChast(compDoc.select("div#help_nav").select("li").select("a").select("span").get(1).text());


		int a = 1; // gets rid of whitespaces
		// Cycles thru info and spits it out
		for (Element row : table.select("tr")) {
			// System.out.println(row.text()); // full row
			switch (row.select("th").text()) {
			case "Сокет:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces

						Component.setSoket(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
			case "Чипсет:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces

						Component.setChipset(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "Поддържани процесори:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces
						Component.setPodyrjaniProces(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "Поддържана памет:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces
						Component.setPodyrjanaPamet(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "Честота на паметта:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) 
						// gets rid of whitespaces
						Component.setChestotaNaPamet(column.text());
					//System.out.println(NewHardDrive.getKapacitet());


					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "Брой слотове за памет:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces
						Component.setBroiSlotoveZaPamet(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "Звукова карта:": 
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces
						Component.setZvukovaKarta((column.text()));
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "LAN:": 
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces
						Component.setLAN(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "Интерфейси:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces
						Component.setIntefaces(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "Портове:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces
						Component.setPorts(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "Форм фактор:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces
						Component.setFormFactor(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "Размери:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces
						Component.setRazmer(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "Окомплектовка:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces
						Component.setPaketirovka(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "Гаранционен срок:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces
						Component.setMeseciGaranciq(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;

			default:
				break;
			}
		}
		return Component;

	}
	public static HardDisk Storage(Elements table,Document compDoc, String Elementlink) {


		HardDisk NewHardDrive = new HardDisk();
		//System.out.println(Elementlink);
		NewHardDrive.setCompLink(Elementlink);


		//System.out.println("name: "+ compDoc.getElementsByClass("truncated").text()); // get the name
		NewHardDrive.setName(compDoc.getElementsByClass("truncated").text());

		//System.out.println("ID: "+ table.select("table").attr("id"));// get the id of object
		NewHardDrive.setID(table.select("table").attr("id"));


		//System.out.println("price: "+ compDoc.getElementsByClass("display-prices container-fluid").select("span").first().text()); //get the price
		NewHardDrive.setPrice(compDoc.getElementsByClass("display-prices container-fluid").select("span").first().text());

		//System.out.println(compDoc.select("div#help_nav").select("li").select("a").select("span").get(1).text());
		NewHardDrive.setChast(compDoc.select("div#help_nav").select("li").select("a").select("span").get(1).text());


		int a = 1; // gets rid of whitespaces
		// Cycles thru info and spits it out
		for (Element row : table.select("tr")) {
			// System.out.println(row.text()); // full row
			switch (row.select("th").text()) {
			case "Предназначение:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces

						NewHardDrive.setPrednaznachenie(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "Тип:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces
						NewHardDrive.setType(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "Форм-фактор:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces
						NewHardDrive.setFormFactor(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "Капацитет:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) 
						// gets rid of whitespaces
						NewHardDrive.setKapacitet(column.text());
					//System.out.println(NewHardDrive.getKapacitet());


					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "Скорост на въртене:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces
						NewHardDrive.setSkorostNaVurtene(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "Скорост на четене:": ///////////////////// !!!!!!!!!!!!!!!!check this out
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces
						NewHardDrive.setSkorostNaChetene((column.text()));
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "Скорост на запис:": //////////////////////////////////// check this out
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces
						NewHardDrive.setSkorostNaZapis(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "Обем на кеш памет:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces
						NewHardDrive.setObemNaKeshPamet(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "Интерфейси:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces
						NewHardDrive.setInterfaces(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "Екстри:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces
						NewHardDrive.setEkstri(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;

			case "Размери:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces
						NewHardDrive.setRazmeri(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "Тегло:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces
						NewHardDrive.setTeglo(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "Гаранционен срок:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces
						NewHardDrive.setMeseciGaranciq(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			default:
				break;
			}
		}
		return NewHardDrive;

	}
	public static Case Case(Elements table,Document compDoc, String Elementlink) {


		Case Component = new Case();
		//System.out.println(Elementlink);
		Component.setCompLink(Elementlink);


		//System.out.println("name: "+ compDoc.getElementsByClass("truncated").text()); // get the name
		Component.setName(compDoc.getElementsByClass("truncated").text());

		//System.out.println("ID: "+ table.select("table").attr("id"));// get the id of object
		Component.setID(table.select("table").attr("id"));


		//System.out.println("price: "+ compDoc.getElementsByClass("display-prices container-fluid").select("span").first().text()); //get the price
		Component.setPrice(compDoc.getElementsByClass("display-prices container-fluid").select("span").first().text());

		//System.out.println(compDoc.select("div#help_nav").select("li").select("a").select("span").get(1).text());
		Component.setChast(compDoc.select("div#help_nav").select("li").select("a").select("span").get(1).text());

		int a = 1; // gets rid of whitespaces
		// Cycles thru info and spits it out
		for (Element row : table.select("tr")) {
			// System.out.println(row.text()); // full row
			switch (row.select("th").text()) {
			case "Вид:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces

						Component.setVid(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
			case "Форм фактор:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces

						Component.setFormFactor(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "Захранване:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces
						Component.setZahranvane(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "Брой гнезда:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces
						Component.setBroiGnezda(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "Вентилатори:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) 
						// gets rid of whitespaces
						Component.setVentilatori(column.text());
					//System.out.println(NewHardDrive.getKapacitet());


					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "Радиатори:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces
						Component.setRadiatori(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "Портове:": 
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces
						Component.setPortove((column.text()));
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "Екстри:": 
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces
						Component.setEkstri(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "Размер:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces
						Component.setRazmeri(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "Цвят:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces
						Component.setCvqt(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;
			case "Гаранционен срок:":
				for (Element column : row.select("td")) {

					if (a % 2 == 0) // gets rid of whitespaces
						Component.setMeseciGaranciq(column.text());
					// System.out.println(column.text()); // specs for tip

					a++; // gets rid of whitespaces

				}
				break;

			default:
				break;
			}
		}

		return Component;

	}



	public static void serializeComponent(ArrayList<Component> components,String file) {

		ObjectOutputStream oos = null;
		FileOutputStream fout = null;
		try{

			fout = new FileOutputStream(file);
			oos = new ObjectOutputStream(fout);
			oos.writeObject(components);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if(oos  != null){
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} 
		}

	}



	@SuppressWarnings("unchecked")
	public static ArrayList<Component> deserializeComponent(String file) throws IOException{
		ObjectInputStream objectinputstream = null;
		ArrayList<Component> recordList = new  ArrayList<Component>();

		try {
			FileInputStream streamIn = new FileInputStream(file);
			objectinputstream = new ObjectInputStream(streamIn);		

			recordList = (ArrayList<Component>) objectinputstream.readObject();

		}
		catch (Exception e) {
			e.printStackTrace();
		} finally {

			if(objectinputstream != null){
				objectinputstream .close();
			} 
		}
		return recordList;

	}

} // END OF JSouPTEST


// Document doc =
// Jsoup.connect("https://ardes.bg/product/3tb-toshiba-dt01aca300-dt01aca300-55761").timeout(6000).get();
// Elements table = doc.getElementsByClass("table-container ");
// System.out.println("name: "+ doc.getElementsByClass("truncated").text()); //
// get the name
// System.out.println("ID: "+table.select("table").attr("id"));// get the id of
// object
// System.out.println("price: "+ doc.getElementsByClass("display-prices
// container-fluid").select("span").first().text()); //get the price
// int a =1;
//
// for (Element row : table.select("tr")) {
// System.out.print(row.select("th").text()+ " " );
//
// for (Element column : row.select("td")) {
//
// if (a%2==0)
// System.out.println(column.text());
// a++;
//
// }
//
// } // code for getting info from selected item on it's page

// for (String string : list) {
// if (string.contains("page/2")) {
// doc = Jsoup.connect(string).get();
// elements = doc.select("a");
// for(Element element : elements){
// if (element.absUrl("href").contains("page/"))
// System.out.println(element.absUrl("href"));
// // list.add((element.absUrl("href"))); //<-------HERE*****
//
//
// }
// }
// }
//
// try {
// Document doc =
// Jsoup.connect("https://ardes.bg/komponenti/tvardi-diskove").get();
// Elements el = doc.getElementsByClass("title clearfix");
//
// for (Element element : el) {
// System.out.println(element.select("a").attr("abs:href"));
// }
// } catch (IOException e) {
// e.printStackTrace();
// }get links to components

// Document doc =
// Jsoup.connect("https://ardes.bg/product/500w-deepcool-dn500-gp-bz-dn500-96147").timeout(6000).get();
// Elements table = doc.getElementsByClass("table-container ");
// System.out.println("name: "+ doc.getElementsByClass("truncated").text()); //
// get the name
// System.out.println("ID: "+table.select("table").attr("id"));// get the id of
// object
//
// System.out.println("price: "+ doc.getElementsByClass("display-prices
// container-fluid").select("span").first().text()); //get the price
// int a =1;
//
// for (Element row : table.select("tr")) {
// System.out.print(row.select("th").text()+ " " );
//
// for (Element column : row.select("td")) {
//
// if (a%2==0)
// System.out.println(column.text());
// a++;
//
// }
//
// } // code for getting info from selected item on it's page




//Set set = hmap.entrySet();
//Iterator iterator = set.iterator();
//while(iterator.hasNext()) {
// Map.Entry mentry = (Map.Entry)iterator.next();
// System.out.print("key is: "+ mentry.getKey() + " & Value is: ");
// System.out.println(mentry.getValue());
//} view ports and interfaces




//String ports = "1 x APU fan header 8 x SATA3 6.0 Gb/s 1 x TPM Header 1 x Clear CMOS jumper 1 x parallel port header 1 x serial port header 2 x USB 2.0/1.1 1 x USB 3.0/2.0 1 x S/PDIF out header 1 x Front panel audio header 1 x front panel header 2 x system fan headers 1 x 8-pin ATX 12V Power connector 1 x 24-pin ATX Power connector 1 x PCI slot 1 x PCI Express 2.0 x1 1 x PCI Express 2.0 x16 1 x PCI Express 3.0 x16";
//String[] pr = ports.split(" x ");
//int frst=0;
//ArrayList<String> sad = new ArrayList<String>();
//ArrayList<String> sad2 = new ArrayList<String>();
//
//for (String string : pr) {
//	sad.add(string);
//}
//
//for (String string : sad) {
//if (string.matches("\\d+")) {
//	frst = Integer.parseInt(string);				
//}
//
//else {
//sad2.add(string);
//}
//
//}
////sad2.set(0,frst+ " " + sad2.get(0));
//int a=0;
//ArrayList<String> nwel = new ArrayList<>();
//ArrayList<String> nums = new ArrayList<>();
//nums.add(frst+"");
//for (String string : sad2) {
//if(string.substring(string.length()-2).matches("\\s\\d+")) {
//	nums.add((string.substring(string.length()-1)));
//	nwel.add(string.substring(0,string.length() - 2));
//}
//else
//	nwel.add(string);
//}
//
//HashMap<String, String> hmap = new HashMap<String, String>();
//
//
////System.out.println(nums.toString());
////System.out.println(nwel.toString());
//if (nums.size()==nwel.size()) {
//for (int i = 0; i < nums.size(); i++) {
//	
//	hmap.put( nwel.get(i),nums.get(i));
//}
//}
//else {System.out.println("difference nums nwel"); 
//System.out.println(nums);
//System.out.println(nwel);}
//make hmap of string .. interaces ports etc



