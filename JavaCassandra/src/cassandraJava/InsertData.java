package cassandraJava;

import com.github.cassandra.jdbc.internal.datastax.driver.core.BoundStatement;
import com.github.cassandra.jdbc.internal.datastax.driver.core.PreparedStatement;

public class InsertData {
    public static void main(String[] args) {
        try {
            DBConnector connector = new DBConnector();
            connector.connectDb("localhost",9042);

            final String insertQuery="INSERT INTO movies_keyspace.movies (title,year,description,rating) " +
                    "VALUES(?,?,?,?)";
            PreparedStatement psInsert = connector.getSession().prepare(insertQuery);
            BoundStatement bsInsert= psInsert.bind("The Saw 3",2014,"Thriller","4.0");
            connector.getSession().execute(bsInsert);

            connector.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
