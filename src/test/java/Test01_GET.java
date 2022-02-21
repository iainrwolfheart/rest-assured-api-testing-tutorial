import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Test01_GET {

    @Test
    public void test_01() {
        Response res = RestAssured.get("https://reqres.in/api/users?page=2");
        int statusCode = res.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }

    @Test
    public void test_02() {
        given()
            .get("https://reqres.in/api/users?page=2")
        .then()
            .statusCode(200);
    }

    @Test
    public void test_03() {
        given()
                .get("https://reqres.in/api/users?page=2")
        .then()
                .statusCode(200)
                .body("data.id[0]", equalTo(7));
    }
}
