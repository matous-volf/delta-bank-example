package org.delta.bank;

import com.google.inject.AbstractModule;
import org.delta.bank.print.ConsoleLogger;
import org.delta.bank.print.Logger;

public class BankInjector extends AbstractModule {
    @Override
    protected void configure() {
        this.bind(Logger.class).to(ConsoleLogger.class);
    }
}
