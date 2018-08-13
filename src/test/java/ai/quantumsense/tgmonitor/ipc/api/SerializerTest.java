package ai.quantumsense.tgmonitor.ipc.api;

import ai.quantumsense.tgmonitor.ipc.api.serializer.Serializer;
import ai.quantumsense.tgmonitor.ipc.api.serializer.pojo.EmptyResponse;
import ai.quantumsense.tgmonitor.ipc.api.serializer.pojo.Request;
import ai.quantumsense.tgmonitor.ipc.api.serializer.pojo.Response;
import ai.quantumsense.tgmonitor.ipc.api.serializer.pojo.ValueResponse;
import org.junit.Assert;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class SerializerTest {

    private Serializer serializer = new Serializer();

    @Test
    public void serializeNoArgRequest() {
        Request request = new Request("logout");
        String expected = "[\"logout\"]";
        byte[] bytes = serializer.serializeRequest(request);
        Assert.assertEquals(expected, bytes2str(bytes));
    }

    @Test
    public void serializeSimpleArgRequest() {
        Request request = new Request("add_peer", "foo");
        String expected = "[\"add_peer\",\"foo\"]";
        byte[] bytes = serializer.serializeRequest(request);
        Assert.assertEquals(expected, bytes2str(bytes));
    }

    @Test
    public void serializeArrayArgRequest() {
        Set<String> set = new HashSet<>(Arrays.asList("foo"));
        Request request = new Request("add_peers", set);
        String expected = "[\"add_peers\",[\"foo\"]]";
        byte[] bytes = serializer.serializeRequest(request);
        Assert.assertEquals(expected, bytes2str(bytes));
    }

    @Test
    public void serializeEmptyResponse() {
        Response response = new EmptyResponse();
        String expected = "";
        byte[] bytes = serializer.serializeResponse(response);
        Assert.assertEquals(expected, bytes2str(bytes));
    }

    @Test
    public void serializeNullResponse() {
        Response response = new ValueResponse(null);
        String expected = "null";
        byte[] bytes = serializer.serializeResponse(response);
        Assert.assertEquals(expected, bytes2str(bytes));
    }

    @Test
    public void serializeBooleanResponse() {
        Response response = new ValueResponse(true);
        String expected = "true";
        byte[] bytes = serializer.serializeResponse(response);
        Assert.assertEquals(expected, bytes2str(bytes));
    }

    @Test
    public void serializeStringResponse() {
        Response response = new ValueResponse("foo");
        String expected = "\"foo\"";
        byte[] bytes = serializer.serializeResponse(response);
        Assert.assertEquals(expected, bytes2str(bytes));
    }

    @Test
    public void serializeArrayResponse() {
        Set<String> set = new HashSet<>(Arrays.asList("foo"));
        Response response = new ValueResponse(set);
        String expected = "[\"foo\"]";
        byte[] bytes = serializer.serializeResponse(response);
        Assert.assertEquals(expected, bytes2str(bytes));
    }

    @Test
    public void deserializeNoArgRequest() {
        byte[] bytes = str2bytes("[\"logout\"]");
        Request expected = new Request("logout");
        Request actual = serializer.deserializeRequest(bytes);

        Assert.assertEquals(expected.getName(), actual.getName());

        List<Object> argsExpected = expected.getArgs();
        List<Object> argsActual = actual.getArgs();
        for (int i = 0; i < argsExpected.size(); i++) {
            Assert.assertEquals(argsExpected.get(i).toString(), argsActual.get(i).toString());
        }

        Assert.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void deserializeSimpleArgRequest() {
        byte[] bytes = str2bytes("[\"add_peer\",\"foo\"]");
        Request expected = new Request("add_peer", "foo");
        Request actual = serializer.deserializeRequest(bytes);

        Assert.assertEquals(expected.getName(), actual.getName());

        List<Object> argsExpected = expected.getArgs();
        List<Object> argsActual = actual.getArgs();
        for (int i = 0; i < argsExpected.size(); i++) {
            Assert.assertEquals(argsExpected.get(i).toString(), argsActual.get(i).toString());
        }

        Assert.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void deserializeArrayArgRequest() {
        byte[] bytes = str2bytes("[\"add_peer\",[\"foo\"]]");
        Set<String> set = new HashSet<>(Arrays.asList("foo"));
        Request expected = new Request("add_peer", set);
        Request actual = serializer.deserializeRequest(bytes);

        Assert.assertEquals(expected.getName(), actual.getName());

        List<Object> argsExpected = expected.getArgs();
        List<Object> argsActual = actual.getArgs();
        for (int i = 0; i < argsExpected.size(); i++) {
            Assert.assertEquals(argsExpected.get(i).toString(), argsActual.get(i).toString());
        }

        Assert.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void deserializeEmptyResponse1() {
        byte[] bytes = new byte[] {};
        Response expected = new EmptyResponse();
        Response actual = serializer.deserializeResponse(bytes);
        Assert.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void deserializeEmptyResponse2() {
        byte[] bytes = str2bytes("");
        Response expected = new EmptyResponse();
        Response actual = serializer.deserializeResponse(bytes);
        Assert.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void deserializeNullResponse() {
        byte[] bytes = str2bytes("null");
        Response expected = new ValueResponse(null);
        Response actual = serializer.deserializeResponse(bytes);
        Assert.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void deserializeBooleanResponse() {
        byte[] bytes = str2bytes("true");
        Response expected = new ValueResponse(true);
        Response actual = serializer.deserializeResponse(bytes);
        Assert.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void deserializeStringResponse() {
        byte[] bytes = str2bytes("\"foo\"");
        Response expected = new ValueResponse("foo");
        Response actual = serializer.deserializeResponse(bytes);
        Assert.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void deserializeArrayResponse() {
        byte[] bytes = str2bytes("[\"foo\"]");
        Set<String> set = new HashSet<>(Arrays.asList("foo"));
        Response expected = new ValueResponse(set);
        Response actual = serializer.deserializeResponse(bytes);
        Assert.assertEquals(expected.toString(), actual.toString());
    }

    private String bytes2str(byte[] bytes) {
        String str = null;
        try {
            str = new String(bytes, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return str;
    }

    private byte[] str2bytes(String str) {
        byte[] bytes = null;
        try {
            bytes = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return bytes;
    }
}