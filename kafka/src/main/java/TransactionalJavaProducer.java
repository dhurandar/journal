import com.journal.AtomicBatch;
import com.journal.Writer;

import java.io.IOException;
import java.util.concurrent.Future;

/**
 * Created by rsingh13.
 */
public class TransactionalJavaProducer implements Writer<AtomicBatch>{

    @Override
    public Future<AtomicBatch> write(AtomicBatch atomicBatch) {
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
}
}
