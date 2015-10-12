package scripts;

import client.ApiClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ning.http.client.Response;
import model.response.GetUserDetails;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: harshavardhan.p
 * Date: 26/09/15
 * Time: 11:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class CSVReadWrite extends ApiClient {

    @Test()
    public void readFromCSVAndWriteOutputInANewCSVFile() throws Exception{

        String csvFile = "/Users/harshavardhan.p/Desktop/input.csv";
        BufferedReader bufferedReader = null;
        String line = "";
        String cvsSplitBy = ",";
        try {
            bufferedReader = new BufferedReader(new FileReader(csvFile));
            while ((line = bufferedReader.readLine()) != null) {

                // use comma as separator
                String[] field = line.split(cvsSplitBy);

                Response getUserDetailsResponse = getUserDetails(field[0]);
                Assert.assertEquals(getUserDetailsResponse.getStatusCode(), 200);
                GetUserDetails getUserDetails = new ObjectMapper().readValue(getUserDetailsResponse.getResponseBody(), GetUserDetails.class);

                System.out.println("User Id :::"+ getUserDetails.getUserId());

                // Write to a file
                PrintWriter out = new PrintWriter(new FileWriter("/Users/harshavardhan.p/Desktop/BASD3OfferDetails.csv", true));
                try{
                    out.write("\n");
                    out.write("User Id -> "+ getUserDetails.getUserId());
                    out.write("\n");
                    out.write("First Name -> "+ getUserDetails.getFirstName());
                    out.write("\n");
                    out.write("Last Name -> "+ getUserDetails.getLastName());
                    out.write("\n");
                }catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    out.flush();
                    out.close();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Done");
    }
}
