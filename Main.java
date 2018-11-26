package cryptoConvert;

import java.io.IOException;
import java.util.Scanner;

import org.json.simple.parser.ParseException;

public class Main {

	public static void main(String[] args)  {
		
		JsonApi japi = new JsonApi();
		Scanner sc = new Scanner(System.in);
		System.out.println("Credit for used API : https://min-api.cryptocompare.com/");
		System.out.println("Unesite oznaku kriptovalute npr.(BTC)");
		String kriptoUnos = sc.next().toUpperCase();
		System.out.println("Unesite oznaku odredišne valute npr(USD)");
		String valuta = sc.next().toUpperCase();
		try{
			String odgovorServera = japi.metoda(kriptoUnos,valuta).toString();
			Double rezultatParsiranja = japi.jsonRukovanje(odgovorServera,valuta);
			if(rezultatParsiranja == null){
				System.out.println("Greška prilikom parsiranja, molimo provjerite Vaš unos!");
			}else{
				System.out.println(rezultatParsiranja);
			}
		}catch(Exception E){
			System.out.println("Došlo je do pogreške");
		}
	}
}
