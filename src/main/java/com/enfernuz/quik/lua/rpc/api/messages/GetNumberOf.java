package com.enfernuz.quik.lua.rpc.api.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.NonNull;
import lombok.Value;
import org.jetbrains.annotations.NotNull;

public final class GetNumberOf {

    @Value
    public static class Request {

        String tableName;

        public Request(@NonNull final String tableName) {
            this.tableName = tableName;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("table_name", tableName)
                    .toString();
        }
    }

    @Value
    public static class Result {

        int result;

        @JsonCreator
        public Result(final @JsonProperty(value = "result", required = true) int result) {
            this.result = result;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("result", result)
                    .toString();
        }
    }
}
