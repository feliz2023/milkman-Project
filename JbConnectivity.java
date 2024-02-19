package milkman_manage_system;

// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.sql.Statement;

// public class JbConnectivity {

//   private static String MYSQL_JDBC_DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
//   private static String MYSQL_DB_URL = "jdbc:mysql://localhost:3306/kuku1";
//   private static String MYSQL_DB_USER = "khushi";
//   private static String MYSQL_DB_USER_PASSWORD = "Khushi$22$";
//   private static String SQL_QUERY = "Select * from department";

//   public static void main(String[] args) {
//     try (
//       Connection connection = DriverManager.getConnection(
//         MYSQL_DB_URL,
//         MYSQL_DB_USER,
//         MYSQL_DB_USER_PASSWORD
//       )
//     ) {
//       //   System.out.println(DriverManager.getLoginTimeout());

//       Class.forName(MYSQL_JDBC_DRIVER_CLASS);
//       Statement statement = connection.createStatement();
//       ResultSet resultSet = statement.executeQuery(SQL_QUERY);

//       //   System.out.println(DriverManager.getDriver(MYSQL_DB_URL));

//       while (resultSet.next()) {
//         System.out.println(
//           resultSet.getString(1) +
//           "  " +
//           resultSet.getInt(2) +
//           "  " +
//           resultSet.getString(3) +
//           "  " +
//           resultSet.getDate(4) +
//           "  "
//         );
//       }
//       connection.close();
//     } catch (ClassNotFoundException e) {
//       System.out.println("MySQL Driver class not found!");
//       e.printStackTrace();
//     } catch (SQLException e) {
//       System.out.println("Error occured while executing query: " + SQL_QUERY);
//       e.printStackTrace();
//     }
//   }
// }

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JbConnectivity {

  private static final String JDBC_URL =
    "jdbc:mysql://localhost:3306/milkman_management";
  private static final String USERNAME = "root";
  private static final String PASSWORD = "Khushi$22$";

  private Connection connection;

  public JbConnectivity() {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
      System.out.println("Connected to the database");
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }
  }

  public Connection getConnection() {
    return connection;
  }

  public void closeConnection() {
    try {
      if (connection != null && !connection.isClosed()) {
        connection.close();
        System.out.println("Disconnected from the database");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
