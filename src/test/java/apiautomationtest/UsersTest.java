package apiautomationtest;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class UsersTest {

    String uri = "https://serverest.dev/usuarios";

    @Test
    public void mustListAllUsers() {
        given()
            .when()
                .contentType(ContentType.JSON)
            .get(uri)
            .then()
                .statusCode(200);
    }

    @Test
    public void mustListUserByID() {
        given()
                .when()
                .contentType(ContentType.JSON)
                .queryParam("_id", "0uxuPY0cbmQhpEz1")
                .get(uri)
                .then()
                .statusCode(200);
    }

    @Test
    public void mustListUserByName() {
        given()
                .when()
                .contentType(ContentType.JSON)
                .queryParam("nome", "Fulano da Silva")
                .get(uri)
                .then()
                .statusCode(200);
    }

    @Test
    public void mustListUserByEmail() {
        given()
                .when()
                .contentType(ContentType.JSON)
                .queryParam("email", "fulano@qa.com")
                .get(uri)
                .then()
                .statusCode(200);
    }

    @Test
    public void mustListUserByPassword() {
        given()
                .when()
                .contentType(ContentType.JSON)
                .queryParam("password", "teste")
                .get(uri)
                .then()
                .statusCode(200);
    }

    @Test
    public void mustListUserByAdministrador() {
        given()
                .when()
                .contentType(ContentType.JSON)
                .queryParam("administrador", true)
                .get(uri)
                .then()
                .statusCode(200);
    }

}


