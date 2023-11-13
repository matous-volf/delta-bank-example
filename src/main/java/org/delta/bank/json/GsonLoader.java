package org.delta.bank.json;

import com.google.gson.Gson;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.delta.bank.account.AccountService;
import org.delta.bank.account.BankAccountFactory;
import org.delta.bank.files.FileService;
import org.delta.bank.json.objects.BaseBankAccountJsonSerialized;
import org.delta.bank.json.objects.OwnerJsonSerialized;
import org.delta.bank.json.objects.SavingBankAccountJsonSerialized;
import org.delta.bank.json.objects.StudentBankAccountJsonSerialized;
import org.delta.bank.user.Owner;
import org.delta.bank.user.OwnerFactory;
import org.delta.bank.user.OwnerService;

@Singleton
public class GsonLoader implements JsonLoader {
    @Inject
    private OwnerService ownerService;
    @Inject
    private AccountService accountService;
    @Inject
    private OwnerFactory ownerFactory;
    @Inject
    private BankAccountFactory bankAccountFactory;
    @Inject
    private FileService fileService;
    @Inject
    private Gson gson;

    @Override
    public void load(
            String ownersJson,
            String baseBankAccountsJson,
            String studentBankAccountsJson,
            String savingBankAccountsJson) {
        OwnerJsonSerialized[] ownersJsonSerialized = gson.fromJson(ownersJson, OwnerJsonSerialized[].class);

        for (OwnerJsonSerialized ownerJsonSerialized : ownersJsonSerialized) {
            Owner owner = ownerFactory.createOwner(
                    ownerJsonSerialized.getId(),
                    ownerJsonSerialized.getFirstName(),
                    ownerJsonSerialized.getLastName()
            );
            ownerService.addOwner(owner);
        }

        BaseBankAccountJsonSerialized[] baseBankAccountsJsonSerialized = gson.fromJson(baseBankAccountsJson, BaseBankAccountJsonSerialized[].class);
        for (BaseBankAccountJsonSerialized accountJsonSerialized : baseBankAccountsJsonSerialized) {
            accountService.addBaseAccount(
                    accountJsonSerialized.getAccountNumber(),
                    accountJsonSerialized.getBalance(),
                    ownerService.getOwners().get(accountJsonSerialized.getOwnerId())
            );
        }

        SavingBankAccountJsonSerialized[] savingBankAccountsJsonSerialized = gson.fromJson(savingBankAccountsJson, SavingBankAccountJsonSerialized[].class);
        for (SavingBankAccountJsonSerialized accountJsonSerialized : savingBankAccountsJsonSerialized) {
            accountService.addSavingAccount(
                    accountJsonSerialized.getAccountNumber(),
                    accountJsonSerialized.getBalance(),
                    ownerService.getOwners().get(accountJsonSerialized.getOwnerId())
            );
        }

        StudentBankAccountJsonSerialized[] studentBankAccountsJsonSerialized = gson.fromJson(studentBankAccountsJson, StudentBankAccountJsonSerialized[].class);
        for (StudentBankAccountJsonSerialized accountJsonSerialized : studentBankAccountsJsonSerialized) {
            accountService.addStudentAccount(
                    accountJsonSerialized.getAccountNumber(),
                    accountJsonSerialized.getBalance(),
                    ownerService.getOwners().get(accountJsonSerialized.getOwnerId())
            );
        }
    }
}
