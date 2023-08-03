package day03;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
public class C05_GetRequest {
      /*
    C05_GetRequest
*** TC06:Send a GET Request to https://reqres.in/api/users/1
             and verify:
             The status code is 200
             The content type is application/json; Charset=utf-8
             email is george.bluth@reqres.in
             first_name is George
             last_name is Bluth
             avatar is https://reqres.in/img/faces/1-image.jpg
             url is https://reqres.in/#support-heading
             text is To keep ReqRes free, contributions towards server costs are appreciated!
     */

    // 1- End-point and request body

    String url = "https://reqres.in/api/users/1";

    // 2- Expected data

    // 3- Send the request and save the response

    Response response = given()
            .when()
            .get(url);

    // 4- Assertion

    @Test
    public void getReqresIn(){

        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .body("data.email", equalTo("george.bluth@reqres.in"),
                        "data.first_name",equalTo("George"),
                        "data.last_name",equalTo("Bluth"),
                        "data.avatar",equalTo("https://reqres.in/img/faces/1-image.jpg"),
                        "support.url",equalTo("https://reqres.in/#support-heading"),
                        "support.text",equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));



    }
}
