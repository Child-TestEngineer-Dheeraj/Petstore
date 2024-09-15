package api.Endpoints;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Routes {
	
	public static String BaseURL= "https://petstore.swagger.io/v2"; 
	
	//User Request
	public static String CreateUser= BaseURL+"/user"; 
	public static String GetUser= BaseURL+"/user/{username}"; 
	public static String UpdateUser= BaseURL+"/user/{username}"; 
	public static String DeleteUser= BaseURL+"/user/{username}"; 
	public static String LoginUser=BaseURL+"/user/login";
	public static String LogoutUser=BaseURL+"/user/logout";
	
	
	
}
