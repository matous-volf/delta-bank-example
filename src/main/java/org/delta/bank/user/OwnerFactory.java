package org.delta.bank.user;

import com.google.inject.Inject;
import org.delta.bank.print.LogService;

public class OwnerFactory {
    @Inject
    private LogService logService;

    public Owner createOwner(String firstName, String lastName) {
        Owner owner = new Owner(firstName, lastName);
        logService.logOwnerCreation(owner);

        return owner;
    }
}
