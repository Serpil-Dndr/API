package day04;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.w3c.dom.CDATASection;
import utilities.BaseUrlSpec;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.request;


public class C01_GetRequest extends BaseUrlSpec {


        @Test
        public void getReqresAll () {

        /*
         *** TC07:Send a GET Request to https://reqres.in/api/users
              and verify:
              The status code is 200
              The content type is application/json; charset=utf-8
              Verify that the following exists in data
              email is tracey.ramos@reqres.in
              first_name is Tracey
              last_name is Ramos
              avatar is https://reqres.in/img/faces/6-image.jpg

             {
                "id": 6,
                "email": "tracey.ramos@reqres.in",
                "first_name": "Tracey",
                "last_name": "Ramos",
                "avatar": "https://reqres.in/img/faces/6-image.jpg"
             }

         */

            // 1- End-point and request body

            specReqresIn.pathParams("pp1", "api", "pp2", "users");

            // 2- Expected data

            // 3- Send the request and save the response

            Response response = given().spec(specReqresIn)
                    .when()
                    .get("/{pp1}/{pp2}");


            // 4- Assertions

            response
                    .then()
                    .statusCode(200)
                    .contentType("application/json; charset=utf-8")
                    .body("data[5].id",Matchers.equalTo(6),
                      "data[5].first_name",Matchers.equalTo("Tracey"),
                            "data[5].last_name",Matchers.equalTo("Ramos"),
                            "data[5].avatar",Matchers.equalTo("https://reqres.in/img/faces/6-image.jpg"));


        }


        @Test
        public void getBooking () {
        /*
        *** TC08:Send a GET Request to https://restful-booker.herokuapp.com/booking/433
     and verify:
     The status code is 200
     The content type is application/json; Charset=utf-8
     firstname is John
     lastname is Smith
     totalprice is 111
     depositpaid is true
     bookingdates (checkin) is 2018-01-01
     bookingdates (checout) is 2019-01-01

        *  {
       "firstname": "Jane",
       "lastname": "Smith",
       "totalprice": 111,
       "depositpaid": true,
       "bookingdates": {
           "checkin": "2018-01-01",
           "checkout": "2019-01-01"
       },
       "additionalneeds": "Extra pillows please"
   }


         */
            //1. end point


  specHerokuApp.pathParams("pp1","booking","pp2","100");
  //
            Response response = given().spec(specHerokuApp)
                    .when()
                    .get("/{pp1}/{pp2}");
            //Assertion
            response
                    .then()
                    .statusCode(200)
                    .contentType("application/json; Charset=utf-8")
                    .body("firstname",Matchers.equalTo("John"),
                            "lastname",Matchers.equalTo("Smith"),
                            "depositpaid",Matchers.equalTo(true),
                            "bookingdates.checkin",Matchers.equalTo("2018-01-01"),
                            "bookingdates.checkout",Matchers.equalTo("2019-01-01"));




        }

    }

