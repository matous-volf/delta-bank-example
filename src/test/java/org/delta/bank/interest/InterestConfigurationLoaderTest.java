package org.delta.bank.interest;

import org.delta.bank.account.BaseBankAccount;
import org.delta.bank.account.InterestAccount;
import org.delta.bank.account.SavingBankAccount;
import org.delta.bank.account.StudentBankAccount;
import org.delta.bank.calculator.Calculator;
import org.delta.bank.user.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

public class InterestConfigurationLoaderTest {
    @Test
    @DisplayName("student interest percent")
    public void studentAccount() {
        InterestConfigurationLoader interestConfigurationLoader = new InterestConfigurationLoader();
        InterestConfigurator configurator = interestConfigurationLoader.loadConfig(
                new StudentBankAccount(
                        new Owner(1, "John", "Doe"),
                        "123456789",
                        0
                )
        );
        assertEquals(1, configurator.getInterestPercent());
    }

    @Test
    @DisplayName("saving interest percent")
    public void savingAccount() {
        InterestConfigurationLoader interestConfigurationLoader = new InterestConfigurationLoader();
        InterestConfigurator configurator = interestConfigurationLoader.loadConfig(
                new SavingBankAccount(
                        new Owner(1, "John", "Doe"),
                        "123456789",
                        0
                )
        );
        assertEquals(8, configurator.getInterestPercent());
    }
}
