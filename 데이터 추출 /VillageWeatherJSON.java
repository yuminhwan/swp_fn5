package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class VillageWeatherJSON {
	final static String serviceKey = "=4iLTUhbwnYU%2FGqfRYKjRgjzjk3YxN%2Fp0Va%2FWf71ZHA4fiCaYkSgReWDTmd6sVwQCXV7KJ6DBQ2VOk4HD%2FJlraQ%3D%3D";

	public VillageWeather getVillageWeather(int a) {
		 String urlStr = "http://apis.data.go.kr/B552657/HsptlAsembySearchService/getHsptlMdcncListInfoInqire?serviceKey=4iLTUhbwnYU"
	         		+ "%2FGqfRYKjRgjzjk3YxN%2Fp0Va%2FWf71ZHA4fiCaYkSgReWDTmd6sVwQCXV7KJ6DBQ2VOk4HD%2FJlraQ%3D%3D&Q0=%EC%A7%84%EC%A3%BC%EC%8B%9C&numOfRows=453" + "&_type=json";
			 
	       VillageWeather vl = new VillageWeather(); 
	        try {
	        	URL url = new URL(urlStr);
	            BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream(),"UTF-8"));
	            String line = "";
	            String result="";
	            while((line=bf.readLine())!=null){ 
	                result=result.concat(line);
	            }
	            
	            
	            JSONParser jsonParser = new JSONParser();
	            JSONObject jsonObj = (JSONObject) jsonParser.parse(result);
	            JSONObject parse_response = (JSONObject) jsonObj.get("response");
	            JSONObject parse_body = (JSONObject) parse_response.get("body");
	            JSONObject parse_items = (JSONObject) parse_body.get("items");
	            JSONArray parse_item = (JSONArray) parse_items.get("item");
	            
	            
	    		JSONObject obj;
	    	
			for (int i = 0; i < a; i++) {
				obj = (JSONObject) parse_item.get(i); 
				if (obj.get("dutyAddr")!= null) {
					vl.Hospital_location = (obj.get("dutyAddr")).toString();
				}
				else {
					vl.Hospital_location = "��������";
				}
				
				if (obj.get("dutyDivNam")!= null) {
					vl.Hospital_category = (obj.get("dutyDivNam")).toString();
				}
				else {
					vl.Hospital_category = "��������";
				}
				
				if (obj.get("dutyName")!= null) {
					vl.Hospital_name = (obj.get("dutyName")).toString();
				}
				else {
					vl.Hospital_name = "��������";
				}
				
				if (obj.get("dutyTel1")!= null) {
					vl.Hospital_tel = (obj.get("dutyTel1")).toString();
				}
				else {
					vl.Hospital_tel = "��������";
				}
				
				if (obj.get("dutyTel1")!= null) {
					vl.Hospital_tel = (obj.get("dutyTel1")).toString();
				}
				else {
					vl.Hospital_tel = "��������";
				}
				
				if (obj.get("dutyTel1")!= null) {
					vl.Hospital_tel = (obj.get("dutyTel1")).toString();
				}
				else {
					vl.Hospital_tel = "��������";
				}
				
				if (obj.get("dutyTel1")!= null) {
					vl.Hospital_tel = (obj.get("dutyTel1")).toString();
				}
				else {
					vl.Hospital_tel = "��������";
				}
				
				if (obj.get("dutyTel1")!= null) {
					vl.Hospital_tel = (obj.get("dutyTel1")).toString();
				}
				else {
					vl.Hospital_tel = "��������";
				}
				
				if (obj.get("dutyTel1")!= null) {
					vl.Hospital_tel = (obj.get("dutyTel1")).toString();
				}
				else {
					vl.Hospital_tel = "��������";
				}
				
				if (obj.get("dutyTime1s")!= null) {
					vl.Hospital_M = (obj.get("dutyTime1s")).toString() + (obj.get("dutyTime1c")).toString();
				}
				else {
					vl.Hospital_M = "��������";
				}
				
				if (obj.get("dutyTime2s")!= null) {
					vl.Hospital_Tu = (obj.get("dutyTime2s")).toString() + (obj.get("dutyTime2c")).toString();
				}
				else {
					vl.Hospital_Tu = "��������";
				}
				
				if (obj.get("dutyTime3s")!= null) {
					vl.Hospital_W = (obj.get("dutyTime3s")).toString() + (obj.get("dutyTime3c")).toString();
				}
				else {
					vl.Hospital_W = "��������";
				}
				
				if (obj.get("dutyTime4s")!= null) {
					vl.Hospital_Th = (obj.get("dutyTime4s")).toString() + (obj.get("dutyTime4c")).toString();
				}
				else {
					vl.Hospital_Th = "��������";
				}
				
				if (obj.get("dutyTime5s")!= null) {
					vl.Hospital_F = (obj.get("dutyTime5s")).toString() + (obj.get("dutyTime5c")).toString();
				}
				else {
					vl.Hospital_F = "��������";
				}
				
				if (obj.get("dutyTime6s")!= null) {
					vl.Hospital_Sa = (obj.get("dutyTime6s")).toString() + (obj.get("dutyTime6c")).toString();
				}
				else {
					vl.Hospital_Sa = "��������";
				}
				
				if (obj.get("dutyTime7s")!= null) {
					vl.Hospital_Su = (obj.get("dutyTime7s")).toString() + (obj.get("dutyTime7c")).toString();
				}
				else {
					vl.Hospital_Su = "��������";
				}
				
				if (obj.get("dutyTime8s")!= null) {
					vl.Hospital_H = (obj.get("dutyTime8s")).toString() + (obj.get("dutyTime8c")).toString();				}
				else {
					vl.Hospital_H = "��������";
				}
				
				

			}
	            

	            
			} catch (MalformedURLException e) {
				System.out.println("MalformedURLException : " + e.getMessage());
			} catch (IOException e) {
				System.out.println("IOException : " + e.getMessage());
			} catch (ParseException e) {
				System.out.println("ParseException : " + e.getMessage());		
			}
	        
	        
			return vl;// ��簪�� ����� VillageWeather��ü�� ��ȯ�մϴ�.
	}
}