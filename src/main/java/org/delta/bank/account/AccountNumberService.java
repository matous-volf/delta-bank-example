package org.delta.bank.account;

import java.util.concurrent.ThreadLocalRandom;

public class AccountNumberService {
    private final ThreadLocalRandom random;

    public AccountNumberService() {
        this.random = ThreadLocalRandom.current();
    }

    public String generateAccountNumber() {
        int number = random.nextInt(1000000, 10000000);
        return (Integer.toString(number));
    }
}
