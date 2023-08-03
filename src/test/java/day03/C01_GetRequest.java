package day03;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C01_GetRequest {
     /*
    C01_GetRequest
***  TC01: Print the Response that returns when we send a GET request
     to https://reqres.in/api/users/
     */

    // 1- End-point and request body
    // 2- Expected data
    // 3- Send our request and save our response
    // 4- Assertions

    String url = "https://reqres.in/api/users/";
    // 1 There is no request body

    // 2 no asked/needed
   @Test
    public void printResponse(){
       // 3

       Response response = given().when().get(url); // This is a get request

      // response.prettyPrint(); // gives me only the json response

       // response.prettyPeek(); // gives me everything



       // 4
       // We have no assertions

       response.then().log().all();

   }




}
