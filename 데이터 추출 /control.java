package test;
public class control {

	public static void main(String[] args) {

		String Q0 = "���ֽ�";   
        String numOfRows = "1"; 
	    

		VillageWeatherJSON vwJson = new VillageWeatherJSON();
		for(int i =1; i<454; i++) {
		VillageWeather vw = vwJson.getVillageWeather(i);
		VillageWeatherDAO vwDao = new VillageWeatherDAO();
		vwDao.intertVillageWeather(i, vw);
		}
	}
}