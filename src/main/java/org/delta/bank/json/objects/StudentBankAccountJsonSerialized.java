package org.delta.bank.json.objects;

public class StudentBankAccountJsonSerialized extends BaseBankAccountJsonSerialized {
    public StudentBankAccountJsonSerialized(String accountNumber, double balance, int ownerId) {
        super(accountNumber, balance, ownerId);
    }
}
