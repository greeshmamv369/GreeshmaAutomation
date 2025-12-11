package automation.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonReader {

    private JsonNode rootNode;

    // Constructor loads JSON file once
    public JsonReader(File filePath) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            rootNode = mapper.readTree(new File(filePath.toURI()));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to read JSON file: " + filePath);
        }
    }

    // ---------------- Basic Getters ----------------
    public String getString(String key) {
        return rootNode.get(key).asText();
    }

    public int getInt(String key) {
        return rootNode.get(key).asInt();
    }

    public boolean getBoolean(String key) {
        return rootNode.get(key).asBoolean();
    }

    // ---------------- Nested Object ----------------
    public String getNestedValue(String parentKey, String childKey) {
        JsonNode parent = rootNode.get(parentKey);
        if (parent != null && parent.get(childKey) != null) {
            return parent.get(childKey).asText();
        }
        return null;
    }

    // ---------------- Array Handling ----------------
    // Get value from array of primitives
    public String getArrayValue(String arrayKey, int index) {
        JsonNode arrayNode = rootNode.get(arrayKey);
        if (arrayNode != null && arrayNode.isArray() && arrayNode.get(index) != null) {
            return arrayNode.get(index).asText();
        }
        return null;
    }

    // Get object from array of objects
    public JsonNode getObjectFromArray(int index) {
        if (rootNode.isArray() && rootNode.get(index) != null) {
            return rootNode.get(index);
        }
        return null;
    }

    // Get field from object inside array
    public String getObjectFieldFromArray(int index, String fieldName) {
        JsonNode obj = getObjectFromArray(index);
        if (obj != null && obj.get(fieldName) != null) {
            return obj.get(fieldName).asText();
        }
        return null;
    }
}