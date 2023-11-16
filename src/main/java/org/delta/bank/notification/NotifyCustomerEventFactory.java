package org.delta.bank.notification;

import com.google.inject.Inject;
import org.delta.bank.user.Owner;

public class NotifyCustomerEventFactory {
    @Inject
    private NotificationDataFactory notificationDataFactory;

    public NotifyCustomerEvent create(Owner owner) {
        return new NotifyCustomerEvent(notificationDataFactory.create(owner));
    }
}
