package org.delta.bank.user;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.delta.bank.print.LogService;

@Singleton
public class OwnerFactory {
    @Inject
    private LogService logService;
    @Inject
    private OwnerIdService ownerIdService;

    public Owner createOwner(int id, String firstName, String lastName) {
        Owner owner = new Owner(id, firstName, lastName);
        logService.logOwnerCreation(owner);

        return owner;
    }

    public Owner createOwner(String firstName, String lastName) {
        Owner owner = new Owner(ownerIdService.generateOwnerId(), firstName, lastName);
        logService.logOwnerCreation(owner);

        return owner;
    }
}
