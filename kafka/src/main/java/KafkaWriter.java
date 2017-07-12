import com.intuit.journal.api.AtomicBatch;
import com.intuit.journal.api.AtomicBatchMetadata;
import com.intuit.journal.api.Writer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;

import java.io.IOException;
import java.util.Iterator;
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
        //Configuration for Idempotent Producer
        props.setProperty( ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG,Boolean.toString( true ));
        props.setProperty( ProducerConfig.ACKS_CONFIG, "all");
        props.setProperty( ProducerConfig.RETRIES_CONFIG, Integer.toString(  Integer.MAX_VALUE));
        props.setProperty( ProducerConfig.MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION,Integer.toString(1) );
    }

    @Override
    public Future<AtomicBatchMetadata> write(AtomicBatch payload) {
        Iterator<LogRecord> iter = payload.iterator();
        return null;
    }

    /**
     * Closes this stream and releases any system resources associated
     * with it. If the stream is already closed then invoking this
     * method has no effect.
     * <p>
     * <p> As noted in {@link AutoCloseable#close()}, cases where the
     * close may fail require careful attention. It is strongly advised
     * to relinquish the underlying resources and to internally
     * <em>mark</em> the {@code Closeable} as closed, prior to throwing
     * the {@code IOException}.
     *
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void close() throws IOException {

    }

    @Override
    public Future<AtomicBatchMetadata> write(Object payload) {
        return null;
    }
}
