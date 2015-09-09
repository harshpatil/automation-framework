package api;

import client.ApiClient;
import model.request.CreateAccountRequest;
import model.request.Gender;
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

        CreateAccountRequest.builder().firstName("Harsh").lastName("Patil").address("#123, ABC, Bangalore").emailId("patil.bmsce@gmail.com").dateOfBirth(582012328000l).gender(Gender.MALE).mobile(9765148726l).build();
    }

}
