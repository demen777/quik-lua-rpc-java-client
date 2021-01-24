package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.RemoteProcedure;
import com.enfernuz.quik.lua.rpc.api.RpcResult;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.Value;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class Ping implements RemoteProcedure {

    private Ping() {}

    @Value
    public static class Result implements RpcResult<Ping> {

        private static final String RESULT = "result";

        Long result;

        @JsonCreator
        public static Ping.Result getInstance(@JsonProperty(RESULT) final Long result) {

            if ( isError(result) ) {
                return Ping.Result.InstanceHolder.ERROR;
            }

            return new Ping.Result(result);
        }

        public static Ping.Result getErrorInstance() {
            return Ping.Result.InstanceHolder.ERROR;
        }

        private Result(final Long result) {
            this.result = result;
        }

        public boolean isError() {
            return isError(result);
        }

        @Contract(value = "null -> true; !null -> false", pure = true)
        private static boolean isError(final Long result) {
            return result == null;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(RESULT, result)
                    .toString();
        }

        private static final class InstanceHolder {

            private static final Ping.Result ERROR = new Ping.Result(null);

            // sanity check
            static {
                assert ERROR.isError();
            }
        }
    }
}
