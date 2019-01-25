import com.example.model.UserPayload;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.isEmptyString;

public class UserAPITests {


    @BeforeAll
    static void setUp() {
        RestAssured.baseURI = "http://139.59.130.228";
    }
//https://www.tutorialspoint.com/gradle/gradle_installation.htm
    @Test
    void testCanRegisterUser() {
        UserPayload user = new UserPayload()
                .setUsername("grg")
                .setPassword("rr111")
                .setEmail("rr@fff.com");

        RestAssured
                .given().contentType(ContentType.JSON).log().all()
                .body(user)
                .when()
                .post("register")
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .body("id", not(isEmptyString()));
    }
}
