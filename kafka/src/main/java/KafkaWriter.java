import com.intuit.journal.api.AtomicBatch;
import com.intuit.journal.api.AtomicBatchMetadata;
import com.intuit.journal.api.LogRecord;
import com.intuit.journal.api.Writer;
import com.intuit.journal.util.json.SimpleJsonSerializer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.Future;

/**
 * Created by rsingh13.
 * TODO: Read configuration from remote.
 */
public class KafkaWriter implements Writer{

    private Properties props = new Properties();
    private KafkaProducer<byte[], byte[]> producer ;
    
    public KafkaWriter() {
        init();
    }

    private void init() {
        configure();
        producer = new KafkaProducer(props);
    }

    private void configure() {
        try { //TODO:Java 8 style try-with-resource implementation
            //Configuration for Idempotent Producer
            props.setProperty( ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, Boolean.toString( true ) );
            props.setProperty( ProducerConfig.ACKS_CONFIG, "all" );
            props.setProperty( ProducerConfig.RETRIES_CONFIG, Integer.toString( Integer.MAX_VALUE ) );
            props.setProperty( ProducerConfig.MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION, Integer.toString( 1 ) );
            props.setProperty( ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "com.intuit.journal.util.json.SimpleJsonSerialize");
            props.setProperty( ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"com.intuit.journal.util.json.SimpleJsonSerialize");
        }catch (Exception e) {

        }finally {

        }
    }

    @Override
    public Future<AtomicBatchMetadata> write(AtomicBatch payload) {
        Iterator<LogRecord> iter = payload.iterator();
        //TODO: If Producer.initTransactions acquires more resources ,
        // TODO:we should do it once instead of calling it for every write method.
        //TODO:Need to study this further to make changes.
        producer.initTransactions();
        while(iter.hasNext()) {

            //begin transaction
            producer.beginTransaction();
            // Process the input records and send them to the output topic(s).

            // To ensure that the consumed and produced messages are batched, we need to commit
            // the offsets through
            // the producer and not the consumer.
            //
            // If this returns an error, we should abort the transaction.




        }
        return null;
    }

    @Override
    public void close() throws IOException {

    }
}
