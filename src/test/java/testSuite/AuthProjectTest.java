package testSuite;

import com.sun.net.httpserver.Request;
import config.ApiProjectConfig;
import factoryRequest.FactoryRequest;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Base64;
import static org.hamcrest.Matchers.equalTo;

public class AuthProjectTest extends BasicTest {
    @Test
    @DisplayName("Create a user, project, delete the user, try to create a project again")
    public void createUserProjectDeleteUser(){
        createUser();

        JSONObject projectBody = new JSONObject();
        projectBody.put("Content", "Test Project");

        request.setUrl(ApiProjectConfig.CREATE_PROJECT)
                .setHeaders(auth, valueAuth)
                .setBody(projectBody.toString());

        Response projectResponse = FactoryRequest.make("post").send(request);
        projectResponse.then().statusCode(200)
                .body("Content", equalTo("Test Project"));

        deleteUser();

        request.setUrl(ApiProjectConfig.CREATE_PROJECT)
                .setHeaders(auth, valueAuth)
                .setBody(projectBody.toString());

        projectResponse = FactoryRequest.make("post").send(request);
        projectResponse.then().statusCode(200)
                .body("ErrorMessage", equalTo("Account does not exist"))
                .body("Status", equalTo(404));

    }

    public void createUser(){
        JSONObject userBody = new JSONObject();
        userBody.put("Email", "examen2@gmail.com");
        userBody.put("Password", "123456");
        userBody.put("FullName", "Wendy");
    }

}
