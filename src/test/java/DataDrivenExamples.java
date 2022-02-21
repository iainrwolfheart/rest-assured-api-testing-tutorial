import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

@RunWith(Parameterized.class)
public class DataDrivenExamples {

    private String firstName;
    private String lastName;
    private int subjectId;

    public DataDrivenExamples(String firstName, String lastName, int subjectId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.subjectId = subjectId;
    }

    @Parameterized.Parameters
    public static Collection dataForPost() {
        return Arrays.asList(new Object[][] {
                {
                    "Marshall",
                    "Mathers",
                    1
                },
                {
                    "Snoop",
                    "Dogg",
                    2
                }
        });
    }

    @Test
    public void testJsonServerPost() {
        baseURI = "http://localhost:3000/"; //JSON Server serving our db.json

        JSONObject postReq = new JSONObject();
        postReq.put("firstName", firstName);
        postReq.put("lastName", lastName);
        postReq.put("subjectId", subjectId);

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
}
