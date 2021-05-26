package steps;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import pojos.UserRequest;
import pojos.CreateUserResponse;
import pojos.UserPojoFull;

import java.util.List;

import static io.restassured.RestAssured.given;

public class UserSteps {
    private static final RequestSpecification REQUEST_SPECIFICATION =
            new RequestSpecBuilder()
                    .setBaseUri("https://reqres.in/api")
                    .setBasePath("/users")
                    .setContentType(ContentType.JSON)
                    .build();

    private CreateUserResponse user;
    public CreateUserResponse createUser(UserRequest request){
        user = given()
                .spec(REQUEST_SPECIFICATION)
                .body(request)
                .when().post()
                .then().extract()
                .as(CreateUserResponse.class);
        return user;
    }

    public UserPojoFull getUser(){
        return given().get("/" + user.getId()).as(UserPojoFull.class);
    }

    public static List<UserPojoFull> getUsers() {
        return given()
                .spec(REQUEST_SPECIFICATION)
                .get()
                .jsonPath().getList("data", UserPojoFull.class);
    }
}
