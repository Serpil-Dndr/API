package utilities;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;

import java.util.Date;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;


public class ApiCalls {

    //we will create dynamic method for response
    //this method will return  response , we will use matchers class

    public static Response checkUserExistsWithId(int id, int statuscode, String email, String first_name, String last_name){

        Response response = given()
                .when() //body goes in here
                .get(BaseUrl.regresInUsers(id));

        response.then()
                .statusCode(statuscode)
                .contentType("application/json; charset=utf-8")
                .body("data.email", Matchers.equalTo(email),
                        "data.first_name",Matchers.equalTo(first_name),
                        "data.last_name",Matchers.equalTo(last_name));

        return response;
    }
   public static Response allNamesListReqresIn(int statusCode,String name){
        Response response=given()
                .when()
                .get(BaseUrl.regresInUser());
       response.then()
               .statusCode(statusCode)
               .contentType("application/json; charset=utf-8");
       JsonPath jsonPath =response.jsonPath();
       Assert.assertTrue(jsonPath.getList("data.first_name").contains(name));

       return response;
   }
   public static  Response checkUserExistWithIdJsonPath(int id, int statuscode, String email, String first_name, String last_name){

       Response response = given()
               .when() //body goes in here
               .get(BaseUrl.regresInUsers(id));
       response.then()
               .statusCode(statuscode)
               .contentType("application/json; charset=utf-8");
       JsonPath jsonPath = response.jsonPath();

       Assert.assertEquals(email,jsonPath.getString("data.email"));
       Assert.assertEquals(first_name,jsonPath.get("data.first_name"));
       Assert.assertEquals(last_name,jsonPath.get("data.last_name"));


       return response;
   }
    public static Response checkUserWithIdHerokuapp(int id,
                                                    int statusCode,
                                                    String firstname,
                                                    String lastname,
                                                    boolean depositPaid,
                                                    int totalPrice,
                                                    String checkIn,
                                                    String checkOut) {

        Response response = given()
                .when()
                .get(BaseUrl.herokuappuserId(id));

        response
                .then()
                .statusCode(statusCode)
                .contentType("application/json; charset=utf-8")
                .body("firstname", equalTo(firstname),
                        "lastname", equalTo(lastname),
                        "totalprice", equalTo(totalPrice),
                        "depositpaid", equalTo(depositPaid),
                        "bookingdates.checkin", equalTo(checkIn),
                        "bookingdates.checkout", equalTo(checkOut));

        return response;
    }

}

