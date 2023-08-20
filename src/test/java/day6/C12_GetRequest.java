package day6;

import com.google.gson.internal.bind.util.ISO8601Utils;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import utilities.ApiCalls;
import utilities.BaseUrl;
import utilities.TestData;

import static io.restassured.RestAssured.given;

public class C12_GetRequest {
    @Test
    public void bookingTestExpectedBodyJson() {
        JSONObject expectedData = TestData.getBookingDataJson();

        Response response = given()
                .when()
                .get(BaseUrl.herokuappuserId(7));
        JSONObject actualData = new JSONObject(response.getBody().asString());// json-->json

    }
    @Test
    public void bookingTestrequestBodyJson2(){

        ApiCalls.serilizationBooking(303,200,"Josh","Allen",111,true,"2018-01-01","2019-01-01" );
        //ApiCalls.serilizationBooking(793,200,"John","Smith",111,true,"2018-01-01","2019-01-01" );


    }

}