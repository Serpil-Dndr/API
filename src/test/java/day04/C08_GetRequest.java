package day04;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import utilities.BaseUrlSpec;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C08_GetRequest extends BaseUrlSpec {

    @Test
    public void userId1RegressIn(){
/*
*** TC08:Send a GET Request to https://reqres.in/api/users/1
             and verify:
             The status code is 200
             The content type is application/json; Charset=utf-8
             email is george.bluth@reqres.in
             first_name is George
             last_name is Bluth
             avatar is https://reqres.in/img/faces/1-image.jpg
         {
           "id": 1,
           "email": "george.bluth@reqres.in",
           "first_name": "George",
           "last_name": "Bluth",
           "avatar": "https://reqres.in/img/faces/1-image.jpg"
         },
         *

 */
        // end-point and request
        specReqresIn.pathParams("pp1","api","pp2","users");
        //2-expected data
        //3- send request and save response

        Response response = given().spec(specReqresIn)
                .when()
                .get("/{pp1}/{pp2}");
        //Assertion
//        response
//                .then()
//                .statusCode(200)
//                .contentType("application/json; Charset=utf-8");
        JsonPath jsonPath = response.jsonPath();
        System.out.println(jsonPath.getList("data.email"));
        System.out.println(jsonPath.getList("data.first_name"));
        System.out.println(jsonPath.getList("data.last_name"));

        assertEquals(1,jsonPath.getInt("data[0].id"));
        assertEquals("george.bluth@reqres.in",jsonPath.getString("data[0].email"));
        assertEquals("George",jsonPath.getString("data[0].first_name"));
        assertEquals("Bluth",jsonPath.getString("data[0].last_name"));
        assertEquals("https://reqres.in/img/faces/1-image.jpg",jsonPath.getString("data[0].avatar"));


    }
    @Test
    public void postHerokuapp(){

/*
{
            "firstname" : "Ahmet",
            "lastname" : “Bulut",
            "totalprice" : 500,
            "depositpaid" : false,
            "bookingdates" : {
            "checkin" : "2023-01-10",
            "checkout" : "2023-01-20"
                                        },
            "additionalneeds" : "wi-fi"
           }
           Validate for response
        status code 200
        content type application/json
        "firstname" "Ahmet"
        "lastname" "Bulut"
        "totalprice" 500
        "depositpaid" false
        "checkin"  "2023-01-10",
         "checkout"  "2023-01-20"
        "additionalneeds" wi-fi
 */
        //1- end point
      //  String url ="https://restful-booker.herokuapp.com/booking";
       specHerokuApp.pathParams("pp1","booking");
        JSONObject requestBody = new JSONObject();
        JSONObject bookingDates = new JSONObject();
        bookingDates.put("checkin","2023-01-10");
        bookingDates.put("checkout","2023-01-20");
        requestBody.put("firstname","Ahmet");
        requestBody.put("lastname","Bulut");
        requestBody.put("totalprice",500);
        requestBody.put("depositpaid","true");
        requestBody.put("bookingdates",bookingDates);
        requestBody.put("addintinalneeds","wi-fi");
        Response response = given().spec(specHerokuApp)
                .when().body(requestBody.toString())
                .post("/{pp1}");
        response.prettyPrint();

//  response.then()
//          .assertThat()
//          .statusCode(200)
//          .contentType("application/json")
//          .body();


    }
}
