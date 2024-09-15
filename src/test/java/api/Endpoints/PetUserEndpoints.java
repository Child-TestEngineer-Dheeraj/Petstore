package api.Endpoints;

import static io.restassured.RestAssured.*;


import api.Payloads.User_Createdata;
import io.restassured.response.Response;

public class PetUserEndpoints {
	
	//Create User

	public static Response CreateUser(User_Createdata data) {

		Response CreatedUserResponse = given().contentType("application/json").accept("application/json").body(data)
				.when().post(Routes.CreateUser);

		return CreatedUserResponse;
	}

	//Get Created user
	public static Response GetCreatedUser(String CreatedUserName) {

		Response getCreatedUser = given().pathParam("username", CreatedUserName).when().get(Routes.GetUser);

		return getCreatedUser;

	}

	//Login with created user cred
	public static Response LogInCreatedUser(String CreatedUserName, String Password) {

		Response loginUser = given().queryParam(CreatedUserName, Password).when().get(Routes.LoginUser);

		return loginUser;

	}

	//Update the created user
	public static Response UpdateCreatedUser(String CreatedUserName, User_Createdata data) {

		Response updatedUser = given().pathParam("username", CreatedUserName).body(data).contentType("application/json").accept("application/json")				
				.when().get(Routes.UpdateUser);

		return updatedUser;

	}

	//Delete Created User
	public static Response DeleteCreatedUser(String CreatedUserName) {

		Response DeleteCreatedUser = given().pathParam("CreatedUser", CreatedUserName).accept("application/json").when().get(Routes.DeleteUser);

		return DeleteCreatedUser;

	}
	
	//logOut with created user cred
	public static Response LogoutCreatedUser() {

		Response LogoutCreatedUser = given().when().get(Routes.LogoutUser);

		return LogoutCreatedUser;

	}
}
