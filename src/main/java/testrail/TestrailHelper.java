package testrail;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.Base64;

public class TestrailHelper {

  private static String TESTRAIL_URL = "https://muhammadnur.testrail.io/index.php?/api/v2";
  private static String ADD_RESULT_FOR_CASE = "/add_result_for_case/{run_id}/{case_id}";
  private static String TESTRAIL_USERNAME = "muhammad.nur@ottodigital.id";
  private static String TESTRAIL_PASSWORD = "SaBOOztkzNe588KFm.FS-BOEJf/I1E5034mYJxmDh";

  public void updateTestCase(String caseIdString, int runId, Status status) {
      Integer caseId = Integer.parseInt(caseIdString.replace("C", ""));
      ResultsRequest resultsRequest = ResultsRequest.builder().status(status.getId()).build();
      Results results = addResultForCase(resultsRequest, runId, caseId);
  }

  public Results addResultForCase(ResultsRequest resultsRequest, int runId, int caseId) {
    Response response = testRail()
        .pathParam("run_id", runId)
        .pathParam("case_id", caseId)
        .body(mapObject(resultsRequest))
        .post(testRailUrl(ADD_RESULT_FOR_CASE));
    return response.getBody().as(Results.class);
  }

  protected RequestSpecification testRail() {
    return RestAssured.given()
        .header("Authorization", "Basic " + getTestrailToken())
        .header("Content-Type", "application/json");
  }

  protected String mapObject(Object requestObject) {
    ObjectMapper mapper = new ObjectMapper();
    mapper.setSerializationInclusion(Include.NON_NULL);
    String dtoAsString = null;
    try {
      dtoAsString = mapper.writeValueAsString(requestObject);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return dtoAsString;
  }

  protected String testRailUrl(String endpoint) {
    return TESTRAIL_URL + endpoint;
  }

  private String getTestrailToken() {
    String secret = TESTRAIL_USERNAME + ":" + TESTRAIL_PASSWORD;
    return Base64.getEncoder().encodeToString(secret.getBytes());
  }

}
