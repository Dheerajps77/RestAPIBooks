package test1;

import org.json.JSONObject;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Utils {

	
	static JSONObject jsonObject;
	static String randomUserName;
	static String randomUserPassword;
	public static String generateUserName(int g) {
		String newRandomGenString = "";
		int n = 10;
		try {

			for (int i = 0; i < g; i++) {

				int n1 = (int) (Math.random() * (0.1 * 100));
				String str = Integer.toString(n1);
				newRandomGenString = newRandomGenString + str + "";
			}

		} catch (Exception e) {
			throw e;
		}
		return "TOOLSQA-TestAPI" + newRandomGenString;
	}
	
	public static String generateUserPassword(int g) {
		StringBuilder sb=new StringBuilder();
		String strRandomString="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		char newRandomGenString = 0;
		try {

			for (int i = 0; i < g; i++) {

				int n1 = (int) (Math.random() * (0.1 * 100));
				newRandomGenString=strRandomString.charAt(n1);
				sb.append(newRandomGenString);
			}

		} catch (Exception e) {
			throw e;
		}
		return "Test@8" + sb.toString();
	}
	
	public static String jsonValueRead(Response response, String key)
	{
		String stringValue="";
		try {
			jsonObject=new JSONObject(response.asString());
			stringValue=(String) jsonObject.get(key);
		} catch (Exception e) {
			throw e;
		}
		return stringValue;
	}
	
	public static JSONObject stringToJSON()
	{
		jsonObject=new JSONObject();
		try {
			jsonObject.put("UserName", randomUserName);
			jsonObject.put("UserName", randomUserPassword);
		} catch (Exception e) {
			throw e;
		}
		return jsonObject;
	}
	
	public static void main(String[] args) {
		randomUserName=generateUserName(4);
		randomUserPassword=generateUserPassword(6);
		System.out.println(randomUserPassword);
	}
}
