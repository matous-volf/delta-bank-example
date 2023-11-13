package org.delta.bank.account;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.delta.bank.json.objects.BaseBankAccountJsonSerialized;
import org.delta.bank.json.objects.SavingBankAccountJsonSerialized;
import org.delta.bank.json.objects.StudentBankAccountJsonSerialized;
import org.delta.bank.print.LogService;
import org.delta.bank.user.Owner;

@Singleton
public class BankAccountJsonSerializedFactory {
    public BaseBankAccountJsonSerialized createBaseAccount(BaseBankAccount account) {
        return new BaseBankAccountJsonSerialized(
                account.getAccountNumber(),
                account.getBalance(),
                account.getOwner().getId()
        );
    }

    public SavingBankAccountJsonSerialized createSavingAccount(SavingBankAccount account) {
        return new SavingBankAccountJsonSerialized(
                account.getAccountNumber(),
                account.getBalance(),
                account.getOwner().getId()
        );
    }

    public StudentBankAccountJsonSerialized createStudentAccount(StudentBankAccount account) {
        return new StudentBankAccountJsonSerialized(
                account.getAccountNumber(),
                account.getBalance(),
                account.getOwner().getId()
        );
    }
}
