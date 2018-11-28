package cryptoConvert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONException;
import java.util.Iterator;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.JSONArray;
import org.json.simple.parser.*; 

 public class JsonApi {
	
	String output = "";
   	StringBuffer odgovor = new StringBuffer();
   	
    	public  StringBuffer metodaDohvata (String valutaIz,String valutaU) throws IOException{
    		URL url = null ;
    		url = new URL("https://min-api.cryptocompare.com/data/price?fsym="+valutaIz+"&tsyms="+valutaU);
            	HttpURLConnection connect = (HttpURLConnection) url.openConnection();
            	if (connect.getResponseCode() != 200) {
                	throw new RuntimeException("Pogreška : HTTP status-kod : "
                        + connect.getResponseCode());
            	}
            	BufferedReader br = new BufferedReader(new InputStreamReader(
            	(connect.getInputStream())));
             	//String output;
            	System.out.println("Izlaz sa servera .... \n");
             	while ((output = br.readLine()) != null) {
            		odgovor.append(output);
             	}
             	br.close(); 
             	return odgovor;
    	}
    	public Double jsonRukovanje(String odgovor,String unos) throws ParseException{ 
    	     String odgovorSt = odgovor.toString();
             JSONParser parser = new JSONParser();
             Object ob = parser.parse(odgovorSt);
             JSONObject obj = (JSONObject)ob;   
             Double valuta =  (Double) obj.get(unos);
             return valuta;
             
    	}
}
