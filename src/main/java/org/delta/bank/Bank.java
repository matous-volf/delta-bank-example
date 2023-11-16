package org.delta.bank;

import com.google.inject.Inject;
import org.delta.bank.account.*;
import org.delta.bank.files.FileService;
import org.delta.bank.interest.InterestApplicator;
import org.delta.bank.json.JsonGenerator;
import org.delta.bank.json.JsonLoader;
import org.delta.bank.json.objects.BaseBankAccountJsonSerialized;
import org.delta.bank.json.objects.OwnerJsonSerialized;
import org.delta.bank.json.objects.SavingBankAccountJsonSerialized;
import org.delta.bank.json.objects.StudentBankAccountJsonSerialized;
import org.delta.bank.print.Logger;
import org.delta.bank.user.Owner;
import org.delta.bank.user.OwnerFactory;
import org.delta.bank.user.OwnerJsonSerializedFactory;
import org.delta.bank.user.OwnerService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Bank {
    @Inject
    private Logger logger;
    @Inject
    private JsonGenerator jsonGenerator;
    @Inject
    private InterestApplicator interestApplicator;
    @Inject
    private AccountService accountService;
    @Inject
    private BankAccountJsonSerializedFactory bankAccountJsonSerializedFactory;
    @Inject
    private OwnerFactory ownerFactory;
    @Inject
    OwnerJsonSerializedFactory ownerJsonSerializedFactory;
    @Inject
    private OwnerService ownerService;
    @Inject
    private FileService fileService;
    @Inject
    private JsonLoader jsonLoader;

    public void run() throws IOException {
        if (fileService.fileExists("data/owners.json")
                && fileService.fileExists("data/accounts_base.json")
                && fileService.fileExists("data/accounts_saving.json")
                && fileService.fileExists("data/accounts_student.json")) {
            jsonLoader.load(
                    fileService.readFile("data/owners.json"),
                    fileService.readFile("data/accounts_base.json"),
                    fileService.readFile("data/accounts_saving.json"),
                    fileService.readFile("data/accounts_student.json")
            );
        } else {
            Owner john = ownerService.addOwner("John", "Doe");
            Owner jane = ownerService.addOwner("Jane", "Doe");

            accountService.addBaseAccount(10000, john);
            accountService.addBaseAccount(12000, john);
            accountService.addBaseAccount(14000, jane);
            accountService.addSavingAccount(16000, john);
            accountService.addSavingAccount(18000, jane);
            accountService.addSavingAccount(20000, jane);
            accountService.addStudentAccount(22000, john);
            accountService.addStudentAccount(24000, jane);
            accountService.addStudentAccount(30000, jane);

            writeToFiles();
        }

        for (BaseBankAccount account : accountService.getAccounts().values()) {
            logger.logAccountInfo(account);
        }
    }

    private void writeToFiles() throws IOException {
        List<OwnerJsonSerialized> ownersJsonSerialized = new ArrayList<>();

        for (Owner owner : ownerService.getOwners().values()) {
            ownersJsonSerialized.add(ownerJsonSerializedFactory.createOwnerJsonSerialized(owner));
        }

        fileService.writeFile("data/owners.json", jsonGenerator.generateJsonString(ownersJsonSerialized));

        List<BaseBankAccountJsonSerialized> baseBankAccountsJsonSerialized = new ArrayList<>();
        List<StudentBankAccountJsonSerialized> studentBankAccountsJsonSerialized = new ArrayList<>();
        List<SavingBankAccountJsonSerialized> savingBankAccountsJsonSerialized = new ArrayList<>();

        for (BaseBankAccount account : accountService.getAccounts().values()) {
            BaseBankAccountJsonSerialized bankAccountJsonSerialized;

            if (account instanceof SavingBankAccount) {
                bankAccountJsonSerialized = bankAccountJsonSerializedFactory.createSavingAccount((SavingBankAccount) account);
                savingBankAccountsJsonSerialized.add((SavingBankAccountJsonSerialized) bankAccountJsonSerialized);
            } else if (account instanceof StudentBankAccount) {
                bankAccountJsonSerialized = bankAccountJsonSerializedFactory.createStudentAccount((StudentBankAccount) account);
                studentBankAccountsJsonSerialized.add((StudentBankAccountJsonSerialized) bankAccountJsonSerialized);
            } else {
                bankAccountJsonSerialized = bankAccountJsonSerializedFactory.createBaseAccount(account);
                baseBankAccountsJsonSerialized.add(bankAccountJsonSerialized);
            }
        }

        fileService.writeFile("data/accounts_saving.json", jsonGenerator.generateJsonString(savingBankAccountsJsonSerialized));
        fileService.writeFile("data/accounts_student.json", jsonGenerator.generateJsonString(studentBankAccountsJsonSerialized));
        fileService.writeFile("data/accounts_base.json", jsonGenerator.generateJsonString(baseBankAccountsJsonSerialized));
    }

    private void applyInterests() {
        logger.log("Before:");
        for (BaseBankAccount account : accountService.getAccounts().values()) {
            logger.logAccountInfo(account);
        }

        for (BaseBankAccount account : accountService.getAccounts().values()) {
            if (!(account instanceof InterestAccount)) {
                continue;
            }

            interestApplicator.applyInterest(account);
        }

        logger.log("After:");
        for (BaseBankAccount account : accountService.getAccounts().values()) {
            logger.logAccountInfo(account);
        }
    }
}
