package day05;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import utilities.BaseUrl;

import static io.restassured.RestAssured.given;
import static utilities.BaseUrl.*;

public class C09_GetRequest {
    Response response = given()
             . when ()
            .get(regresInUser());
    JsonPath jsonPath = response.jsonPath();

    @Test
    public void nameExistingRegresIn(){
        response.then()
          .assertThat()
          .statusCode(200)
          .contentType("application/json");
        System.out.println(jsonPath.getList("data.first_name"));


        Assert.assertTrue(jsonPath.getList("data.first_name").contains("Janet"));

    }
    @Test
    public void emailExistingInRegresIn(){
        response.then()
                .assertThat()
                .statusCode(200);
    }
    @Test
    public void supportRegresInText(){
        Assert.assertEquals("To keep ReqRes free, contributions towards server costs are appreciated!",jsonPath.getString("support.text"));
    }
}
