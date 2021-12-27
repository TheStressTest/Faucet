package io.thestresstest.faucet;

import com.google.gson.Gson;
import io.javalin.plugin.json.JsonMapper;
import org.jetbrains.annotations.NotNull;

public class GsonMapper implements JsonMapper {
    @NotNull
    @Override
    public String toJsonString(@NotNull Object obj) {
        return new Gson().toJson(obj);
    }
}