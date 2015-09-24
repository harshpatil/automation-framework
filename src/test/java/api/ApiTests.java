package api;

import client.ApiClient;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ning.http.client.Response;
import com.sun.jersey.api.client.ClientResponse;
import model.request.CreateAccountRequest;
import model.request.Gender;
import model.request.UpdateAccountDetailRequest;
import model.response.CreateAccountResponse;
import model.response.GetAllUsers;
import model.response.GetUserDetails;
import model.response.UpdateAccountDetailsResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

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

    @Test()
    public void test_Get_UserDetails() throws Exception {

        String firstName = "abc";
        String lastName = "xyz";
        double mobileNumber = 9765148726l;
        double birthDate = 582012328000l;
        String address = "#123, ABC, Mumbai";
        String emailId = "patil.bmsce@gmail.com";
        Gender gender = Gender.FEMALE;

        // Create request body
        CreateAccountRequest createAccountRequest = new CreateAccountRequest();
        createAccountRequest.setFirstName(firstName);
        createAccountRequest.setLastName(lastName);
        createAccountRequest.setMobile(mobileNumber);
        createAccountRequest.setDateOfBirth(birthDate);
        createAccountRequest.setAddress(address);
        createAccountRequest.setEmailId(emailId);
        createAccountRequest.setGender(gender);

        // Make rest call to create account
        Response createResponse = createAccount(createAccountRequest);
        Assert.assertEquals(createResponse.getStatusCode(), 201);
        CreateAccountResponse createAccountResponse = new ObjectMapper().readValue(createResponse.getResponseBody(), CreateAccountResponse.class);

        String userId = createAccountResponse.getUserId();

        // Rest call to get user details
        Response getUser = getUserDetails(userId);
        Assert.assertEquals(getUser.getStatusCode(), 200);
        GetUserDetails getUserDetails = new ObjectMapper().readValue(getUser.getResponseBody(), GetUserDetails.class);

        // Validate response
        Assert.assertEquals(getUserDetails.getFirstName(), firstName);
        Assert.assertEquals(getUserDetails.getLastName(), lastName);
        Assert.assertEquals(getUserDetails.getMobile(), mobileNumber);
        Assert.assertEquals(getUserDetails.getDateOfBirth(), birthDate);
        Assert.assertEquals(getUserDetails.getAddress(), address);
        Assert.assertEquals(getUserDetails.getEmailId(), emailId);
        Assert.assertEquals(getUserDetails.getGender(), gender);
        Assert.assertNotNull(getUserDetails.getUserId());
    }

    @Test()
    public void test_Edit_UserDetails() throws Exception {

        String firstName = "MNO";
        String lastName = "QWE";
        double mobileNumber = 9765148726l;
        double birthDate = 582012328000l;
        String address = "#123, ABC, Delhi";
        String emailId = "patil.bmsce@gmail.com";
        Gender gender = Gender.FEMALE;

        // Create request body
        CreateAccountRequest createAccountRequest = new CreateAccountRequest();
        createAccountRequest.setFirstName(firstName);
        createAccountRequest.setLastName(lastName);
        createAccountRequest.setMobile(mobileNumber);
        createAccountRequest.setDateOfBirth(birthDate);
        createAccountRequest.setAddress(address);
        createAccountRequest.setEmailId(emailId);
        createAccountRequest.setGender(gender);

        // Make rest call to create account
        Response createResponse = createAccount(createAccountRequest);
        Assert.assertEquals(createResponse.getStatusCode(), 201);
        CreateAccountResponse createAccountResponse = new ObjectMapper().readValue(createResponse.getResponseBody(), CreateAccountResponse.class);

        String userId = createAccountResponse.getUserId();

        // Get details and validate
        Response getUser = getUserDetails(userId);
        Assert.assertEquals(getUser.getStatusCode(), 200);
        GetUserDetails getUserDetails = new ObjectMapper().readValue(getUser.getResponseBody(), GetUserDetails.class);

        // Validate response
        Assert.assertEquals(getUserDetails.getLastName(), lastName);
        Assert.assertEquals(getUserDetails.getMobile(), mobileNumber);

        // Set New values
        double newMobileNumber = 8888346573l;
        String newAddress = "#111, 5th Cross, Kolkata";

        UpdateAccountDetailRequest updateAccountDetailRequest = new UpdateAccountDetailRequest();
        updateAccountDetailRequest.setMobile(newMobileNumber);
        updateAccountDetailRequest.setAddress(newAddress);

        // Rest call to update details
        Response updateResponse = updateAccountDetails(userId, updateAccountDetailRequest);
        Assert.assertEquals(updateResponse.getStatusCode(), 200);
        UpdateAccountDetailsResponse updateAccountDetailsResponse = new ObjectMapper().readValue(updateResponse.getResponseBody(), UpdateAccountDetailsResponse.class);

        // Do get call and validate response
        getUser = getUserDetails(userId);
        Assert.assertEquals(getUser.getStatusCode(), 200);
        getUserDetails = new ObjectMapper().readValue(getUser.getResponseBody(), GetUserDetails.class);
        Assert.assertEquals(getUserDetails.getMobile(), newMobileNumber);
        Assert.assertEquals(getUserDetails.getAddress(), newAddress);
        Assert.assertEquals(getUserDetails.getFirstName(), firstName);
    }

    @Test()
    public void test_Get_List_Of_Users() throws Exception {

        String firstName = "abc";
        String lastName = "xyz";
        double mobileNumber = 9765148726l;
        double birthDate = 582012328000l;
        String address = "#123, ABC, Mumbai";
        String emailId = "patil.bmsce@gmail.com";
        Gender gender = Gender.FEMALE;

        // Create request body
        CreateAccountRequest createAccountRequest = new CreateAccountRequest();
        createAccountRequest.setFirstName(firstName);
        createAccountRequest.setLastName(lastName);
        createAccountRequest.setMobile(mobileNumber);
        createAccountRequest.setDateOfBirth(birthDate);
        createAccountRequest.setAddress(address);
        createAccountRequest.setEmailId(emailId);
        createAccountRequest.setGender(gender);

        // Make rest call to create account
        Response createResponse = createAccount(createAccountRequest);
        Assert.assertEquals(createResponse.getStatusCode(), 201);
        CreateAccountResponse createAccountResponse = new ObjectMapper().readValue(createResponse.getResponseBody(), CreateAccountResponse.class);

        // Rest call to get list of Users
        Response getUsers = getUsersList();
        Assert.assertEquals(getUsers.getStatusCode(), 200);
        List<GetUserDetails> getUserDetailsList = new ObjectMapper().readValue(getUsers.getResponseBody(), new TypeReference<List<GetUserDetails>>() {});

        // Validate response
        Assert.assertEquals(getUserDetailsList.get(0).getFirstName(), firstName);
        Assert.assertEquals(getUserDetailsList.get(0).getLastName(), lastName);
        Assert.assertEquals(getUserDetailsList.get(0).getUserId(), createAccountResponse.getUserId());
        Assert.assertNotNull(getUserDetailsList.get(1));
    }

    @Test()
    public void test_Get_All_Users() throws Exception {

        String firstName = "abc";
        String lastName = "xyz";
        double mobileNumber = 9765148726l;
        double birthDate = 582012328000l;
        String address = "#123, ABC, Mumbai";
        String emailId = "patil.bmsce@gmail.com";
        Gender gender = Gender.FEMALE;

        // Create request body
        CreateAccountRequest createAccountRequest = new CreateAccountRequest();
        createAccountRequest.setFirstName(firstName);
        createAccountRequest.setLastName(lastName);
        createAccountRequest.setMobile(mobileNumber);
        createAccountRequest.setDateOfBirth(birthDate);
        createAccountRequest.setAddress(address);
        createAccountRequest.setEmailId(emailId);
        createAccountRequest.setGender(gender);

        // Make rest call to create account
        Response createResponse = createAccount(createAccountRequest);
        Assert.assertEquals(createResponse.getStatusCode(), 201);

        int pageNo = 1;
        int pageSize = 10;

        // Rest call to get all the Users
        Response getUsers = getAllUsers(pageNo, pageSize);
        Assert.assertEquals(getUsers.getStatusCode(), 200);
        GetAllUsers getAllUsers = new ObjectMapper().readValue(getUsers.getResponseBody(), GetAllUsers.class);

        // Validate response
        Assert.assertNotNull(getAllUsers.getTotal());
        Assert.assertEquals(getAllUsers.getPageNo(), pageNo);
    }

}
