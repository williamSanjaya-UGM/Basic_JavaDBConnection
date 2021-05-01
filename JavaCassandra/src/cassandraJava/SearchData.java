package cassandraJava;

import com.github.cassandra.jdbc.internal.datastax.driver.core.BoundStatement;
import com.github.cassandra.jdbc.internal.datastax.driver.core.PreparedStatement;
import com.github.cassandra.jdbc.internal.datastax.driver.core.ResultSet;

public class SearchData {
    public static void main(String[] args) {
        try {
            DBConnector connector = new DBConnector();
            connector.connectDb("localhost",9042);

            final String selectQuery="SELECT * FROM movies_keyspace.movies WHERE title=? AND year=?";
            PreparedStatement psSelect = connector.getSession().prepare(selectQuery);
            BoundStatement bsSelect = psSelect.bind("Chasing Liberty",2004);
            ResultSet rs = connector.getSession().execute(bsSelect);

            rs.forEach(rr->{
                System.out.println("movie name: "+rr.getString("title"));
                System.out.println("movie desc: "+rr.getString("description"));
                System.out.println("rating: "+rr.getString("rating"));
            });

            connector.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
