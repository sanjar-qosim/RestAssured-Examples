package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetAndPostExamples {

    @Test
    public void testGet(){

        baseURI = "https://reqres.in/api";

        given().
                get("users?page=2").
        then().
                statusCode(200).
                body("data[4].first_name", equalTo("George")).
                body("data.first_name", hasItems("George", "Rachel"));

    }

    @Test
    public void testPost(){

        Map<String, Object> map = new HashMap<String, Object>();

//        map.put("name", "Sanjar");
//        map.put("job", "QA");

//        System.out.println(map);

        JSONObject request = new JSONObject(map);

        request.put("name", "Sanjar");
        request.put("job", "QA");

        System.out.println(request.toJSONString());


        baseURI = "https://reqres.in/api";

        given().
                header("Content-type", "application/json").
                body(request.toJSONString()).
                when().
                post("/users").
                then().
                statusCode(201).
                log().all();


    }


}
