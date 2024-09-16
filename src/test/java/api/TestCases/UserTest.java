package api.TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import com.github.javafaker.Faker;

import api.Endpoints.PetUserEndpoints;
import api.Payloads.User_Createdata;
import io.restassured.response.Response;

public class UserTest {
	Faker fakeData;
	User_Createdata data;
	
	@BeforeClass
	public void DataSetup()
	{
		fakeData=new Faker();
		data=new User_Createdata();
		data.setUsername("Draj11223344");
		data.setFirstName("Draj");
		data.setLastName("1234");
		data.setEmail("Draj1234.gmail.com");
		data.setPassword("Draj@1234");
		data.setUserStatus("1");
		data.setPhone("2345673345");	
	}
	
	@Test(priority = 1)
	public void CreateUser_validation()
	{
		Response createRes= PetUserEndpoints.CreateUser(data);
		createRes.then().log().all();
		Assert.assertEquals(createRes.getHeader("Server"), "Jetty(9.2.9.v20150224)");
		Assert.assertEquals(createRes.getStatusCode(), 200);
		
	}
	
	@Test(priority = 2)
	public void getCreatedUser_validation()
	{
		Response createRes= PetUserEndpoints.GetCreatedUser(this.data.getUsername());
		Assert.assertEquals(createRes.getStatusCode(), 200);
		String User_id=createRes.jsonPath().getString("username");
		System.out.println("Created Username"+User_id);
	
	}
	
	@Test(priority = 3)
	public void LoginCreatedUser_validation()
	{
		Response createRes= PetUserEndpoints.LogInCreatedUser(this.data.getUsername(),this.data.getPassword());
		Assert.assertEquals(createRes.getStatusCode(), 200);
		String Login_Message = createRes.jsonPath().getString("message");
		System.out.println("Login Message :"+Login_Message);
	}
	
	@Test(priority = 4)
	public void DeleteCreatedUser_validation()
	{
		Response DeleteRes= PetUserEndpoints.DeleteCreatedUser(this.data.getUsername());
		Assert.assertEquals(DeleteRes.getStatusCode(), 200);
	}
	
	//@Test(priority = 5)
	public void LogoutCreatedUser_validation()
	{
		Response DeleteRes= PetUserEndpoints.DeleteCreatedUser(this.data.getUsername());
		Assert.assertEquals(DeleteRes.getStatusCode(), 200);
	}

}
