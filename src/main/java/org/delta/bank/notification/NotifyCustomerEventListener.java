package org.delta.bank.notification;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.delta.bank.print.Logger;

@Singleton
public class NotifyCustomerEventListener {
    @Inject
    Logger logger;

    @Subscribe
    public void onNotifyEvent(NotifyCustomerEvent event) {
        logger.log("# Sending notification to " + event.notificationData().customerName());
    }
}
