package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.Clear;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import com.google.protobuf.ByteString;
import org.junit.BeforeClass;
import org.junit.Test;
import qlua.rpc.RPC;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ClearRequestPbSerdeTest {

    private static SerdeModule sut;

    private static Clear.Request expectedObject;
    private static byte[] expectedPbInput;

    @BeforeClass
    public static void globalSetup() {

        sut = ProtobufSerdeModule.INSTANCE;

        expectedObject = new Clear.Request(1);
        final ByteString pbArgs = qlua.rpc.Clear.Request.newBuilder()
                .setTId(1)
                .build()
                .toByteString();
        expectedPbInput =
                RPC.Request.newBuilder()
                        .setType(RPC.ProcedureType.CLEAR)
                        .setArgs(pbArgs)
                        .build()
                        .toByteArray();
    }

    @Test
    public void testSerialize() {

        final byte[] actual = sut.serialize(expectedObject);

        assertTrue( Arrays.equals(expectedPbInput, actual) );
    }

    @Test
    public void testDeserialize() {

        final Clear.Request actualObject = sut.deserialize(Clear.Request.class, expectedPbInput);

        assertEquals(actualObject, expectedObject);
    }
}
