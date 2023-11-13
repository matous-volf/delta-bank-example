package org.delta.bank.user;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.delta.bank.print.LogService;

@Singleton
public class OwnerFactory {
    @Inject
    private LogService logService;

    public Owner createOwner(String firstName, String lastName) {
        Owner owner = new Owner(firstName, lastName);
        logService.logOwnerCreation(owner);

        return owner;
    }
}
