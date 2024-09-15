package api.Endpoints;

import static io.restassured.RestAssured.*;

import java.util.ResourceBundle;

import api.Payloads.User_Createdata;
import io.restassured.response.Response;

public class PetUserEndpoints2 {
	
	
	//Method created to get properties files
	public static ResourceBundle getURL()
	{
		ResourceBundle bundle=ResourceBundle.getBundle("Routes"); //Load the URL from Properties files
				return bundle;
	}
	
	//Create User

	public static Response CreateUser(User_Createdata data) {

		String CreateUser = getURL().getString("CreateUser_prop");
		Response CreatedUserResponse = given().contentType("application/json").accept("application/json").body(data)
				.when().post(CreateUser);

		return CreatedUserResponse;
	}

	//Get Created user
	public static Response GetCreatedUser(String CreatedUserName) {
		
		String GetUser= getURL().getString("GetUser_prop");
		Response getCreatedUser = given().pathParam("username", CreatedUserName).when().get(GetUser);

		return getCreatedUser;

	}

	//Login with created user cred
	public static Response LogInCreatedUser(String CreatedUserName, String Password) {
		String LoginUser= getURL().getString("LoginUser_prop");
		Response loginUser = given().queryParam(CreatedUserName, Password).when().get(LoginUser);

		return loginUser;

	}

	//Update the created user
	public static Response UpdateCreatedUser(String CreatedUserName, User_Createdata data) {
		String UpdateUser= getURL().getString("UpdateUser_prop");
		Response updatedUser = given().pathParam("username", CreatedUserName).body(data).contentType("application/json").accept("application/json")				
				.when().get(UpdateUser);

		return updatedUser;

	}

	//Delete Created User
	public static Response DeleteCreatedUser(String CreatedUserName) {
		String DeleteUser= getURL().getString("DeleteUser_prop");
		Response DeleteCreatedUser = given().pathParam("CreatedUser", CreatedUserName).accept("application/json").when().get(DeleteUser);

		return DeleteCreatedUser;

	}
	
	//logOut with created user cred
	public static Response LogoutCreatedUser() {
		String LogoutUser= getURL().getString("LogoutUser_prop");
		Response LogoutCreatedUser = given().when().get(LogoutUser);

		return LogoutCreatedUser;

	}
}
