package testSuite;

import com.sun.net.httpserver.Request;
import config.ApiUserConfig;
import factoryRequest.RequestInfo;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class BasicTest {
    public Request request = new  Request;
    public Response response;
    public String auth = "";
    public String valueAuth = "";
    public JSONObject body = new JSONObject();

    @BeforeEach

    public void before() {
        body.put("Email", ApiUserConfig.user);
        body.put("Password", ApiUserConfig.pwd);
        body.put("FullName", "Wendy");

        auth = "Authorization";
        valueAuth = "Basic " + Base64.getEncoder().encodeToString((ApiUserConfig.user+":"+ApiUserConfig.pwd).getBytes()).getBytes();
    }

    @AfterEach
    public void after() {

    }

}
