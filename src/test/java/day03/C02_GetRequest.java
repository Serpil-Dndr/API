package day03;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C02_GetRequest {
     /*
    C02_GetRequest
***  TC02: Send a GET request to https://restful-booker.herokuapp.com/booking/10
     and verify:
     The status code is 200 ;
     The content type is application/json; Charset=utf-8
     The value of Header named Server is Cowboy
     The status line is HTTP/1.1 200 ok
     */

    // 1- End-point and Request body
    String url = "https://restful-booker.herokuapp.com/booking/10";
    // 2- Expected data

    // 3- send request and save response

    Response response = given()
            .when()
            .get(url);
    @Test
    public void printHerokuapp10(){
        System.out.println("Status code is: " +response.statusCode());
        System.out.println("Content type is: " +response.contentType());
        System.out.println("Server name is: "+ response.header("Server"));
        System.out.println("Status line is: "+response.statusLine());

    }

    // 4- Assertions

    @Test
    public void herokuappAssert(){

        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .header("Server","Cowboy")
                .statusLine("HTTP/1.1 200 OK");

    }

    @Test
    public void herokuappJunitAssert(){

        assertEquals(200,response.statusCode());
        assertEquals("application/json; charset=utf-8",response.contentType());
        assertEquals("Cowboy",response.header("Server"));
        assertEquals("HTTP/1.1 200 OK",response.statusLine());


    }


}
