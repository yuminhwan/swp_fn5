package test;
public class control {

	public static void main(String[] args) {
		// ���� ��� JSON�����͸� ������� �ʿ��� ��û������ �Է����ݴϴ�.
		//baseDate : ���س�¥, baseTime : ���ؽð�, x : �浵, y : ���� �������� Ȯ���ϼ���
		String Q0 = "���ֽ�";   //����
        String numOfRows = "1"; // �ڽ��� ��ȸ�ϰ���� ��¥�� �Է����ּ���
	    
	    // ������͸� ������ ��ü�� ����
		VillageWeatherJSON vwJson = new VillageWeatherJSON();
		// ������͸� JSON���·� �޾� VillageWeather�� ����
		for(int i =1; i<454; i++) {
		VillageWeather vw = vwJson.getVillageWeather(i);
		// �����ͺ��̽��� ���ӿ� �����ϴ°�ü�� ����� �����ͺ��̽��� �Է�
		VillageWeatherDAO vwDao = new VillageWeatherDAO();
		vwDao.intertVillageWeather(i, vw);
		}
	}
}