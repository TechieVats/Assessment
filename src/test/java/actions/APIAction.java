package actions;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import util.APIUtility;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class APIAction {

    APIUtility apiUtility = new APIUtility();
    Response response;
    JSONParser jsonParser = new JSONParser();
    FileReader fr;
    Object obj;
    private static final String PAYLOAD_PATH = System.getProperty("user.dir") + "/src/test/resources/payload/user.json";

    public void fetchingTheUserDetails(String endpoint) {
        apiUtility.setBaseURI();
        apiUtility.setHeaderAsContentType();
        response = apiUtility.apiGETCall(endpoint);
    }

    public void validatingTheStatusCode(Integer statusCode) {
        apiUtility.validatingStatusCode(response, statusCode);
    }

    public void validatingTheNoOfUserInResponse(int noOfUsers) {
        JsonPath path = response.jsonPath();
        List<String> id = path.get("id");
        assertThat(id.size()).isEqualTo(noOfUsers);
    }

    public void initializingBaseUri() {
        apiUtility.setBaseURI();
        apiUtility.setHeaderAsContentType();
    }

    public void getCallWithParams(String queryParam, String value, String endpoint) {
        apiUtility.setQueryParam(queryParam, value);
        response = apiUtility.apiGETCall(endpoint);
    }

    public void validatingTheNameInResponse(String name) {
        JsonPath path = response.jsonPath();
        List<String> responseAttribute = path.get("name");
        assertThat(responseAttribute.get(0)).isEqualTo(name);
    }

    public void addingANewUser(String endpoint) throws IOException, ParseException {
        fr = new FileReader(PAYLOAD_PATH);
        obj = jsonParser.parse(fr);
        apiUtility.setJsonBodyInRequest(obj.toString());
        response = apiUtility.createANewUser(endpoint);
    }

    public void userIsValidatingTheResponseForNewlyAddedUser() {
        assertThat(response.getBody().asString()).isEqualToIgnoringWhitespace(obj.toString());
    }
}
