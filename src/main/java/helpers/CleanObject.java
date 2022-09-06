package helpers;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.logging.Log;

import java.io.IOException;
import java.util.HashMap;



public class CleanObject {
    public static String getCleanObject(Object object) throws JsonProcessingException {
        ObjectMapper Obj = new ObjectMapper();
        String jsonStr = null;

        try {
            // Converting the Java object into a JSON string
            jsonStr = Obj.writeValueAsString(object);
            // Displaying Java object into a JSON string
            System.out.println(jsonStr);
        } catch (IOException e) {
            e.printStackTrace();
        }return jsonStr;
    }



        public static HashMap<String, String> getObjectAsMap (Object object){
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.convertValue(object, HashMap.class);
        }
    }
