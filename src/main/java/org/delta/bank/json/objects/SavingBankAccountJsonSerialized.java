package org.delta.bank.json.objects;

public class SavingBankAccountJsonSerialized extends BaseBankAccountJsonSerialized {
    public SavingBankAccountJsonSerialized(String accountNumber, double balance, int ownerId) {
        super(accountNumber, balance, ownerId);
    }
}
