package in.co.gorest.extractingresponsedata;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class SearchJsonPathGorest {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://gorest.co.in";
        RestAssured.basePath = "/public/v2/users";
        response = given()
                .when()
                .get()
                .then().statusCode(200);
    }

    // verify total records are 20
    @Test
    public void test001() {

        int records = response.extract().path("size");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Total records are : " + records);
        System.out.println("------------------End of Test---------------------------");
    }

    // verify id 2546 name = Jagdeep Gill VM
    @Test
    public void test002() {
        //    List<String> name = response.extract().path("findAll{it.id == 2546}");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Id 2546 name is : " + response.extract().path("findAll{it.id == 2546}.name[0]"));
        System.out.println("------------------End of Test---------------------------");
    }

    // verify id 2546 email address is = gill_vm_jagdeep@sporer-skiles.org
    @Test
    public void test003() {
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Id 2546 email address is : " + response.extract().path("findAll{it.id == 2546}.email[0]"));
        System.out.println("------------------End of Test---------------------------");
    }

    // All ID has status = "active"
    @Test
    public void test004() {
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Id has active status  : " + response.extract().path("findAll{it.status == 'active'}.id"));
        System.out.println("------------------End of Test---------------------------");
    }

    // id 2546 has gender = "female"
    @Test
    public void test005() {
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Id 2546 has gender : " + response.extract().path("findAll{it.id == 2546}.gender[0]"));
        System.out.println("------------------End of Test---------------------------");
    }

    // id 2545 has gender = "male"
    @Test
    public void test006() {
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Id 2545 has gender : " + response.extract().path("findAll{it.id == 2545}.gender[0]"));
        System.out.println("------------------End of Test---------------------------");
    }


}
