package br.com.ScreenMatch.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerializeData implements ISerializable{
    private ObjectMapper mapper = new ObjectMapper();


    @Override
    public <T> T getData(String json, Class<T> tClass) throws JsonProcessingException {
        return mapper.readValue(json, tClass);
    }
}
