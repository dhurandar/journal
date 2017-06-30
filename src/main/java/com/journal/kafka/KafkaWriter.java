package com.journal.kafka;

import com.journal.LogRecord;
import com.journal.Writer;
import com.journal.AtomicBatch;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.Future;

/**
 * Created by rsingh13 on 6/9/17.
 */
public class KafkaWriter implements Writer<AtomicBatch<LogRecord>> {

    private KafkaProducer producer;
    private Properties kafkaProps = new Properties();

    public KafkaWriter () {
        //TODO: NOT GOOD now , Really important to get these from property files.
        kafkaProps.put("bootstrap.servers", "broker1:9092,broker2:9092");
        //kafkaProps.put("key.serializer",  "SimpleJsonSerializer");
        kafkaProps.put("value.serializer", "SimpleJsonSerializer");
        producer = new KafkaProducer<String, String>(kafkaProps);
    }

    public Future<AtomicBatch<LogRecord>> write(AtomicBatch<LogRecord> logRecordAtomicBatch) {
        ProducerRecord<String, String> record =
                new ProducerRecord<>(); //TODO add the topic details
        try {
            producer.send(record).get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * @throws IOException if an I/O error occurs
     */
    public void close() throws IOException {

    }
}
