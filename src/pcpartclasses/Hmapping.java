package pcpartclasses;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public interface Hmapping extends Serializable{
	public static HashMap<String, Integer> getHmam(String ports){

		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		String[] pr = ports.split(" x ");
		int frst=0;
		ArrayList<String> sad = new ArrayList<String>();
		ArrayList<String> sad2 = new ArrayList<String>();
		boolean isIless = true;
		for (int i = 0; i < pr.length; i++) {
			String string = pr[i];
			//	System.out.println(string);

			if(i+1<pr.length) {isIless =true;}
			else {isIless=false;}

			if (string.endsWith("(1")&&isIless) {

				sad.add(string + " x "+ pr[i+1]);
				i++;
			}	
			//should pass strings like
			// and one number string
			// aasfafasdf134 3
			//KEYWORD ORIS for or's
			else if((string.startsWith("Top: ")||string.startsWith("Front: ")||string.startsWith("Rear: ")||string.startsWith("Side: ")||string.startsWith("Bottom: "))) {
				String sub = string.substring(3);
				String tfrsb = "";
				if(i==0 && pr[i+1].contains("/")&&pr[i+1].matches(".*\\d+.*")) 
				{
					sad.add((string.substring(string.length()-2).trim()));
					tfrsb = string.substring(0,string.length() - 2);

					if(pr[i+2].contains("опция")) {				sad.add("ORIS "+tfrsb + pr[i+1].replaceAll("/", "(опция)"));}
					else if(pr[i+2].contains("инсталиран")) {				sad.add("ORIS "+tfrsb +pr[i+1].replaceAll("/", "(инсталиран)"));}
					else {				sad.add("ORIS "+tfrsb + pr[i+1]);}
					i++;
					sad.add("ORIS " + tfrsb + pr[i+1] );
					i++;
				}


				else if((sub.contains("Top: ")||sub.contains("Front: ")||sub.contains("Rear: ")||sub.contains("Side: ")||sub.contains("Bottom: "))) {
					String chek = "";
					String rlstr="";
					if(sub.contains("Top: ")){
						chek = "Top: ";
						rlstr = string.substring(0,sub.indexOf(chek)+3);
						sub = string.substring(sub.indexOf(chek)+3, string.length());
					}
					if(sub.contains("Front: ")){
						chek = "Front: ";
						rlstr = string.substring(0,sub.indexOf(chek)+3);
						sub = string.substring(sub.indexOf(chek)+3, string.length());
					}
					if(sub.contains("Rear: ")){
						chek = "Rear: ";
						rlstr = string.substring(0,sub.indexOf(chek)+3);
						sub = string.substring(sub.indexOf(chek)+3, string.length());
					}
					if(sub.contains("Side: ")){
						chek = "Side: ";
						rlstr = string.substring(0,sub.indexOf(chek)+3);
						sub = string.substring(sub.indexOf(chek)+3, string.length());
					}
					if(sub.contains("Bottom: ")){
						chek = "Bottom: ";
						rlstr = string.substring(0,sub.indexOf(chek)+3);
						sub = string.substring(sub.indexOf(chek)+3, string.length());
					}
					sad.add(rlstr + Integer.parseInt((string.substring(string.length()-2).trim())));
					//System.out.println(sub);
					tfrsb = sub.substring(0,sub.length() - 2);
					if(pr[i+2].contains("опция")) {sad.add("ORIS "+tfrsb + pr[i+1].replaceAll("/", "(опция)"));}
					else if(pr[i+2].contains("инсталиран")) {sad.add("ORIS "+tfrsb +pr[i+1].replaceAll("/", "(инсталиран)"));}
					else {sad.add("ORIS "+tfrsb + pr[i+1]);}
					i++;
					sad.add("ORIS " + tfrsb + pr[i+1] );
					i++;


				}
				else {sad.add(string);}
				//System.out.println(string);
				//sad.add();


			}
			else {		
				sad.add(string);
			}
		}


		for (String string : sad) {
			if (string.matches("\\d+")) {
				frst = Integer.parseInt(string);				
			}

			else
				sad2.add(string);
		}
		if(sad.get(0).matches("\\d+")) {frst = Integer.parseInt(sad.get(0));}else {frst = 1;}

		ArrayList<String> nwel = new ArrayList<>();
		ArrayList<Integer> nums = new ArrayList<>();
		nums.add(frst);
		for (int i = 0; i < sad2.size(); i++) {

			String string = sad2.get(i);
			if(i!=sad2.size()-1) {
				if(string.matches("^.+?\\d+")) {
					nums.add(Integer.parseInt((string.substring(string.length()-2).trim())));
					nwel.add(string.substring(0,string.length() - 2));
				}
				else
					nwel.add(string);
			}
			else {
				nwel.add(string);
			}
		}

		if (nums.size()==nwel.size()) {
			for (int i = 0; i < nums.size(); i++) {

				hmap.put( nwel.get(i),nums.get(i));
			}
		}// make hmap of string .. interaces ports etc
		else {
			System.out.println("difference nums nwel  " + nums.size()+ "   "  + nwel.size()); 
			System.out.println(nums);
			System.out.println(nwel);
		}



		return hmap;
	}
}
