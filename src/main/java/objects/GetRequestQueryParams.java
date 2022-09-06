package objects;

import io.cucumber.datatable.DataTable;

import java.util.HashMap;
import java.util.Map;

public class GetRequestQueryParams {
    public static Map<String, String> queryParams;


    public static Map<String, String> getQueryParams() {
        return queryParams;
    }


    public static void createQueryParamsForGetRequest(DataTable queryParameters){
        queryParams = new HashMap<String, String>();
        for (Map<Object, Object> data : queryParameters.asMaps(String.class, String.class)) {
            queryParams.put((String) data.get("queryParamKey"), (String) data.get("queryParamValue"));
        }
    }


    public static void createQueryPayload(String key, String value) {
        queryParams = new HashMap<String, String>();
        queryParams.put(key, value);
    }

}
