package org.delta.bank;

import com.google.common.eventbus.EventBus;
import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.matcher.Matchers;
import com.google.inject.spi.InjectionListener;
import com.google.inject.spi.TypeEncounter;
import com.google.inject.spi.TypeListener;
import org.delta.bank.json.GsonGenerator;
import org.delta.bank.json.GsonLoader;
import org.delta.bank.json.JsonGenerator;
import org.delta.bank.json.JsonLoader;
import org.delta.bank.print.ConsoleLogger;
import org.delta.bank.print.Logger;

public class BankInjector extends AbstractModule {
    private final EventBus eventBus = new EventBus("Default EventBus");

    @Override
    protected void configure() {
        this.bind(Logger.class).to(ConsoleLogger.class);
        this.bind(JsonGenerator.class).to(GsonGenerator.class);
        this.bind(JsonLoader.class).to(GsonLoader.class);

        this.bind(EventBus.class).toInstance(eventBus);
        bindListener(Matchers.any(), new TypeListener() {
            public <I> void hear(TypeLiteral<I> type, TypeEncounter<I> encounter) {
                encounter.register(new InjectionListener<I>(){
                    public void afterInjection(I i) {
                        eventBus.register(i);
                    }
                });
            }
        });
    }
}
