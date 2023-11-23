package org.delta.bank.interest;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.delta.bank.BankInjector;
import org.delta.bank.account.BaseBankAccount;
import org.delta.bank.account.SavingBankAccount;
import org.delta.bank.account.StudentBankAccount;
import org.delta.bank.user.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

public class InterestApplicatorTest {
    private final Injector injector = Guice.createInjector(new BankInjector());
    private InterestApplicator interestApplicator;

    @BeforeEach
    public void setup() {
        interestApplicator = injector.getInstance(InterestApplicator.class);
    }

    @Test
    @DisplayName("student interest percent")
    public void studentAccount() {
        BaseBankAccount account = new StudentBankAccount(
                new Owner(1, "John", "Doe"),
                "123456789",
                1000
        );

        interestApplicator.applyInterest(account);

        assertEquals(1010, account.getBalance());
    }

    @Test
    @DisplayName("saving interest percent")
    public void savingAccount() {
        BaseBankAccount account = new SavingBankAccount(
                new Owner(1, "John", "Doe"),
                "123456789",
                1000
        );

        interestApplicator.applyInterest(account);

        assertEquals(1080, account.getBalance());
    }

    @Test
    @DisplayName("base interest percent")
    public void baseAccount() {
        BaseBankAccount account = new BaseBankAccount(
                new Owner(1, "John", "Doe"),
                "123456789",
                1000
        );

        assertThrowsExactly(IllegalArgumentException.class, () -> interestApplicator.applyInterest(account));
    }
}
