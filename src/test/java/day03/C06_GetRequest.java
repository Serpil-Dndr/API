//package day03;
//
//import io.restassured.response.Response;
//import org.hamcrest.Matchers;
//import org.junit.Test;
//impo
//import static io.restassured.RestAssured.given;
//import static org.hamcrest.Matchers.equalTo;
//public class C06_GetRequest {
//      /*
//
//    *** TC07:Send a GET Request to https://reqres.in/api/users/6
//              and verify:
//              The status code is 200
//              The content type is application/json; charset=utf-8
//              email is tracey.ramos@reqres.in
//              first_name is Tracey
//              last_name is Ramos
//              avatar is https://reqres.in/img/faces/6-image.jpg
//
//             {
//                "id": 6,
//                "email": "tracey.ramos@reqres.in",
//                "first_name": "Tracey",
//                "last_name": "Ramos",
//                "avatar": "https://reqres.in/img/faces/6-image.jpg"
//             }
//
//     */
//
//
//    @Test
//
//    public void getRegres(){
//        // 1- End-point and request body
//        specReqresIn.pathParams("pp1","api","pp2","users","pp3","6");
//
//        // 2- Expected data
//
//        // 3- Send request and save response
//
//        Response response = given()
//                .spec(specReqresIn)
//                .when()
//                .get("/{pp1}/{pp2}/{pp3}");
//
//        // 4- Assertion
//
//        response.then()
//                //.assertThat() this is optional
//                .statusCode(200)
//                .contentType("application/json; charset=utf-8")
//                .body("data.email", equalTo("tracey.ramos@reqres.in"),
//                        "data.first_name",equalTo("Tracey"),
//                        "data.last_name",equalTo("Ramos"),
//                        "data.avatar",equalTo("https://reqres.in/img/faces/6-image.jpg"));
//
//
//
//
//    }
//
//}
