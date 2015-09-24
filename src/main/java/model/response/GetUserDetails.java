package model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import model.request.Gender;

/**
 * Created with IntelliJ IDEA.
 * User: harshavardhan.p
 * Date: 25/09/15
 * Time: 2:02 AM
 * To change this template use File | Settings | File Templates.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetUserDetails {

    private String userId;
    private String firstName;
    private String lastName;
    private double mobile;
    private String address;
    private String emailId;
    private Gender gender;
    private double dateOfBirth;
}
