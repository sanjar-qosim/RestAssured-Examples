package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class PutPatchDelete {


    @Test
    public void testPut(){

        JSONObject request = new JSONObject();

        request.put("name", "Sanjar");
        request.put("job", "QA");

        baseURI = "https://reqres.in/api";

        given().
                header("Content-type", "application/json").
                body(request.toJSONString()).
        when().
                put("/users/2").
        then().
                statusCode(200).
                log().all();
    }


    @Test
    public void testPatch(){

        JSONObject request = new JSONObject();

        request.put("name", "Sanjar");
        request.put("job", "QA");

        baseURI = "https://reqres.in/api";

        given().
                header("Content-type", "application/json").
                body(request.toJSONString()).
        when().
                put("/users/2").
        then().
                statusCode(200).
                log().all();
    }


    @Test
    public void testDelete(){

        baseURI = "https://reqres.in/api";

        when().
                delete("/users/2").
        then().
                statusCode(204).
                log().all();

    }


}
