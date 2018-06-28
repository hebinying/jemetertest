package Rest_Assuredtest.heby;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.specification.ProxySpecification.host;

import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;


public class test01 {

	/*@BeforeClass
	public static void setup(){
		useRelaxedHTTPSValidation();
		RestAssured.basePath="http://b.m2c2017test.com";
		RestAssured.proxy("127.0.0.1",8080);
	}
	
	@Test
	public void test() {
		//fail("Not yet implemented");
	}
	@Test
	public void testget(){
		given().
		expect().
			statusCode(200).
		when().
			get("https://api.m2c2017test.com/m2c.scm/web/goods/SP67C9D9C554464FC996DEC5E7835376B5");
	}

	public void SetProxy(){
		RestAssured.proxy=host("127.0.0.1").withPort(8080);
	}*/
	/*@Test
	public void ApiTest(){
		Response response=get("https://testerhome.com/search?q=接口测试");
		
		
		if (response.getStatusCode()==200){
			//response.getBody().print();
			//response.getBody().prettyPrint();
		}
		
		Response response2=given().param("q","自动化测试").get("https://testerhome.com/search");
		
		if(response2.getStatusCode()==200){
			response2.getBody().prettyPrint();
			String headervalue=response2.header("headerName");
			
		}
		
	}*/
	
	@Test
	public void LoginTest(){
		//given().proxy("127.0.0.1", 8080);
		Response response=given().
				formParam("mobile","13500000046").formParam("password","e10adc3949ba59abbe56e057f20f883e").
				when().post("https://api.m2c2017test.com/m2c.users/user/dlogin");
		if (response.statusCode()==200){
			response.getBody().prettyPrint();
		}
		Headers allHeader=response.getHeaders();
		String headerName=response.getHeader("headerName");
		Map<String,String> allCookies=response.getCookies();
		String cookieValue=response.getCookie("cookieName");
		String statusLine=response.getStatusLine();
		int statusCode=response.getStatusCode();
		System.out.println(statusCode);
		
	}
	
	/*@Test
	public void testJsonPost(){
		
		HashMap<String,Object> data=new HashMap<String,Object>();
		data.put("mobile", "13500000046");
		data.put("password","e10adc3949ba59abbe56e057f20f883e");
		data.put("ppDeviceSn", "111");
		data.put("terminalType", 3);
		
		HashMap<String,Object> root=new HashMap<String,Object>();
		root.put("topic", data);
		
		given().contentType(ContentType.JSON).body(data).
			when().post("https://api.m2c2017test.com/m2c.users/user/dlogin").prettyPeek()
			;
	}*/
	
	
	@Test
	public void testSpec(){
		ResponseSpecification rs=new ResponseSpecBuilder().build();
		rs.statusCode(200);
		//rs.time(2000L);
		given().get("https://testerhome.com/topics/7060.json").then().spec(rs);
	}

}
