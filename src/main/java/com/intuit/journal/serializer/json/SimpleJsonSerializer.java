package com.intuit.journal.serializer.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.confluent.kafka.serializers.KafkaJsonSerializerConfig;
import org.apache.kafka.common.errors.SerializationException;

/**
 * Serialize objects to UTF-8 JSON. This works with any object which is serializable with Jackson.
 * Created by rsingh13
 */
public class SimpleJsonSerializer<T>{

  private ObjectMapper objectMapper;

  /**
   * Default constructor needed by Kafka
   */
  public SimpleJsonSerializer() {

  }


  public void configure(KafkaJsonSerializerConfig config) {
    this.objectMapper = new ObjectMapper();
    boolean  prettyPrint = true; //TODO :This needs to be retrieved from configuration
    this.objectMapper.configure(SerializationFeature.INDENT_OUTPUT, prettyPrint);
  }

  public byte[] serialize(T data) {
    if (data == null) {
      return null;
    }

    try {
      return objectMapper.writeValueAsBytes(data);
    } catch (Exception e) {
      throw new SerializationException("Error serializing JSON message", e);
    }
  }

  public void close() {

  }

}
