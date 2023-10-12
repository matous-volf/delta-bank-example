package org.delta.bank.account;

import org.delta.bank.print.LogService;
import org.delta.bank.user.Owner;

import java.util.HashMap;
import java.util.Map;

public class AccountService {
    private Map<String, BaseBankAccount> accounts;
    private BankAccountFactory accountFactory;
    private LogService logService;

    public AccountService() {
        accounts = new HashMap<>();
        accountFactory = new BankAccountFactory();
        logService = new LogService();
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
