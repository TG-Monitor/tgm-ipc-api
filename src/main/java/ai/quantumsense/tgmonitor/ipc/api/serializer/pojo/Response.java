package ai.quantumsense.tgmonitor.ipc.api.serializer.pojo;

public abstract class Response {

    protected Object value;
    protected boolean isEmpty;

    protected Response(Object value, boolean isEmpty) {
        this.value = value;
        this.isEmpty = isEmpty;
    }

    public Object getValue() {
        return value;
    }

    public boolean isEmpty() {
        return isEmpty;
    }
}
