package ch.keepcalm.web.converter;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Marcel Widmer  on 25/12/15.
 *
 */
public class JsonConverter<T> {
    /**
     * @param fileClasspath the classpath absolute path of the json file e.g. /sampleRequest/uebernehmeAntrag.json
     * @param type the type of object to convert json to
     * @return the converted object
     */
    public T convert(String fileClasspath, Class<T> type) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            InputStream in = JsonConverter.class.getResourceAsStream(fileClasspath);
            return mapper.readValue(in, type);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param json json as string.
     * @param type the type of object to convert json to
     * @return the converted object
     */
    public T convertJsonToObject(String json, Class<T> type) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(json, type);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public String convertObjectToJson(T type) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(type);
    }

}