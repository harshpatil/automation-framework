package model.request;

import lombok.Data;
import lombok.experimental.Builder;

/**
 * Created with IntelliJ IDEA.
 * User: harshavardhan.p
 * Date: 25/09/15
 * Time: 2:11 AM
 * To change this template use File | Settings | File Templates.
 */
@Data
@Builder
public class UpdateAccountDetailRequest {

    private double mobile;
    private String address;

    public UpdateAccountDetailRequest(){

        this.mobile = 4387629548376l;
        this.address = null;
    }

    public UpdateAccountDetailRequest(double mobile, String address){

        this.mobile = mobile;
        this.address = address;
    }

}
