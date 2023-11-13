package org.delta.bank.json;

import org.delta.bank.account.BaseBankAccount;
import org.delta.bank.user.Owner;

import java.io.IOException;
import java.util.List;

public interface JsonLoader {
    public void load(
            String ownersJson,
            String baseBankAccountsJson,
            String studentBankAccountsJson,
            String savingBankAccountsJson) throws IOException;
}
