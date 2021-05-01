package cassandraJava;

import com.github.cassandra.jdbc.internal.datastax.driver.core.BoundStatement;
import com.github.cassandra.jdbc.internal.datastax.driver.core.PreparedStatement;
import com.github.cassandra.jdbc.internal.datastax.driver.core.ResultSet;

public class DeleteData {
    public static void main(String[] args) {
        try {
            DBConnector connector = new DBConnector();
            connector.connectDb("localhost",9042);

            final String deleteQuery="DELETE FROM movies_keyspace.movies WHERE title=? AND year=?";
            PreparedStatement psDelete = connector.getSession().prepare(deleteQuery);
            BoundStatement bsDelete = psDelete.bind("The Saw 3",2014);
            ResultSet rs = connector.getSession().execute(bsDelete);

            connector.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
