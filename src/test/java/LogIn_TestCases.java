import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.json.JSONException;
import org.json.simple.JSONObject;
import org.junit.Test;
import org.testng.Assert;

public class LogIn_TestCases {

    @Test()
    public void test_whenUserInsertValidCredentials_IsAllowedToLogin() throws JSONException {
        JSONObject requestParameters = new JSONObject();
        requestParameters.put("customerNumber", "19501580");
        requestParameters.put("password", "qwertytest2022");

        HttpResponse<String> response = Unirest.post("https://api.sa-tech.de/static/auth/v1/com/login")
                .header("charset", "UTF-8")
                .header("Content-Type", "application/json")
                .body(requestParameters)
                .asString();

        Assert.assertEquals(response.getStatus(), 201);
    }
    @Test()
    public void test_whenUserInsertInvalidCredentials_IsNOTAllowedToLogin() throws JSONException {
        JSONObject requestParameters = new JSONObject();
        requestParameters.put("customerNumber", "19501580");
        requestParameters.put("password", "");

        HttpResponse<String> response = Unirest.post("https://api.sa-tech.de/static/auth/v1/com/login")
                .header("charset", "UTF-8")
                .header("Content-Type", "application/json")
                .body(requestParameters)
                .asString();

        Assert.assertEquals(response.getStatus(), 400);
    }
}
