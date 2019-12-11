
import java.sql.*;

/**
	File name: DBExercise.java
	Short description: ??????
	IST 242 Assignment:  
	@author Joshua Michaels
	@version 1.01 2014-08-25
	date of last revision:
	details of the revision: none
*/




/**
 *
 * @author Joshua
 */
public class DBExercise {

    public static void main(String[] args) {
        try {
// setting up database connection

Connection dbConnection = DriverManager.getConnection("jdbc:sqlite:sample.sqlite3", "app", "app");

// test database query
Statement stmt = dbConnection.createStatement();
String testQuery = "SELECT * FROM CUSTOMER";
ResultSet results;
           
results = stmt.executeQuery(testQuery);

// processing results
while (results.next()) {
   System.out.println("Result: " + results.getString("NAME"));
}

// clean up
results.close();
stmt.close();
dbConnection.close();


} catch (SQLException e) {
  System.out.println("Cannot connect to database.\n" + e.getMessage());
} 
        
    }
}
