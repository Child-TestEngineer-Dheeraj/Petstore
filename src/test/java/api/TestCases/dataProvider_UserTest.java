package api.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.Endpoints.PetUserEndpoints;
import api.Payloads.User_Createdata;
import api.Utilities.dataProvider;
import io.restassured.response.Response;

public class dataProvider_UserTest {
	
	@Test(priority = 1, description = "Creating User using data provider", dataProvider = "CreateUser", dataProviderClass = dataProvider.class)
	public void CreateUser(String username,String firstName,String lastName,String email,String password,String phone,String userStatus )
	{
		User_Createdata data=new User_Createdata();
		data.setUsername(username);
		data.setUsername(firstName);
		data.setUsername(lastName);
		data.setUsername(email);
		data.setUsername(password);data.setUsername(phone);
		data.setUsername(userStatus);
		
		Response createRes= PetUserEndpoints.CreateUser(data);
		Assert.assertEquals(createRes.getStatusCode(), 200);
		
	}

}
