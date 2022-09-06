package StepDefs;

import com.fasterxml.jackson.core.JsonProcessingException;
import helpers.CleanObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.messages.internal.com.google.protobuf.StringValue;
import io.restassured.path.json.JsonPath;
import models.response.AddPostResponseModel;
import models.response.GetPostsResponseModel;
import models.response.GetUsersResponseModel;
import objects.AddPostRequestbody;
import objects.GetRequestQueryParams;
import org.junit.Assert;
import org.junit.BeforeClass;
import utils.AddPostsUtils;
import utils.GetPostsUtils;
import utils.GetUsersUtils;


public class UsersAndPostStepDef {
    int userId;
    GetUsersResponseModel[] getUsersResponseModel;
    GetPostsResponseModel[] getPostsResponseModels;
    AddPostResponseModel addPostResponseModel;
    AddPostRequestbody addPostRequestbody;
    GetRequestQueryParams getRequestQueryParams = new GetRequestQueryParams();
    GetUsersUtils getUsersUtils = new GetUsersUtils();
    GetPostsUtils getPostsUtils = new GetPostsUtils();

    @Before
    public void beforeScenario(){
        System.out.println("before scenario");
    }

    @Then("Get Users")
    public void getUsers() {
        getUsersResponseModel = getUsersUtils.callGetUsers(getRequestQueryParams.getQueryParams());
        System.out.println("The User Email Is : " + getUsersResponseModel[0].email);
    }

    @Then("Get Posts For The User")
    public void validateThatTheIsIntegerBetweenAnd() {
        userId = getUsersResponseModel[0].id;
        getPostsResponseModels = getPostsUtils.callGetPosts(getRequestQueryParams.getQueryParams());
    }

    @Then("Validate That The PostId Is Integer Between {int} and {int}")
    public void validateThatTheIdIsIntegerBetweenAnd(int start, int end) {
        getPostsUtils.validateIdStartAndEnd(getPostsResponseModels, start, end);
    }


//    @And("Add New Post")
//    public void addNewPost() throws JsonProcessingException {
//        addPostResponseModel = AddPostsUtils.addNewPost(String.valueOf(userId));
//    }


//    @And("Add New Post {string}")
//    public void addNewPost(String path) throws JsonProcessingException {
//
//    }

    @And("Add New Post {string} with method type {string}")
    public void addNewPostWithMethodType(String path, String methodType) throws JsonProcessingException {
        addPostResponseModel = AddPostsUtils.addNewPost(path, methodType,String.valueOf(userId));

    }


    @Then("Validate That the Post Added Successfully")
    public void validateThatThePostAddedSuccessfully() {
        String actualTitle = "APIs Automation";
        String expectedTitle = addPostResponseModel.title;
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Given("Create Payload For Post Request")
    public void createPayloadForPostRequest(DataTable payload) {
        addPostRequestbody = new AddPostRequestbody();
        addPostRequestbody.generatePayload(payload);
    }


    @Given("Create Multiple QueryParams For Get Request")
    public void createQueryParamsForGetRequest(DataTable queryParameters){
        getRequestQueryParams.createQueryParamsForGetRequest(queryParameters);
    }

    @Given("Create QueryParam {string} For Get Request")
    public void creategetpayloadAnd(String key) {
        getRequestQueryParams.createQueryPayload(key, String.valueOf(getUsersResponseModel[0].id));
    }




    @Then("Validate that New Post With Title {string} Has Been Added")
    public void validateThatNewPostWithTitleHasBeenAdded(String actualTitle) {
        String expectedTitle = getPostsUtils.validateThatPostisAdded(getPostsResponseModels);
        Assert.assertEquals(expectedTitle,actualTitle);
    }


    @Then("Validate that post {string} is added with title {string}")
    public void validateThatPostIsAddedWithTitle(String actualTitle, String expectedTitle) throws JsonProcessingException {
        JsonPath js = new JsonPath(CleanObject.getCleanObject(addPostResponseModel));
        Assert.assertEquals(js.get(actualTitle), expectedTitle);

    }

    @After
    public void afterScenario(){
        System.out.println("after scenario");
    }
}
