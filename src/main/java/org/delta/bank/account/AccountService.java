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

    public BaseBankAccount addBaseAccount(String accountNumber, double balance, Owner owner) {
        BaseBankAccount account = accountFactory.createBaseAccount(accountNumber, balance, owner);
        storeAccount(account);
        return account;
    }

    public BaseBankAccount addBaseAccount(double balance, Owner owner) {
        BaseBankAccount account = accountFactory.createBaseAccount(balance, owner);
        storeAccount(account);
        return account;
    }

    public SavingBankAccount addSavingAccount(String accountNumber, double balance, Owner owner) {
        SavingBankAccount account = accountFactory.createSavingAccount(accountNumber, balance, owner);
        storeAccount(account);
        return account;
    }

    public SavingBankAccount addSavingAccount(double balance, Owner owner) {
        SavingBankAccount account = accountFactory.createSavingAccount(balance, owner);
        storeAccount(account);
        return account;
    }

    public StudentBankAccount addStudentAccount(String accountNumber, double balance, Owner owner) {
        StudentBankAccount account = accountFactory.createStudentAccount(accountNumber, balance, owner);
        storeAccount(account);
        return account;
    }

    public StudentBankAccount addStudentAccount(double balance, Owner owner) {
        StudentBankAccount account = accountFactory.createStudentAccount(balance, owner);
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
