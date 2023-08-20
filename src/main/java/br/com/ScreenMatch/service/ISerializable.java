package br.com.ScreenMatch.service;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface ISerializable {
    <T> T getData(String json, Class<T> tClass) throws JsonProcessingException;

}
