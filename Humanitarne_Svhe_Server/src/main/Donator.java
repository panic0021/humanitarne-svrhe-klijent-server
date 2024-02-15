package main;

import java.util.GregorianCalendar;

public class Donator {
	private String username;
	private String password;
	private String email;
	private String JMBG;

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getJMBG() {
		return JMBG;
	}
	public void setJMBG(String jMBG) {
		JMBG = jMBG;
	}
	private String ime;
	private String prezime;;
	private String adresa;
	private String brojKartice;
	private int cvv;
	private int iznos;
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public String getBrojKartice() {
		return brojKartice;
	}
	public void setBrojKartice(String brojKartice) throws Exception{
		if(brojKartice.length()!=19) {
			throw new Exception("Neispravan format!");
		}
		if(brojKartice.charAt(4)!='-'||brojKartice.charAt(9)!='-'||brojKartice.charAt(14)!='-') {
			throw new Exception("Neispravan format!");
		}
		String[]brojevi=brojKartice.split("-");
		for(int i=0;i<brojevi.length;i++) {
			if(brojevi[i].length()!=4||(!brojevi[i].matches("[0-9]+"))){
				throw new Exception("Neispravan format!");
			}
		}
		this.brojKartice = brojKartice;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) throws Exception{
		if(cvv<100||cvv>999) {
			throw new Exception("CVV mora da bude trocifren broj!");
		}
		this.cvv = cvv;
	}
	public int getIznos() {
		return iznos;
	}
	public void setIznos(int iznos) throws Exception {
		if(iznos<200) {
			throw new Exception("Nedovoljan iznos, mora 200 minimum.");
		}
		this.iznos = iznos;
	}
	@Override
	public String toString() {
		return "IME: "+getIme()+"\nPREZIME: "+getPrezime()+"\nADRESA: "+getAdresa()+"\nBROJ KARTICE: "+getBrojKartice()+"\nCVV: "+getCvv()+"\nIZNOS: "+getIznos();

	}
	public String toStringZaDonatora() {
		return "IME: "+getIme()+"|PREZIME: "+getPrezime()+"|ADRESA: "+getAdresa()+"|DATUM I VREME: "+new GregorianCalendar().getTime()
				+"|IZNOS: "+getIznos();
	}
	public String toStringP() {
		return "*IME: "+getIme()+"|PREZIME: "+getPrezime()+"|DATUM I VREME: "+new GregorianCalendar().getTime()
				+"|IZNOS: "+getIznos();
	}
	
}
