package apiautomationtest;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
public class LoginTest {
    String uri = "https://serverest.dev/login\n";

    @Test
    public void mustLoginSuccessfully(){
        given()
            .when()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"email\": \"fulano@qa.com\",\n" +
                        "  \"password\": \"teste\"\n" +
                        "}")
            .post(uri)
            .then()
                .statusCode(200);
    }

    @Test
    public void mustNotLoginSuccessfullyWhenLoginDataIsInvalid(){
        given()
                .when()
                    .contentType(ContentType.JSON)
                    .body("{\n" +
                        "  \"email\": \"fulana@qa.com\",\n" +
                        "  \"password\": \"teste\"\n" +
                        "}")
                .post(uri)
                .then()
                    .statusCode(401);
    }

    @Test
    public void mustNotLoginSuccessfullyWhenBodyIsEmpty(){
        given()
            .when()
                .contentType(ContentType.JSON)
                .body("")
            .post(uri)
            .then()
                .statusCode(400);
    }

}
