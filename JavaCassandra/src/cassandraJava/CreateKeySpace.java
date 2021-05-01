package cassandraJava;

public class CreateKeySpace {
    public static void main(String[] args) {
        try {
            DBConnector connector = new DBConnector();
            connector.connectDb("localhost",9042);

            final String createMovieKeySpace="CREATE KEYSPACE IF NOT EXISTS movies_keyspace WITH " +
                    "replication={'class':'SimpleStrategy','replication_factor':3}";

            connector.getSession().execute(createMovieKeySpace);
            connector.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
