package org.delta.bank.account;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.delta.bank.print.LogService;
import org.delta.bank.user.Owner;

import java.util.HashMap;
import java.util.Map;

@Singleton
public class AccountService {
    private final Map<String, BaseBankAccount> accounts;
    @Inject
    private BankAccountFactory accountFactory;
    @Inject
    private LogService logService;

    public AccountService() {
        accounts = new HashMap<>();
    }

    public BaseBankAccount addBaseAccount(Owner owner, int balance) {
        BaseBankAccount account = accountFactory.createBaseAccount(owner, balance);
        storeAccount(account);
        return account;
    }

    public SavingBankAccount addSavingAccount(Owner owner, int balance) {
        SavingBankAccount account = accountFactory.createSavingAccount(owner, balance);
        storeAccount(account);
        return account;
    }

    public StudentBankAccount addStudentAccount(Owner owner, int balance) {
        StudentBankAccount account = accountFactory.createStudentAccount(owner, balance);
        storeAccount(account);
        return account;
    }

    private void storeAccount(BaseBankAccount account) {
        accounts.put(account.getAccountNumber(), account);
    }

    public Map<String, BaseBankAccount> getAccounts() {
        return accounts;
    }
}
