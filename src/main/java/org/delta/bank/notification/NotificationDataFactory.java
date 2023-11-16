package org.delta.bank.notification;

import org.delta.bank.user.Owner;

public class NotificationDataFactory {
    public NotificationData create(Owner owner) {
        return new NotificationData(owner.getFirstName());
    }
}
