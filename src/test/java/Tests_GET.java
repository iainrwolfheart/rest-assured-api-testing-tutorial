import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.junit.Ignore;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class Tests_GET {

    @Test
    @Ignore
    public void test_01() {
        given()
                .header("Content-Type", "application/json")
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .body("data.id[1]", equalTo(8))
                .body("data.first_name", hasItems("Michael", "Lindsay"))
                .log().all();
    }

    @Test
    @Ignore
    public void testJsonServerGet() {
        baseURI = "http://localhost:3000/"; //JSON Server serving our db.json

        given()
                .param("name", "Automation")
                .get("/subjects")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void testJsonServerPost() {
        baseURI = "http://localhost:3000/"; //JSON Server serving our db.json
        JSONObject postReq = new JSONObject();
        postReq.put("firstName", "D.O.");
        postReq.put("lastName", "C.");
        postReq.put("subjectId", "1");

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(postReq.toJSONString())
            .when()
                .post("/users")
            .then()
                .statusCode(201)
                .log().all();
    }

    @Test
    public void testJsonServerPatch() {
        baseURI = "http://localhost:3000/"; //JSON Server serving our db.json
        JSONObject postReq = new JSONObject();
        postReq.put("firstName", "Marshall");
        postReq.put("lastName", "Mathers");

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(postReq.toJSONString())
                .when()
                .patch("/users/4")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void testJsonServerDelete() {
        baseURI = "http://localhost:3000/"; //JSON Server serving our db.json

        when()
                .delete("/users/4")
            .then()
                .statusCode(200);
    }
}
