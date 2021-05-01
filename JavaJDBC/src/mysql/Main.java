package mysql;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/triggering";
        String uname="root";
        String pass="YOUR_DB_PASSWORD";
        String query="INSERT INTO student VALUES(?,?,?,?)";

        try{
            Scanner scanner = new Scanner(System.in);
            System.out.print("Input your data to your db: ");
            String nextLine = scanner.nextLine();
            List<String> inputLists = new ArrayList<>();

            Connection conn= DriverManager.getConnection(url,uname,pass);
            PreparedStatement st= conn.prepareStatement(query);

            for(String next:nextLine.split(" ")){
                inputLists.add(next.replace(",",""));
            }

            st.setInt(1,Integer.parseInt(inputLists.get(0)));
            st.setString(2, inputLists.get(1));
            st.setString(3, inputLists.get(2));
            st.setString(4, inputLists.get(3));

            int count = st.executeUpdate();
            System.out.println(count+" rows affected");

            st.close();
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
