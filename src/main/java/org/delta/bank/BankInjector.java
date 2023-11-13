package org.delta.bank;

import com.google.inject.AbstractModule;
import org.delta.bank.json.GsonGenerator;
import org.delta.bank.json.GsonLoader;
import org.delta.bank.json.JsonGenerator;
import org.delta.bank.json.JsonLoader;
import org.delta.bank.print.ConsoleLogger;
import org.delta.bank.print.Logger;

public class BankInjector extends AbstractModule {
    @Override
    protected void configure() {
        this.bind(Logger.class).to(ConsoleLogger.class);
        this.bind(JsonGenerator.class).to(GsonGenerator.class);
        this.bind(JsonLoader.class).to(GsonLoader.class);
    }
}
