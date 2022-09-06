package restwrapper;



import enums.Endpoints;
import io.restassured.RestAssured;

import java.util.Map;
import java.util.Properties;

import static helpers.PropertiesLoader.readPropertyFile;
import static io.restassured.RestAssured.given;
import static io.restassured.config.EncoderConfig.encoderConfig;

public class RestWrapper {
    private static final Properties urlProps = readPropertyFile("config/api-url.properties");
    public static <T> T  restRequest(String methodType ,Endpoints endpoint, Map<String, String> headers, Object bodyData,Map<String, String> queryParams, Class<T> responseClass ){
        switch (methodType.toLowerCase()){
            case "post":
                return given().config(RestAssured.config().encoderConfig(encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false))).
                        contentType("application/json")
                        .relaxedHTTPSValidation()
                        .headers(headers)
                        .body(bodyData)
                        .when().log().all()
                        .post(System.getProperty("url", urlProps.getProperty("url")).concat(endpoint.getValue()))
                        .then().log().all()
                        .extract()
                        .as(responseClass);
            case "get":
                return given()
                        .relaxedHTTPSValidation()
                        .headers(headers)
                        .queryParams(queryParams)
                        .when().log().all()
                        .get(System.getProperty("url", urlProps.getProperty("url")).concat(endpoint.getValue()))
                        .then().log().all()
                        .extract().response().as(responseClass);
                default:
                throw new IllegalArgumentException(
                        String.format("method type not provided correctly"));
        }
    }

    public static <T> T restPost(Endpoints endpoint, Map<String, String> headers, Object bodyData,Class<T> responseClass) {
        System.out.println("bodyData  value is " + bodyData);
        return given().config(RestAssured.config().encoderConfig(encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false))).
                contentType("application/json")
                .relaxedHTTPSValidation()
                .headers(headers)
                .body(bodyData)
                .when().log().all()
                .post(System.getProperty("url", urlProps.getProperty("url")).concat(endpoint.getValue()))
                .then().log().all()
                .extract()
                .as(responseClass);
    }


    public static <T> T restGet(Endpoints endpoint, Map<String, String> headers, Map<String, String> queryParams, Class<T> responseClass) {
        return given()
                .relaxedHTTPSValidation()
                .headers(headers)
                .queryParams(queryParams)
                .when().log().all()
                .get(System.getProperty("url", urlProps.getProperty("url")).concat(endpoint.getValue()))
                .then().log().all()
                .extract().response().as(responseClass);
    }

    public static <T> T restGetWithPathParameter(Endpoints endpoint, Map<String, String> headers, Map<String, String> queryParams,String pathParameters, Class<T> responseClass) {
        return given()
                .relaxedHTTPSValidation()
                .headers(headers)
                .queryParams(queryParams)
                .when().log().all()
                .get(System.getProperty("url", urlProps.getProperty("url")).concat(endpoint.getValue()).concat(pathParameters))
                .then().log().all()
                .extract().response().as(responseClass);
    }


}
