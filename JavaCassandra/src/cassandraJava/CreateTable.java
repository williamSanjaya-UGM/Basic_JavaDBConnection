package cassandraJava;

public class CreateTable {
    public static void main(String[] args) {
        try {
            DBConnector connector = new DBConnector();
            connector.connectDb("localhost",9042);

            final String createMovieTable="CREATE TABLE IF NOT EXISTS movies_keyspace.movies " +
                    "(title varchar, year int, description varchar, rating varchar, PRIMARY KEY(title,year))";

            connector.getSession().execute(createMovieTable);
            connector.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
