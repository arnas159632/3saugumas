import java.math.BigInteger;
import java.sql.*;
import java.util.Scanner;

public class ConnectionUtil {

    public String publicKey;

    public Connection connectToDb(String dbname, String user, String pass) throws SQLException {

        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rsa" + dbname, user, pass);
            if (conn != null) {
                System.out.println("Connection Established");
            } else {
                System.out.println("Connection Failed");
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        Input input = new Input();
        Encryption encr = new Encryption();
        CalValues values = new CalValues(input.getP(), input.getQ());
        publicKey = values.getE().toString() + values.getN().toString();
        BigInteger encrypted = encr.encrypt(input.getCipherMessage(), values.getN(), values.getE());

        // Prompt the user to save the data
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to save the data in the database? (y/n)");

        if (scanner.hasNextLine()) {
            String response = scanner.nextLine();
            if (!response.isEmpty() && response.equalsIgnoreCase("y")) {

                String query = "INSERT INTO rsad (ctext, pkey) VALUES (?, ?)";

                PreparedStatement statement = conn.prepareStatement(query);
                statement.setString(1, encrypted.toString());
                statement.setString(2, publicKey);

                int rowsAffected = statement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Data inserted into the database");
                } else {
                    System.out.println("Data not saved in the database");
                }
            } else {
                System.out.println("Data not saved in the database");
            }
        } else {
            System.out.println("No input found");
        }

        return conn;
    }
}
