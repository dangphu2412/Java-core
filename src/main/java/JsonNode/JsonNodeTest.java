package JsonNode;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

// if tree is empty string -> when read node will return null

public class JsonNodeTest {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonInput = "{\"nick\": \"cowtowncoder\"}";
        JsonNode inputJsonNode;
        try {
            inputJsonNode = objectMapper.readTree(jsonInput).get("asd");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return;
        }
        System.out.print(inputJsonNode);
    }
}
