package testSuite;

import config.ApiProjectConfig;
import config.ApiUserConfig;
import factoryRequest.FactoryRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.equalTo;

public class UserProjectTest extends BasicAuthTest{
    @Test
    @DisplayName("Verify the create an user later a project")
    public void createUserAndProject() {
        //Create User
        request.setUrl(ApiUserConfig.CREATE_USER);
        request.setBody(body.toString());

        response = FactoryRequest.make("post").send(request);
        response.then().statusCode(200).body("FullName",equalTo(body.get("FullName")));

        request.setUrl(ApiProjectConfig.CREATE_PROJECT);
        request.setHeaders(auth, valueAuth);

        body.put("Content","Hellow World");
        request.setBody(body.toString());

        response = FactoryRequest.make("post").send(request);
        response.then().statusCode(200).body("Content",equalTo(body.get("Content")));



    }

    @Test
    @DisplayName("Verify the delete an user later create a project - todo.ly")
    public void deleteUserAndCreateProject(){
        request.setUrl(ApiUserConfig.READ_USER);
        request.setHeaders(auth, valueAuth);
        response = FactoryRequest.make("get").send(request);
        response.then().statusCode(200).body("FullName",equalTo(body.get("FullName")));
        String userId = response.then().extract().path("Id")+"";


        request.setUrl(ApiUserConfig.DELETE_USER.replace("{id}",userId));
        response = FactoryRequest.make("delete").send(request);
        response.then().statusCode(200).body("FullName",equalTo(body.get("FullName")));


        request.setUrl(ApiProjectConfig.CREATE_PROJECT);

        body.put("Content","holaa");
        request.setBody(body.toString());

        response = FactoryRequest.make("post").send(request);
        response.then().statusCode(200).body("ErrorMessage",equalTo("Account doesn't exist"));

    }
}
