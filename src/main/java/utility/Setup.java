package utility;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.PropertyNamingStrategy;

/**
 * Created with IntelliJ IDEA.
 * User: harshavardhan.p
 * Date: 11/09/15
 * Time: 2:03 AM
 * To change this template use File | Settings | File Templates.
 */
public class Setup {

    protected static ObjectMapper camelCaseToSnakeCaseMapper = new ObjectMapper();
    protected static ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.setVisibility(JsonMethod.FIELD, JsonAutoDetect.Visibility.ANY);
        camelCaseToSnakeCaseMapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
    }
}
