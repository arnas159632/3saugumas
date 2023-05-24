import java.math.BigInteger;

public class Encryption {

        public BigInteger encrypt(BigInteger x, BigInteger n, BigInteger e) {
            return x.modPow(e, n);
        }

        public BigInteger decrypt(BigInteger enc, BigInteger n, BigInteger d) {
            return enc.modPow(d, n);
        }
    }
