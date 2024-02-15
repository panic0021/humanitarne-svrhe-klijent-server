package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Server {
	public static ArrayList<ClientHandler> donatori = new ArrayList<>();
	public static int ukupnoSakupljeno;
	public static ServerSocket serverskiSoket = null;

	public static void main(String[] args) {
		try {
			serverskiSoket = new ServerSocket(9004);
			ukupnoSakupljeno=procitajStanje();
			while (true) {
				System.out.println("Osluskujem...");
				Socket komSoket = serverskiSoket.accept();
				System.out.println("Veza uspostavljena!");
				ClientHandler noviDonator=new ClientHandler(komSoket);
				donatori.add(noviDonator);
				noviDonator.start();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void dobrodoslicaDonatoru(ClientHandler new_client) {
		for (ClientHandler don : donatori) {
			if (don == new_client) {
				new_client.kaKlijentu.println("Dobrodosao, ako zelis da prekines ukucaj exit");
				break;
			}
		}
	}
	
	public static void ispratiDonatora(ClientHandler new_client) {
		for (ClientHandler don : donatori) {
			if (don == new_client) {
				new_client.kaKlijentu.println("Dovidjenja!");
				break;
			}
		}
		donatori.remove(new_client);
	}

	public static int procitajStanje() {
		int sredstva=0;
		try {
			File fajl = new File("ukupno.txt");
			Scanner citac = new Scanner(fajl);
			if (citac.hasNextLine()) {
				String data = citac.nextLine();
				sredstva = Integer.parseInt(data);
				citac.close();
				return sredstva;
			}
			citac.close();
		} catch (FileNotFoundException e) {
			System.err.println("Baza nije povezana.");
			return 0;
		}
		return sredstva;
	}

}