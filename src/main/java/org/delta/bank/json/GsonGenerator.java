package org.delta.bank.json;

import com.google.gson.Gson;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.delta.bank.user.Owner;

@Singleton
public class GsonGenerator implements JsonGenerator {
    @Inject
    Gson gson;

    @Override
    public String generateJsonString(Object object) {
        return gson.toJson(object);
    }
}
