package org.delta.bank.user;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.delta.bank.print.LogService;

import java.util.HashMap;
import java.util.Map;

@Singleton
public class OwnerService {
    private final Map<Integer, Owner> owners;
    @Inject
    private OwnerFactory ownerFactory;
    @Inject
    private LogService logService;

    public OwnerService() {
        owners = new HashMap<>();
    }

    public Owner addOwner(String firstName, String lastName) {
        Owner owner = ownerFactory.createOwner(firstName, lastName);
        return addOwner(owner);
    }

    public Owner addOwner(Owner owner) {
        owners.put(owner.getId(), owner);
        return owner;
    }

    public Map<Integer, Owner> getOwners() {
        return owners;
    }
}
