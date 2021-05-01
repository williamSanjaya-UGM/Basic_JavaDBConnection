package cassandraJava;

import com.github.cassandra.jdbc.internal.datastax.driver.core.BoundStatement;
import com.github.cassandra.jdbc.internal.datastax.driver.core.PreparedStatement;

public class UpdateData {
    public static void main(String[] args) {
        try {
            DBConnector connector = new DBConnector();
            connector.connectDb("localhost",9042);

            final String updateQuery="UPDATE movies_keyspace.movies SET rating=? WHERE title=? AND year=? ";
            PreparedStatement psUpdate = connector.getSession().prepare(updateQuery);
            BoundStatement bsUpdate= psUpdate.bind("10.0","The Saw 3",2014);
            connector.getSession().execute(bsUpdate);

            connector.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
