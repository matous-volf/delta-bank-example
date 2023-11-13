package org.delta.bank.user;

import com.google.inject.Singleton;

import java.util.concurrent.ThreadLocalRandom;

@Singleton
public class OwnerIdService {
    private final ThreadLocalRandom random;

    public OwnerIdService() {
        this.random = ThreadLocalRandom.current();
    }

    public int generateOwnerId() {
        return random.nextInt(1000000, 10000000);
    }
}
