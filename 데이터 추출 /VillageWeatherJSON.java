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

/*
 * 
 * VillageWeatherJSON 클래스는 기상청에서 제공하는 동내 기상데이터를 JSON형태로 가져오는 클래스입니다.
 * 동내 기상정보를 JSON데이터로 가져와서 VillageWeather객체를 만들어 저장하여 반환합니다. */
public class VillageWeatherJSON {
	// 서비스키로 기상청에서 제공해줍니다. 고정적으로 사용되기 때문에 final static변수로 설정하겠습니다.
	final static String serviceKey = "=4iLTUhbwnYU%2FGqfRYKjRgjzjk3YxN%2Fp0Va%2FWf71ZHA4fiCaYkSgReWDTmd6sVwQCXV7KJ6DBQ2VOk4HD%2FJlraQ%3D%3D";

	public VillageWeather getVillageWeather(int a) {
		 String urlStr = "http://apis.data.go.kr/B552657/HsptlAsembySearchService/getHsptlMdcncListInfoInqire?serviceKey=4iLTUhbwnYU"
	         		+ "%2FGqfRYKjRgjzjk3YxN%2Fp0Va%2FWf71ZHA4fiCaYkSgReWDTmd6sVwQCXV7KJ6DBQ2VOk4HD%2FJlraQ%3D%3D&Q0=%EC%A7%84%EC%A3%BC%EC%8B%9C&numOfRows=453" + "&_type=json";
			 
	       VillageWeather vl = new VillageWeather(); // 결과 데이터를 저장할 동내기상객체를 만듭니다.
	        try {
	        	URL url = new URL(urlStr); // 완성된 urlStr을 사용해서 URL 만들어 해당 데이터를 가져옵니다.
	            BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream(),"UTF-8"));
	            String line = "";
	            String result="";
	            //버퍼에 있는 정보를 문자열로 변환.
	            while((line=bf.readLine())!=null){ //bf 에 있는값을 읽어와서 하나의 문자열로 만듭니다.
	                result=result.concat(line);
	            }
	           //System.out.println(result);
	            
	            //문자열을 JSON으로 파싱합니다. 마지막 배열형태로 저장된 데이터까지 파싱해냅니다.
	            JSONParser jsonParser = new JSONParser();
	            JSONObject jsonObj = (JSONObject) jsonParser.parse(result);
	            JSONObject parse_response = (JSONObject) jsonObj.get("response");
	            JSONObject parse_body = (JSONObject) parse_response.get("body");// response 로 부터 body 찾아오기
	            JSONObject parse_items = (JSONObject) parse_body.get("items");// body 로 부터 items 받아오기
	            JSONArray parse_item = (JSONArray) parse_items.get("item");// items로 부터 itemlist 를 받아오기 itemlist : 뒤에 [ 로 시작하므로 jsonarray이다.
	            
	            
	    		JSONObject obj;
	    	
			for (int i = 0; i < a; i++) {
				obj = (JSONObject) parse_item.get(i); // 해당 item을 가져옵니다.
				if (obj.get("dutyAddr")!= null) {
					vl.Hospital_location = (obj.get("dutyAddr")).toString();
				}
				else {
					vl.Hospital_location = "정보없음";
				}
				
				if (obj.get("dutyDivNam")!= null) {
					vl.Hospital_category = (obj.get("dutyDivNam")).toString();
				}
				else {
					vl.Hospital_category = "정보없음";
				}
				
				if (obj.get("dutyName")!= null) {
					vl.Hospital_name = (obj.get("dutyName")).toString();
				}
				else {
					vl.Hospital_name = "정보없음";
				}
				
				if (obj.get("dutyTel1")!= null) {
					vl.Hospital_tel = (obj.get("dutyTel1")).toString();
				}
				else {
					vl.Hospital_tel = "정보없음";
				}
				
				if (obj.get("dutyTel1")!= null) {
					vl.Hospital_tel = (obj.get("dutyTel1")).toString();
				}
				else {
					vl.Hospital_tel = "정보없음";
				}
				
				if (obj.get("dutyTel1")!= null) {
					vl.Hospital_tel = (obj.get("dutyTel1")).toString();
				}
				else {
					vl.Hospital_tel = "정보없음";
				}
				
				if (obj.get("dutyTel1")!= null) {
					vl.Hospital_tel = (obj.get("dutyTel1")).toString();
				}
				else {
					vl.Hospital_tel = "정보없음";
				}
				
				if (obj.get("dutyTel1")!= null) {
					vl.Hospital_tel = (obj.get("dutyTel1")).toString();
				}
				else {
					vl.Hospital_tel = "정보없음";
				}
				
				if (obj.get("dutyTel1")!= null) {
					vl.Hospital_tel = (obj.get("dutyTel1")).toString();
				}
				else {
					vl.Hospital_tel = "정보없음";
				}
				
				if (obj.get("dutyTime1s")!= null) {
					vl.Hospital_M = (obj.get("dutyTime1s")).toString() + (obj.get("dutyTime1c")).toString();
				}
				else {
					vl.Hospital_M = "정보없음";
				}
				
				if (obj.get("dutyTime2s")!= null) {
					vl.Hospital_Tu = (obj.get("dutyTime2s")).toString() + (obj.get("dutyTime2c")).toString();
				}
				else {
					vl.Hospital_Tu = "정보없음";
				}
				
				if (obj.get("dutyTime3s")!= null) {
					vl.Hospital_W = (obj.get("dutyTime3s")).toString() + (obj.get("dutyTime3c")).toString();
				}
				else {
					vl.Hospital_W = "정보없음";
				}
				
				if (obj.get("dutyTime4s")!= null) {
					vl.Hospital_Th = (obj.get("dutyTime4s")).toString() + (obj.get("dutyTime4c")).toString();
				}
				else {
					vl.Hospital_Th = "정보없음";
				}
				
				if (obj.get("dutyTime5s")!= null) {
					vl.Hospital_F = (obj.get("dutyTime5s")).toString() + (obj.get("dutyTime5c")).toString();
				}
				else {
					vl.Hospital_F = "정보없음";
				}
				
				if (obj.get("dutyTime6s")!= null) {
					vl.Hospital_Sa = (obj.get("dutyTime6s")).toString() + (obj.get("dutyTime6c")).toString();
				}
				else {
					vl.Hospital_Sa = "정보없음";
				}
				
				if (obj.get("dutyTime7s")!= null) {
					vl.Hospital_Su = (obj.get("dutyTime7s")).toString() + (obj.get("dutyTime7c")).toString();
				}
				else {
					vl.Hospital_Su = "정보없음";
				}
				
				if (obj.get("dutyTime8s")!= null) {
					vl.Hospital_H = (obj.get("dutyTime8s")).toString() + (obj.get("dutyTime8c")).toString();				}
				else {
					vl.Hospital_H = "정보없음";
				}
				
				

			}
	            

	            
			} catch (MalformedURLException e) {
				System.out.println("MalformedURLException : " + e.getMessage());
			} catch (IOException e) {
				System.out.println("IOException : " + e.getMessage());
			} catch (ParseException e) {
				System.out.println("ParseException : " + e.getMessage());		
			}
	        
	        
			return vl;// 모든값이 저장된 VillageWeather객체를 반환합니다.
	}
}