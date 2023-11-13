package org.delta.bank.account;

import com.google.inject.Singleton;

import java.util.concurrent.ThreadLocalRandom;

@Singleton
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
