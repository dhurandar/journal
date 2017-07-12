package com.intuit.journal.util.json;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Generic JSON deserializer.
 * Created by rsingh13
 */
public class SimpleJsonDeserializer<T>{

  private ObjectMapper objectMapper;
  private Class<T> type;

  public SimpleJsonDeserializer() {

  }

  public void configure(Class<T> type) {
    this.objectMapper = new ObjectMapper();
    this.type = type;

    //TODO:Get this from the configuration , whether to fail if you encounter the unknown property.
    this.objectMapper
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
  }

  public T deserialize(byte[] bytes) throws SerializationException{
    if (bytes == null || bytes.length == 0) {
      return null;
    }

    try {
      return objectMapper.readValue(bytes, type);
    } catch (Exception e) {
      throw new SerializationException(e);
    }
  }

  public Class<T> getType() {
    return type;
  }

  public void close() {

  }
}
