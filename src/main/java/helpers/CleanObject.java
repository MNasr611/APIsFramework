package helpers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;



public class CleanObject {
    static File file ;

    public static String getCleanObject(Object object){
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


    public static File getObjectAsJSONFile (Object object , String fileName) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        file = new File("src/test/java/TestData/" + fileName + ".json");
        objectMapper.writeValue(file,object);
        return file;
    }


    }
