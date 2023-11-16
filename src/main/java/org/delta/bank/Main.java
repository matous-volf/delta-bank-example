package org.delta.bank;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.delta.bank.notification.NotifyCustomerEventListener;
import org.delta.bank.notification.NotifyNewsletterEventListener;

public class Main {
    public static void main(String[] args) {
        try {
            Injector injector = Guice.createInjector(new BankInjector());
            Bank bank = injector.getInstance(Bank.class);

            injector.getInstance(NotifyCustomerEventListener.class);
            injector.getInstance(NotifyNewsletterEventListener.class);

            bank.run();
        } catch (Exception e) {
            System.out.println("ERROR");
            e.printStackTrace();
        }
    }
}