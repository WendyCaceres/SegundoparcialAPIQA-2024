package testSuite;

import config.ApiProjectConfig;
import factoryRequest.FactoryRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

public class AuthProjectTest extends BasicAuthTest {
        @Test
        @DisplayName("Verify the create an user later a project - todo.ly")
        public void create4Projects() {

            for (int i = 1;i <=4;i++) {
                request.setUrl(ApiProjectConfig.CREATE_PROJECT);
                request.setHeaders(auth, valueAuth);

                body.put("Content", "Project "+i);

                request.setBody(body.toString());

                response = FactoryRequest.make("post").send(request);
                response.then().statusCode(200).body("Content", equalTo(body.get("Content")));
            }


        }

        @Test
        @DisplayName("Delete all project - todo.ly")
        public void deleteAllProject() {
            request.setUrl(ApiProjectConfig.READ_ALL_PROJECTS);



        }
}



