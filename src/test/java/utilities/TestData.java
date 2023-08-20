package utilities;

import org.json.JSONObject;

import java.util.HashMap;

public class TestData {

    public static HashMap<String, Object> getBookingData(){
  /*
  {
    "firstname" : "Jim",
    "lastname" : "Brown",
    "totalprice" : 111,
    "depositpaid" : true,
    "bookingdates" : {
        "checkin" : "2018-01-01",
        "checkout" : "2019-01-01"
    },
    "additionalneeds" : "Breakfast"
}
   */
        HashMap<String, Object> expectedData = new HashMap<>();
        HashMap<String, Object> bookingDates = new HashMap<>();
        bookingDates.put("checkin","2018-01-01");
        bookingDates.put("checkout","2019-01-01");
        expectedData.put("firstname", "Josh");
        expectedData.put("lastname", "Allen");
        expectedData.put("totalprice", 111.0);
        expectedData.put("depositpaid", true);
        expectedData.put("additionalneeds", "super bowls");
        expectedData.put("bookingdates",bookingDates);
        return expectedData;
    }

    public static JSONObject getBookingDataJson() {

        JSONObject expectedData = new JSONObject();
        JSONObject bookingdates= new JSONObject();
        bookingdates.put("checkin","2018-01-01");
        bookingdates.put("checkout","2019-01-01");

        expectedData.put("firstname","John");
        expectedData.put("lastname","Smith");
        expectedData.put("totalprice",111);
        expectedData.put("depositpaid",true);
        expectedData.put("bookingdates",bookingdates);


        return expectedData;
    }

    public static JSONObject createBookingData() {
        JSONObject expectedData = new JSONObject();
        JSONObject bookingdates = new JSONObject();

        bookingdates.put("checkin", "2018-01-01");
        bookingdates.put("checkout", "2019-01-01");

        expectedData.put("firstname", "John");
        expectedData.put("lastname", "Smith");
        expectedData.put("totalprice", 111);
        expectedData.put("depositpaid", true);
        expectedData.put("bookingdates", bookingdates);

        return expectedData;

    }

    public static HashMap<String, Object> postBookingDataHashMap() {

        HashMap<String, Object> expectedHashMap = new HashMap<>();
        HashMap<String, Object> bookingDates = new HashMap<>();
        bookingDates.put("checkin","2018-01-01");
        bookingDates.put("checkout","2019-01-01");
        expectedHashMap.put("firstname", "Josh");
        expectedHashMap.put("lastname", "Allen");
        expectedHashMap.put("totalprice", 111.0);
        expectedHashMap.put("depositpaid", true);
        expectedHashMap.put("additionalneeds", "super bowls");
        expectedHashMap.put("bookingdates",bookingDates);
        return expectedHashMap;
    }
    }

