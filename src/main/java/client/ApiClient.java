package client;

import com.ning.http.client.Response;
import com.sun.jersey.api.client.ClientResponse;
import model.request.CreateAccountRequest;
import utility.HeaderClass;
import utility.RestTestClient;
import utility.Setup;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: harshavardhan.p
 * Date: 10/09/15
 * Time: 12:43 AM
 * To change this template use File | Settings | File Templates.
 */
public class ApiClient extends Setup {

    RestTestClient restTestClient = new RestTestClient();

    public Response createAccount(CreateAccountRequest createAccountRequest) throws Exception {

        String url = "http://localhost:80/socialNetwork/createAccount";
        HashMap<String, String> headers = HeaderClass.defaultHeader();
        String body = objectMapper.writeValueAsString(createAccountRequest);
        System.out.println("Request Body ::: "+ body);
        Response response = restTestClient.postMethod(url, body);
        return response;
    }
}
