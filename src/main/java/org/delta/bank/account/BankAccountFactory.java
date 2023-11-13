package org.delta.bank.account;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.delta.bank.print.LogService;
import org.delta.bank.user.Owner;

@Singleton
public class BankAccountFactory {
    @Inject
    private LogService logService;
    @Inject
    private AccountNumberService accountNumberService;

    public BaseBankAccount createBaseAccount(String accountNumber, double balance, Owner owner) {
        BaseBankAccount account = new BaseBankAccount(owner, accountNumber, balance);

        logService.logAccountCreation(account);

        return account;
    }

    public BaseBankAccount createBaseAccount(double balance, Owner owner) {
        return createBaseAccount(accountNumberService.generateAccountNumber(), balance, owner);
    }

    public SavingBankAccount createSavingAccount(String accountNumber, double balance, Owner owner) {
        SavingBankAccount account = new SavingBankAccount(owner, accountNumber, balance);

        logService.logAccountCreation(account);

        return account;
    }

    public SavingBankAccount createSavingAccount(double balance, Owner owner) {
        return createSavingAccount(accountNumberService.generateAccountNumber(), balance, owner);
    }

    public StudentBankAccount createStudentAccount(String accountNumber, double balance, Owner owner) {
        StudentBankAccount account = new StudentBankAccount(owner, accountNumber, balance);

        logService.logAccountCreation(account);

        return account;
    }


    public StudentBankAccount createStudentAccount(double balance, Owner owner) {
        return createStudentAccount(accountNumberService.generateAccountNumber(), balance, owner);
    }
}
