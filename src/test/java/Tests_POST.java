import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.junit.Ignore;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Tests_POST {

    @Test
    @Ignore
    public void test_01_POST() {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Iain");
        jsonObject.put("job", "Rabbit Whisperer");

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .body(jsonObject.toJSONString())
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .statusCode(201);
    }

    @Test
    public void test_02_PUT() {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Iain");
        jsonObject.put("job", "Rabbit Whisperer");

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .body(jsonObject.toJSONString())
                .when()
                .put("https://reqres.in/api/users/2")
                .then()
                .statusCode(200);
    }
}
