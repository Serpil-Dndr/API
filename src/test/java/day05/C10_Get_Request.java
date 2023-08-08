package day05;

import org.junit.Test;
import utilities.ApiCalls;

import static utilities.ApiCalls.*;

public class C10_Get_Request {

    @Test
    public void id5ExistRegresIn(){
//        ApiCalls.checkUserExistWithId(5,200,
//                "charles.morris@reqres.in",
//                "Charles","Morris");
        ApiCalls.checkUserExistsWithId(5,200,"charles.morris@reqres.in","Charles","Morris");

    }
    @Test
    public void id2ExistInReqresIn(){

        ApiCalls.checkUserExistsWithId(2,200,"janet.weaver@reqres.in","Janet","Weaver");

    }
    @Test
    public void nameExistReqresIn(){
       allNamesListReqresIn(200, "Emma");
    }
    @Test
    public void id10ExistInReqresIn(){
        checkUserExistWithIdJsonPath(10,200,"byron.fields@reqres.in","Byron","Fields");

    }
    @Test

    public void idHerokuapp(){

      checkUserWithIdHerokuapp(510,
                200,
                "John",
                "Smith",
                true,
                111,
                "2018-01-01",
                "2019-01-01");
    }

}
