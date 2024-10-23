package testSuite;

import config.ApiUserConfig;
import factoryRequest.RequestInfo;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.Base64;

public class BasicAuthTest {
    public RequestInfo request = new RequestInfo();
    public Response response;
    public String auth = "";
    public String valueAuth = "";
    public JSONObject body = new JSONObject();

    @BeforeEach

    public void before() {
        body.put("Email", ApiUserConfig.user);
        body.put("FullName", "Wendy");
        body.put("Password", ApiUserConfig.pwd);

        auth = "Authorization";
        valueAuth = "Basic " + Base64.getEncoder().encodeToString((ApiUserConfig.user+":"+ApiUserConfig.pwd).getBytes());
    }

    @AfterEach
    public void after() {

    }

}
