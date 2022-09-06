package objects;

import com.fasterxml.jackson.core.JsonProcessingException;
import helpers.CleanObject;
import io.cucumber.datatable.DataTable;
import models.request.AddPostRequestModel;

import java.util.HashMap;
import java.util.Map;

public class AddPostRequestbody {

    public static Map<String, String> body = new HashMap<String, String>();
    public static AddPostRequestModel addPostRequestModel = new AddPostRequestModel();




    public static String getBody() throws JsonProcessingException {
        addPostRequestModel.title = body.get("title");
        addPostRequestModel.body = body.get("body");
        addPostRequestModel.userId = body.get("userId");
        return CleanObject.getCleanObject(addPostRequestModel);
    }

    public static String getBody(String userId) throws JsonProcessingException {
        addPostRequestModel.title = body.get("title");
        addPostRequestModel.body = body.get("body");
        addPostRequestModel.userId = userId;
        return CleanObject.getCleanObject(addPostRequestModel);
    }

    public static void generatePayload(DataTable payload) {
        for (Map<Object, Object> data : payload.asMaps(String.class, String.class)) {
            body.put((String) data.get("payLoadKey"), (String) data.get("payLoadValue"));
        }
    }



}
