package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PreparedStObj {
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

            int index=1;
            for(int i=0;i<inputLists.size();i++){
                if(index==1) {
                    st.setObject(index++,Integer.parseInt(inputLists.get(i)));
                }else
                    st.setObject(index++,inputLists.get(i));
            }

            int count = st.executeUpdate();
            System.out.println(count+" rows affected");

            st.close();
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
