package model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import model.request.Gender;

/**
 * Created with IntelliJ IDEA.
 * User: harshavardhan.p
 * Date: 10/09/15
 * Time: 12:44 AM
 * To change this template use File | Settings | File Templates.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateAccountResponse {

    private String userId;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;
    private double mobile;
    private String address;
    private String emailId;
    private Gender gender;

    @JsonProperty("birthDate")
    private double dateOfBirth;
}
