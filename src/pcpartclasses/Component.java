package pcpartclasses;

import java.io.Serializable;

public abstract class Component implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String CompLink;
	private String Name;
	private int price;
	private String ID;
	private String chast;
	public Component() {
		
	}
	
	public String getCompLink() {
		return CompLink;
	}
	public void setCompLink(String compLink) {
		CompLink = compLink;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = Integer.parseInt(price);
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}

	public String getChast() {
		return chast;
	}

	public void setChast(String chast) {
		this.chast = chast;
	}
	
	
}
