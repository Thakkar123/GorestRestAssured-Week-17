package in.co.gorest.userinfo;

import in.co.gorest.model.UserPojo;
import in.co.gorest.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UserPutTest extends TestBase{

    @Test
    public void updateUserInfo(){

        UserPojo userPojo = new UserPojo();
        userPojo.setName("Ramila Patel");
        userPojo.setGender("Female");
        userPojo.setEmail("Ramila.patel@gmail.com");
        userPojo.setStatus("active");

        Response response = given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer c426452f777927f6e49219f45652a5fd08178e3f873af217a5b982a6fdd15dac")
                .pathParam("id",5390)
                .body(userPojo)
                .when()
                .put("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
