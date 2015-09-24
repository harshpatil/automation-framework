package model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: harshavardhan.p
 * Date: 25/09/15
 * Time: 2:37 AM
 * To change this template use File | Settings | File Templates.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetAllUsers {

    private int total;
    private int pageNo;
    private List<GetUserDetails> users = new ArrayList<GetUserDetails>();
}
