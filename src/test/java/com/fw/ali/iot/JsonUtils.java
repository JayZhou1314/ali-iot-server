package com.fw.ali.iot;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.StringWriter;

/**
 *
 */
public class JsonUtils {

    private static JsonUtils ins = new JsonUtils();

    public static JsonUtils getIns() {
        return ins;
    }

    public <T> String toString(T o) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        JsonFactory jf = new JsonFactory();
        StringWriter sw = new StringWriter();
        JsonGenerator jg = jf.createGenerator(sw);
        jg.useDefaultPrettyPrinter();
        objectMapper.writeValue(jg, o);
        String content = sw.toString();
        return content;
    }

    public <T> T toObject(String content, Class<? extends T> type) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        T t = objectMapper.readValue(content.getBytes(), type);
        return t;
    }

}
