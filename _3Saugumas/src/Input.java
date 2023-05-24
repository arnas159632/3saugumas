import java.math.BigInteger;
import java.util.Scanner;

public class Input {
    private String x;
    private BigInteger cipherMessage;
    public BigInteger p;
    public BigInteger q;

    public Input() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insert text:");
        this.x = scanner.nextLine();

        System.out.println("Insert first number (p):");
        this.p = scanner.nextBigInteger();
        scanner.nextLine(); // Consume the newline character

        System.out.println("Insert second number (q):");
        this.q = scanner.nextBigInteger();
        scanner.nextLine(); // Consume the newline character

        this.cipherMessage = stringCipher(x);


    }

    public String getX() {
        return this.x;
    }

    public BigInteger getP() {
        return this.p;
    }

    public BigInteger getQ() {
        return this.q;
    }

    public BigInteger getCipherMessage() {
        return this.cipherMessage;
    }

    public static BigInteger stringCipher(String message) { // uzsifruoja x ir atsakymas priskiriamas cipherMessage
        message = message.toUpperCase();
        String cipherString = "";
        int i = 0;
        while (i < message.length()) {
            int ch = (int) message.charAt(i);
            cipherString = cipherString + ch;
            i++;
        }
        BigInteger cipherBig = new BigInteger(String.valueOf(cipherString));
        return cipherBig;
    }
}
