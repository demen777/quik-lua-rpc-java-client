package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetNumCandles;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

public class GetNumCandlesArgsPbSerdeTest extends AbstractPbSerializationTest<GetNumCandles.Args, qlua.rpc.GetNumCandles.Request> {

    private static final String TAG = "1";

    @Override
    public @NotNull Serializer<GetNumCandles.Args> getSerializerUnderTest() {
        return GetNumCandlesArgsPbSerializer.INSTANCE;
    }

    @NotNull
    @Override
    public qlua.rpc.GetNumCandles.Request getTargetObjectAsPbMessage() {

        return qlua.rpc.GetNumCandles.Request.newBuilder()
                .setTag(TAG)
                .build();
    }

    @NotNull
    @Override
    public GetNumCandles.Args getTargetObject() {
        return new GetNumCandles.Args(TAG);
    }
}
