package ai.quantumsense.tgmonitor.ipc.api.serializer;

import ai.quantumsense.tgmonitor.ipc.api.serializer.pojo.EmptyResponse;
import ai.quantumsense.tgmonitor.ipc.api.serializer.pojo.Request;
import ai.quantumsense.tgmonitor.ipc.api.serializer.pojo.Response;
import ai.quantumsense.tgmonitor.ipc.api.serializer.pojo.ValueResponse;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.List;

public class Serializer {

    private Gson gson = new Gson();

    public byte[] serializeRequest(Request request) {
        List<Object> l = request.getAsList();
        return str2bytes(gson.toJson(l));
    }

    public Request deserializeRequest(byte[] bytes) {
        Type t = (new TypeToken<List<Object>>() {}).getType();
        List<Object> l =  gson.fromJson(bytes2str(bytes), t);
        return new Request(l);
    }

    public byte[] serializeResponse(Response response) {
        if (response.isEmpty())
            return new byte[] {};
        else
            return str2bytes(gson.toJson(response.getValue()));
    }

    public Response deserializeResponse(byte[] bytes) {
        if (bytes.length == 0)
            return new EmptyResponse();
        else {
            Object value = gson.fromJson(bytes2str(bytes), Object.class);
            return new ValueResponse(value);
        }
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
