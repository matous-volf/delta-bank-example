package org.delta.bank.user;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.delta.bank.json.objects.OwnerJsonSerialized;
import org.delta.bank.print.LogService;

@Singleton
public class OwnerJsonSerializedFactory {
    @Inject
    private LogService logService;
    @Inject
    private OwnerIdService ownerIdService;

    public OwnerJsonSerialized createOwnerJsonSerialized(Owner owner) {
        return new OwnerJsonSerialized(
                owner.getId(),
                owner.getFirstName(),
                owner.getLastName()
        );
    }
}
