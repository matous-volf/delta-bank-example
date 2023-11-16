package org.delta.bank.notification;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.delta.bank.print.Logger;

@Singleton
public class NotifyNewsletterEventListener {
    @Inject
    Logger logger;

    @Subscribe
    public void onNewsletterEvent(NotifyCustomerEvent event) {
        logger.log("# Sending newsletter to " + event.notificationData().customerName());
    }
}
