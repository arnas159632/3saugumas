import java.math.BigInteger;
import java.util.Random;

public class CalValues {
    public BigInteger n;
    private BigInteger fn;
    public BigInteger e;
    private BigInteger d;


    public CalValues(BigInteger p, BigInteger q) {
        this.n = p.multiply(q);
        // apskaiciuojama Eulerio funkcija ( naudojama privaciojo rakto apskaiciavimui )
        this.fn = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
        this.e = genE(fn);
        this.d = e.modInverse(fn);
    }


    public BigInteger getE()
    {
        return this.e;
    }

    public BigInteger getN() {
        return this.n;
    }
    public BigInteger getFn() {
        return this.fn;
    }

    public BigInteger getD() {return this.d;}

    public static BigInteger genE(BigInteger phi) { // sugeneruoja random e
        Random rand = new Random();
        BigInteger e;
        do {
            e = new BigInteger(10, rand);
        } while (!e.gcd(phi).equals(BigInteger.ONE) || e.compareTo(phi) >= 0);
        return e;
    }



    public static BigInteger gcd(BigInteger a, BigInteger b) { // apskaiciuojame didziausia bendra dalikli
        if (b.equals(BigInteger.ZERO)) {
            return a;
        } else {
            return gcd(b, a.mod(b));
        }
    }

    public static BigInteger[] extEuclid(BigInteger a, BigInteger b) { // Euklido isplestine funkcija
        if (b.equals(BigInteger.ZERO)) return new BigInteger[] {
                a, BigInteger.ONE, BigInteger.ZERO
        }; // { a, 1, 0 }
        BigInteger[] vals = extEuclid(b, a.mod(b));
        BigInteger d = vals[0];
        BigInteger p = vals[2];
        BigInteger q = vals[1].subtract(a.divide(b).multiply(vals[2]));
        return new BigInteger[] {
                d, p, q
        };
    }

    }

