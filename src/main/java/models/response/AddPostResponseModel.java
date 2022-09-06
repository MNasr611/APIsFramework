package models.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AddPostResponseModel {
    @JsonIgnoreProperties(ignoreUnknown = true)
    public String title;
    public String body;
    public String userId;
    public int id;
}
