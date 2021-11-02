package test;
public class control {

	public static void main(String[] args) {
		// 동내 기상 JSON데이터를 얻기위해 필요한 요청변수를 입력해줍니다.
		//baseDate : 기준날짜, baseTime : 기준시간, x : 경도, y : 위도 참고문서를 확인하세요
		String Q0 = "진주시";   //위도
        String numOfRows = "1"; // 자신이 조회하고싶은 날짜를 입력해주세요
	    
	    // 기상데이터를 얻어오는 객체를 생성
		VillageWeatherJSON vwJson = new VillageWeatherJSON();
		// 기상데이터를 JSON형태로 받아 VillageWeather에 저장
		for(int i =1; i<454; i++) {
		VillageWeather vw = vwJson.getVillageWeather(i);
		// 데이터베이스에 접속에 관련하는객체를 만들고 데이터베이스에 입력
		VillageWeatherDAO vwDao = new VillageWeatherDAO();
		vwDao.intertVillageWeather(i, vw);
		}
	}
}