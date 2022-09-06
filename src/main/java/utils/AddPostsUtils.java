package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import enums.Endpoints;
import models.response.AddPostResponseModel;
import objects.AddPostRequestbody;
import restwrapper.Headers;
import restwrapper.RestWrapper;

public class AddPostsUtils {

    static AddPostRequestbody addPostRequestbody = new AddPostRequestbody();
    public static AddPostResponseModel addNewPost(String path , String methodType , String userId ) throws JsonProcessingException {

        return RestWrapper.restRequest(methodType,Endpoints.valueOf(path), Headers.generalHeaders() , addPostRequestbody.getBody(userId) ,null, AddPostResponseModel.class);
//        return RestWrapper.restPost(Endpoints.valueOf(path), Headers.generalHeaders() , addPostRequestbody.getBody(userId) , AddPostResponseModel.class);
    }
}
