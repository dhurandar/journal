import com.journal.JournalClient;
import com.journal.JournalClientBuilder;
import com.intuit.journal.api.Token;

import java.util.concurrent.Future;

/**
 * Created by rsingh13 on 5/31/17.
 */
class JournalClientTrial{

    public static void main(String args[]) {


        //Admin activity. Once created you cannot create the same again.

        JournalClient client = JournalClientBuilder.newBuilder()
                                                   .clientId("123-atomic-writer")
                                                   .name("atomic-writer")
                                                   .build();
        //write a transaction
        Future<Token> future =
                (Future<Token>) client.write( new AtomicBatchBuilder().createAtomicBatch() );
    }

}