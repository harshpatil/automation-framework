package model.request;

import lombok.Data;
import lombok.experimental.Builder;

/**
 * Created with IntelliJ IDEA.
 * User: harshavardhan.p
 * Date: 10/09/15
 * Time: 12:45 AM
 * To change this template use File | Settings | File Templates.
 */
@Data
@Builder
public class CreateAccountRequest {

    private String firstName;
    private String lastName;
    private double mobile;
    private String address;
    private String emailId;
    private Gender gender;
    private double dateOfBirth;

    public CreateAccountRequest(){

        this.firstName = "firstName";
        this.lastName = "lastName";
        this.address = "#123, 5th Cross, Wilson Garden, Bangalore";
        this.mobile = 1234567899l;
        this.emailId = "emailId@emailid.com";
        this.gender = Gender.MALE;
        this.dateOfBirth = 582012328000l;
    }

    public CreateAccountRequest(String firstName, String lastName, int mobile, String address, String emailId, Gender gender, double dateOfBirth){

        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.mobile = mobile;
        this.emailId = emailId;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }
}
