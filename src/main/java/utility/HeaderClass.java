package utility;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: harshavardhan.p
 * Date: 11/09/15
 * Time: 1:58 AM
 * To change this template use File | Settings | File Templates.
 */
public class HeaderClass {

    public static final String CONTENT_TYPE = "Content-Type";
    public static final String APPLICATION_JSON = "application/json";
    public static final String USER_ID = "userId";
    public static final String UNIQUE_ID = "f81d4fae-7dec-11d0-a765-00a0c91e6bf6";

    public static HashMap<String, String> defaultHeader() {

        HashMap<String, String> headers = new HashMap<String, String>();
        headers.put(CONTENT_TYPE, APPLICATION_JSON);
        return headers;
    }

    public static HashMap<String, String> userHeader() {

        HashMap<String, String> headers = new HashMap<String, String>();
        headers.put(USER_ID, UNIQUE_ID);
        return headers;
    }
}
