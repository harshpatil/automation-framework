package api;

import client.ApiClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ning.http.client.Response;
import com.sun.jersey.api.client.ClientResponse;
import model.request.CreateAccountRequest;
import model.request.Gender;
import model.response.CreateAccountResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * User: harshavardhan.p
 * Date: 10/09/15
 * Time: 12:39 AM
 * To change this template use File | Settings | File Templates.
 */
public class ApiTests extends ApiClient {

    @Test()
    public void test_Create_Account() throws Exception {

        String firstName = "Harsh";
        String lastName = "Patil";
        double mobileNumber = 9765148726l;
        double birthDate = 582012328000l;
        String address = "#123, ABC, Bangalore";
        String emailId = "patil.bmsce@gmail.com";
        Gender gender = Gender.MALE;

        // Create request body
        CreateAccountRequest createAccountRequest = new CreateAccountRequest();
        createAccountRequest.setFirstName(firstName);
        createAccountRequest.setLastName(lastName);
        createAccountRequest.setMobile(mobileNumber);
        createAccountRequest.setDateOfBirth(birthDate);
        createAccountRequest.setAddress(address);
        createAccountRequest.setEmailId(emailId);
        createAccountRequest.setGender(gender);

        // Make rest call
        Response response = createAccount(createAccountRequest);
        Assert.assertEquals(response.getStatusCode(), 201);
        CreateAccountResponse createAccountResponse = new ObjectMapper().readValue(response.getResponseBody(), CreateAccountResponse.class);

        // Validate response
        Assert.assertEquals(createAccountResponse.getFirstName(), firstName);
        Assert.assertEquals(createAccountResponse.getLastName(), lastName);
        Assert.assertEquals(createAccountResponse.getMobile(), mobileNumber);
        Assert.assertEquals(createAccountResponse.getDateOfBirth(), birthDate);
        Assert.assertEquals(createAccountResponse.getAddress(), address);
        Assert.assertEquals(createAccountResponse.getEmailId(), emailId);
        Assert.assertEquals(createAccountResponse.getGender(), gender);
        Assert.assertNotNull(createAccountResponse.getUserId());
    }

}
