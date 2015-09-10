package utility;

import com.ning.http.client.Response;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import javax.ws.rs.core.MediaType;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: harshavardhan.p
 * Date: 10/09/15
 * Time: 2:14 AM
 * To change this template use File | Settings | File Templates.
 */
public class RestTestClient {

    public Response postMethod(String requestURL, String body) throws Exception {

        Client client = Client.create();
        WebResource webResource = client.resource(requestURL);
        Response response = null;
        System.out.println("Http request URL ::: " + requestURL);
        response = (Response)webResource.type(MediaType.APPLICATION_JSON_TYPE).post(Response.class, body);
        System.out.println("Http call response code ::: " + response.getStatusCode());
        return response;
    }

    public Response postMethod(String requestURL, HashMap<String, String> header, String body) throws Exception {

        Client client = Client.create();
        WebResource webResource = client.resource(requestURL);
        Response response = null;
        System.out.println("Http request URL ::: " + requestURL);

        for(String key : header.keySet()){
            System.out.println(key);
            response = (Response)((WebResource.Builder)webResource.header(key, header.get(key)).type(MediaType.APPLICATION_JSON_TYPE)).post(Response.class, body);
        }
        return response;
    }

    public Response getMethod(String requestURL) throws Exception {

        Client client = Client.create();
        WebResource webResource = client.resource(requestURL);
        Response response = null;
        System.out.println("Http request URL ::: " + requestURL);
        response = (Response)webResource.type(MediaType.APPLICATION_JSON_TYPE).get(Response.class);
        System.out.println("Http call response code ::: " + response.getStatusCode());
        return response;
    }

    public Response getMethod(String requestURL, HashMap<String, String> header) throws Exception {

        Client client = Client.create();
        WebResource webResource = client.resource(requestURL);
        Response response = null;
        System.out.println("Http request URL ::: " + requestURL);

        for(String key : header.keySet()){
            System.out.println(key);
            response = (Response)((WebResource.Builder)webResource.header(key, header.get(key)).type(MediaType.APPLICATION_JSON_TYPE)).get(Response.class);
        }
        return response;
    }

    public Response putMethod(String requestURL, String body) throws Exception {

        Client client = Client.create();
        WebResource webResource = client.resource(requestURL);
        Response response = null;
        System.out.println("Http request URL ::: " + requestURL);
        response = (Response)((WebResource.Builder)webResource.type(MediaType.APPLICATION_JSON_TYPE)).put(Response.class, body);
        return response;
    }

    public ClientResponse putMethod(String requestURL, HashMap<String, String> header, String body) throws Exception {

        Client client = Client.create();
        WebResource webResource = client.resource(requestURL);
        ClientResponse clientResponse = null;
        System.out.println("Http request URL ::: " + requestURL);

        for(String key : header.keySet()){
            System.out.println(key);
            clientResponse = (ClientResponse)((WebResource.Builder)webResource.header(key, header.get(key)).type(MediaType.APPLICATION_JSON_TYPE)).put(ClientResponse.class, body);
        }
        return clientResponse;
    }
}
