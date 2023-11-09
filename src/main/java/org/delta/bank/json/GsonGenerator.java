package org.delta.bank.json;

import com.google.gson.Gson;
import com.google.inject.Inject;
import org.delta.bank.user.Owner;

public class GsonGenerator implements JsonGenerator {
    @Inject
    Gson gson;

    @Override
    public String generateJsonString(Owner owner) {
        return gson.toJson(owner);
    }
}
