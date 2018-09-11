package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetLinesCount;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import com.google.protobuf.ByteString;
import org.junit.BeforeClass;
import org.junit.Test;
import qlua.rpc.RPC;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GetLinesCountRequestPbSerdeTest {

    private static SerdeModule sut;

    private static GetLinesCount.Request expectedObject;
    private static byte[] expectedPbInput;

    @BeforeClass
    public static void globalSetup() {

        sut = ProtobufSerdeModule.INSTANCE;

        expectedObject = new GetLinesCount.Request("1");
        final ByteString pbArgs = qlua.rpc.GetLinesCount.Request.newBuilder()
                .setTag("1")
                .build()
                .toByteString();
        expectedPbInput =
                RPC.Request.newBuilder()
                        .setType(RPC.ProcedureType.GET_LINES_COUNT)
                        .setArgs(pbArgs)
                        .build()
                        .toByteArray();
    }

    @Test
    public void testSerialize() {

        assertTrue(
                Arrays.equals(expectedPbInput, sut.serialize(expectedObject))
        );
    }

    @Test
    public void testDeserialize() {
        assertEquals(expectedObject, sut.deserialize(GetLinesCount.Request.class, expectedPbInput));
    }
}
