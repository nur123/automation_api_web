package testrail;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Results {

  @JsonProperty("assignedto_id")
  private int assignedtoId;
  private String comment;
  @JsonProperty("created_by")
  private int createdBy;
  @JsonProperty("created_on")
  private String createdOn;
  private String defects;
  private String elapsed;
  private int id;
  @JsonProperty("status_id")
  private int statusId;
  @JsonProperty("test_id")
  private int testId;
  private String version;
}
