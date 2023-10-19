package org.delta.bank.user;

import com.google.inject.Inject;
import org.delta.bank.account.BankAccountFactory;
import org.delta.bank.account.BaseBankAccount;
import org.delta.bank.account.SavingBankAccount;
import org.delta.bank.account.StudentBankAccount;
import org.delta.bank.print.LogService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OwnerService {
    private List<Owner> owners;
    @Inject
    private OwnerFactory ownerFactory;
    @Inject
    private LogService logService;

    public OwnerService() {
        owners = new ArrayList<>();
    }

    public Owner addOwner(String firstName, String lastName) {
        Owner owner = ownerFactory.createOwner(firstName, lastName);
        storeOwner(owner);
        return owner;
    }

    private void storeOwner(Owner owner) {
        owners.add(owner);
    }
}
