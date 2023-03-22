package cscie88a.week8.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cscie88a.week8.model.SensorEvent;

public class SensorEventParser {
    private static ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static SensorEvent getSensorEventFromString(String sensorEventAsString) throws JsonProcessingException {
        return OBJECT_MAPPER.readValue(sensorEventAsString, SensorEvent.class);
    }

    public static String getSensorEventAsJsonString(SensorEvent sensorEvent) throws JsonProcessingException {
        return OBJECT_MAPPER.writeValueAsString(sensorEvent);
    }
}
