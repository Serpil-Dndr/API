package day03;
import org.junit.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class C04_GetRequest {

/*

C04_GetRequest (we started to use Matchers Class to verify all data within json body)
*** TC04:Send a GET Request to https://restful-booker.herokuapp.com/booking/125
    and verify:
    The status code is 200
    The content type is application/json; Charset=utf-8
    firstname is John
    lastname is Smith
    totalprice is 111
    depositpaid is true
    bookingdates (checkin) is 2018-01-01
    bookingdates (checout) is 2019-01-01
 */

    // 1- End-point and request body
    String url = "https://restful-booker.herokuapp.com/booking/125";

    // 2- Expected data

    // 3- Send the request and save the response

    Response response = given()
            .when()
            .get(url);


    // 4- Assertion

    @Test
    public void getHeroku125(){

        response
                .then()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .body("firstname", equalTo("Josh"),
                        "lastname", equalTo("Allen"),
                        "totalprice", equalTo(111),
                        "depositpaid",equalTo(true),
                        "bookingdates.checkin",equalTo("2018-01-01"),
                        "bookingdates.checkout",equalTo("2019-01-01"));

    }

}
