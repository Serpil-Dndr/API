package utilities;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.*;
import org.junit.Before;



public class BaseUrlSpec {
    protected RequestSpecification specReqresIn;
    protected  RequestSpecification specHerokuApp;

    @Before
    public void setUp(){

        specReqresIn = new RequestSpecBuilder().setBaseUri("https://reqres.in").build();
        specHerokuApp= new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").build();

    }

}
