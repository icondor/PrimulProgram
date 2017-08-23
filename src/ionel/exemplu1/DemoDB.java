
package ionel.exemplu1;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
*/

public class DemoDB {

    // 2. define connection params to db
    final static String URL = "jdbc:postgresql://localhost:5432/mydb";
    final static String USERNAME = "postgres";
    final static String PASSWORD = "password1";


    public static void main(String[] args) {
        System.out.println("Hello database users! We are going to call DB from Java");
//        try {
//            //demo CRUD operations
//             demoCreate();
//
//             demoUpdate();
//            demoDelete();
//            demoRead();
//
//            // demoBlobInsert();
//            // demoBlobRead();
//
//
//
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

    }

    public static void demoCreate(String nume, String telefon) throws ClassNotFoundException, SQLException {

        // 1. load driver, no longer needed in new versions of JDBC
        Class.forName("org.postgresql.Driver");



        // 3. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 4. create a query statement
        PreparedStatement pSt = conn.prepareStatement("INSERT INTO agenda (nume, telefon) VALUES (?,?)");
        pSt.setString(1, nume);
        pSt.setString(2, telefon);

        // 5. execute a prepared statement
        int rowsInserted = pSt.executeUpdate();

        // 6. close the objects
        pSt.close();
        conn.close();
    }

    public static List<Persoana> demoRead() throws ClassNotFoundException, SQLException {
        // 1. load driver, no longer needed in new versions of JDBC
        Class.forName("org.postgresql.Driver");

        // 3. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 4. create a query statement
        Statement st = conn.createStatement();

        String query="SELECT * FROM agenda order by nume asc";
        System.out.println(query);
        // 5. execute a query
        ResultSet rs = st.executeQuery(query);

        // 6. iterate the result set and print the values

        List listaDePersoane = new ArrayList<Persoana>();
        while (rs.next()) {
            String nume = rs.getString("nume").trim();
            String telefon = rs.getString("telefon").trim();
            Persoana p = new Persoana();
            p.nume=nume;
            p.telefon=telefon;
            listaDePersoane.add(p);

        }

        // 7. close the objects
        rs.close();
        st.close();
        conn.close();
        return listaDePersoane;
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


    public static void demoDelete(long id) throws ClassNotFoundException, SQLException {

        // 1. load driver, no longer needed in new versions of JDBC
        Class.forName("org.postgresql.Driver");



        // 3. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 4. create a query statement
        PreparedStatement pSt = conn.prepareStatement("DELETE FROM agenda WHERE id=?");
        pSt.setLong(1, id);

        // 5. execute a prepared statement
        int rowsDeleted = pSt.executeUpdate();
        System.out.println(rowsDeleted + " rows were deleted.");
        // 6. close the objects
        pSt.close();
        conn.close();
    }
}

