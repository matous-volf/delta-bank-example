package org.delta.bank.user;

import org.delta.bank.print.LogService;

public class OwnerFactory {
    private LogService logService;

    public OwnerFactory() {
        this.logService = new LogService();
    }

    public Owner createOwner(String firstName, String lastName) {
        Owner owner = new Owner(firstName, lastName);
        logService.logOwnerCreation(owner);

        return owner;
    }
}
