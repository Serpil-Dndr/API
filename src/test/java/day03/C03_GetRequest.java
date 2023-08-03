package day03;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C03_GetRequest {
        /*
    C03_GetRequest
***  TC03:Send a GET request to https://reqres.in/api/users/2
     and verify:
     The status code is 200 ;
     The content type is application/json; charset=utf-8
     The value of Header named Server is cloudflare
     The status line is HTTP/1.1 200 OK
     */

    // 1- End-point and request body
    String url ="https://reqres.in/api/users/2";

    // 2- Expected data

    // 3- Send request and save response

    Response response = given()
            .when()
            .get(url);

    // 4- Assertion
    @Test
    public void reqresAssert(){ //metadata -> from the headers

        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .header("Server","cloudflare")
                .statusLine("HTTP/1.1 200 OK");


    }

}
