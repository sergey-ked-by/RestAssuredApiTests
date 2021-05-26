import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pojos.UserRequest;
import pojos.CreateUserResponse;
import pojos.UserPojoFull;
import steps.UserSteps;
import utils.RestWrapper;
import utils.UserGenerator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class RestTest {

    private static RestWrapper api;

    @BeforeAll
    public static void prepareClient(){
        api = RestWrapper.loginAs("eve.holt@reqres.in", "cityslicka");
    }

    @Test
    public void getUsers(){
        List<UserPojoFull> users = UserSteps.getUsers();

        assertThat(api.user.getUsers()).extracting(UserPojoFull::getEmail).contains("george.bluth@reqres.in");
    }

    @Test
    public void createUser(){
        UserRequest request = UserGenerator.getSimpleUser();

        UserSteps userApi = new UserSteps();
        CreateUserResponse response = api.user.createUser(request);

        assertThat(response)
                .isNotNull()
                .extracting(CreateUserResponse::getName)
                .isEqualTo(request.getName());
    }
}
