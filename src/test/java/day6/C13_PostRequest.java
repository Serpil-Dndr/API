package day6;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import utilities.BaseUrl;
import utilities.TestData;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static utilities.ApiCalls.createBookingData;

public class C13_PostRequest {
    @Test
    public void createBooking() {
        JSONObject expectedData = TestData.createBookingData();

        // System.out.println(TestData.createBookingData().toString());

        Response response = given().contentType("application/json; charset=utf-8")
                .when().body(expectedData.toString())
                .post(BaseUrl.createBookingUrl());

        response
                .then()
                .assertThat()
                .statusCode(200);

        response.prettyPrint();
        JsonPath actualData = response.jsonPath();

        Assert.assertEquals(expectedData.getString("firstname"), actualData.getString("booking.firstname"));
        Assert.assertEquals(expectedData.getString("lastname"), actualData.getString("booking.lastname"));
        Assert.assertEquals(expectedData.getInt("totalprice"), actualData.getInt("booking.totalprice"));
        Assert.assertEquals(expectedData.getBoolean("depositpaid"), actualData.getBoolean("booking.depositpaid"));

        // Assert objects in objects

        Assert.assertEquals(expectedData.getJSONObject("bookingdates").getString("checkin"),
                actualData.getString("booking.bookingdates.checkin"));

        Assert.assertEquals(expectedData.getJSONObject("bookingdates").getString("checkout"),
                actualData.getString("booking.bookingdates.checkout"));
    }

    @Test
    public void createBookingData01(){
        createBookingData(200,"ahmet",
                "sezgin",125, true,"wifi",
                "2023-07-25", "2023-07-30");
    }
    @Test
    public void createBookingWithHashMap() {  // It will be serialization because hashmap will be sent as body,
        // hashmap will turn into a json
        HashMap<String,Object> requestBody = TestData.postBookingDataHashMap();

        // System.out.println(TestData.createBookingData().toString());

        Response response = given()
                .contentType("application/json; charset=utf-8")

                .when()
                .body(requestBody) // it will be converted to json by Gson
                .post(BaseUrl.createBookingUrl());

        response
                .then()
                .assertThat()
                .statusCode(200);
        response.prettyPrint();

        //response.prettyPrint();
        JsonPath actualData = response.jsonPath();

        Assert.assertEquals(requestBody.get("firstname"), actualData.getString("booking.firstname"));
        Assert.assertEquals(requestBody.get("lastname"), actualData.getString("booking.lastname"));
        Assert.assertEquals(requestBody.get("totalprice"), actualData.getInt("booking.totalprice"));
        Assert.assertEquals(requestBody.get("depositpaid"), actualData.getBoolean("booking.depositpaid"));
        Assert.assertEquals(requestBody.get("additionalneeds"), actualData.getString("booking.additionalneeds"));


        HashMap<String,Object> bookingdates = (HashMap)requestBody.get("bookingdates");
        Assert.assertEquals(bookingdates.get("checkin"), actualData.getString("booking.bookingdates.checkin"));
        Assert.assertEquals(bookingdates.get("checkout"), actualData.getString("booking.bookingdates.checkout"));

    }
    @Test
    public void createBookingHashMap(){
        createBookingHashMap();
    }





}