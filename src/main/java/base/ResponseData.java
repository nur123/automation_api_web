package base;

import io.restassured.response.Response;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseData<T> {
    private T responseBody;
    private Response response;
}
