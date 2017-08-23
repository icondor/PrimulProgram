
package ionel.exemplu1;


import java.sql.*;

/**
*/

public class DemoDB {

    // 2. define connection params to db
    final static String URL = "jdbc:postgresql://localhost:5432/mydb";
    final static String USERNAME = "postgres";
    final static String PASSWORD = "password1";


    public static void main(String[] args) {
        System.out.println("Hello database users! We are going to call DB from Java");
        try {
            //demo CRUD operations
             demoCreate();

             demoUpdate();
            demoDelete();
            demoRead();

            // demoBlobInsert();
            // demoBlobRead();



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static void demoCreate() throws ClassNotFoundException, SQLException {

        // 1. load driver, no longer needed in new versions of JDBC
        Class.forName("org.postgresql.Driver");



        // 3. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 4. create a query statement
        PreparedStatement pSt = conn.prepareStatement("INSERT INTO agenda (nume, prenume) VALUES (?,?)");
        pSt.setString(1, "achim");
        pSt.setString(2, "david");

        // 5. execute a prepared statement
        int rowsInserted = pSt.executeUpdate();

        // 6. close the objects
        pSt.close();
        conn.close();
    }

    private static void demoRead() throws ClassNotFoundException, SQLException {
        // 1. load driver, no longer needed in new versions of JDBC
        Class.forName("org.postgresql.Driver");


        String startsWith = "ion";




        // 3. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 4. create a query statement
        Statement st = conn.createStatement();

        String query="SELECT * FROM agenda";
        System.out.println(query);
        // 5. execute a query
        ResultSet rs = st.executeQuery(query);

        // 6. iterate the result set and print the values
        while (rs.next()) {
            System.out.print(rs.getString("nume").trim());
            System.out.print("---");
            String pwd= rs.getString("prenume");
            if(pwd!=null)
                System.out.print(pwd.trim());
            System.out.println("-");
        }

        // 7. close the objects
        rs.close();
        st.close();
        conn.close();
    }

    private static void demoUpdate() throws ClassNotFoundException, SQLException {

        // 1. load driver, no longer needed in new versions of JDBC
        Class.forName("org.postgresql.Driver");



        // 3. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 4. create a query statement
        PreparedStatement pSt = conn.prepareStatement("UPDATE agenda SET nume=?, prenume=? WHERE id=?"); //so we have 3 params
        pSt.setString(1, "gates");
        pSt.setString(2, "bill");
        pSt.setLong(3, 2);

        // 5. execute a prepared statement
        int rowsUpdated = pSt.executeUpdate();

        // 6. close the objects
        pSt.close();
        conn.close();
    }


    private static void demoDelete() throws ClassNotFoundException, SQLException {

        // 1. load driver, no longer needed in new versions of JDBC
        Class.forName("org.postgresql.Driver");



        // 3. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 4. create a query statement
        PreparedStatement pSt = conn.prepareStatement("DELETE FROM agenda WHERE id=?");
        pSt.setLong(1, 1);

        // 5. execute a prepared statement
        int rowsDeleted = pSt.executeUpdate();
        System.out.println(rowsDeleted + " rows were deleted.");
        // 6. close the objects
        pSt.close();
        conn.close();
    }
}

