package utils;

import enums.Endpoints;
import models.response.GetPostsResponseModel;
import models.response.GetUsersResponseModel;
import org.junit.Assert;
import restwrapper.Headers;
import restwrapper.RestWrapper;

import java.util.Map;

public class GetPostsUtils {
    int postId;

    public GetPostsResponseModel[] callGetPosts(Map<String, String> queryParams) {

        return RestWrapper.restGet(Endpoints.POSTS, Headers.generalHeaders(), queryParams, GetPostsResponseModel[].class);
    }


    public void validateIdStartAndEnd(GetPostsResponseModel[] getPostsResponseModel, int start, int end) {

        for (int i = 0; i < getPostsResponseModel.length; i++) {
            postId = getPostsResponseModel[i].id;
            Assert.assertTrue(postId >= start && postId <= end);

        }
    }


    public String validateThatPostisAdded(GetPostsResponseModel[] getPostsResponseModels) {
        String title = "Post Not Added";
        String expectedTitle;
        for (int i = 0; i < getPostsResponseModels.length; i++) {
            expectedTitle = getPostsResponseModels[i].title;
            if (title.contains("APIs Automation")) {
                return expectedTitle;
            }
        }
        return title;
    }
}
