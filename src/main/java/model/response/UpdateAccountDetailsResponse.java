package model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * User: harshavardhan.p
 * Date: 25/09/15
 * Time: 2:21 AM
 * To change this template use File | Settings | File Templates.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateAccountDetailsResponse {

    private double mobile;
    private String address;
}
