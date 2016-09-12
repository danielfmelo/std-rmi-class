package client;

import java.io.Serializable;
import java.math.BigDecimal;

import compute.Task;
import java.math.BigInteger;


//This is the task to be executed
public class Prime implements Task<BigDecimal>, Serializable {

    private final int digits;

    public Prime(int digits) {
        this.digits = digits;
    }

    public BigDecimal execute() {
        return nextPrime(digits);
    }

    static BigDecimal nextPrime(int n)
    {
        BigInteger b = new BigInteger(String.valueOf(n));
        BigDecimal d = new BigDecimal((b.nextProbablePrime()));
        return d;
    }
    
}
