package org.delta.bank.account;

import com.google.common.eventbus.EventBus;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.delta.bank.notification.NotificationDataFactory;
import org.delta.bank.notification.NotifyCustomerEventFactory;
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
    @Inject
    private EventBus eventBus;
    @Inject
    private NotificationDataFactory notificationDataFactory;
    @Inject
    private NotifyCustomerEventFactory notifyCustomerEventFactory;

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
        notifyOwner(account);
        accounts.put(account.getAccountNumber(), account);
    }

    private void notifyOwner(BaseBankAccount account) {
        eventBus.post(notifyCustomerEventFactory.create(account.getOwner()));
    }

    public Map<String, BaseBankAccount> getAccounts() {
        return accounts;
    }
}
