import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Input input = new Input();
        CalValues values = new CalValues(input.getP(), input.getQ());
        Encryption encr = new Encryption();

        BigInteger encrypted = encr.encrypt(input.getCipherMessage(), values.getN(), values.getE());
        //ConnectionUtil db = new ConnectionUtil();
        //Connection conn = db.connectToDb("rsa", "root", "");

        System.out.println("FN: " + values.getFn());
        System.out.println("Public key (e, n): (" + values.getE() + ", " + values.getN() + ")");
        System.out.println("Private key (d, n): (" + values.getD() + ", " + values.getN() + ")");
        System.out.println("Encrypted message: " + encrypted);
        System.out.println("Cipher message: " + input.getCipherMessage());
        System.out.print("E " + values.getE());
    }
}
