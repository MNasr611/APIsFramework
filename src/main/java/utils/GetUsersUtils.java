package utils;

import enums.Endpoints;
import models.response.GetUsersResponseModel;
import restwrapper.Headers;
import restwrapper.RestWrapper;

import java.util.Map;

public class GetUsersUtils {
    public GetUsersResponseModel[] callGetUsers(Map<String, String> queryParams)  {
        return RestWrapper.restGet(Endpoints.GETUSERS, Headers.generalHeaders() , queryParams , GetUsersResponseModel[].class);
    }
}
