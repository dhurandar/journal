import com.journal.JournalClientBuilder;

/**
 * Created by rsingh13 on 5/31/17.
 */
class JournalClientTest{

    public static void main(String args[]) {


        //Admin activity. Once created you cannot create the same again.

        JournalClient client = JournalClientBuilder.newBuilder()
                                                   .clientId("123-atomic-writer")
                                                   .name("atomic-writer")
                                                   .build();
        //write a transaction
    }

}