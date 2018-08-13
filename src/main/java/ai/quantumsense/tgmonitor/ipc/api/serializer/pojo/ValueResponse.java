package ai.quantumsense.tgmonitor.ipc.api.serializer.pojo;

public class ValueResponse extends Response {

    public ValueResponse(Object value) {
        super(value, false);
    }

    @Override
    public String toString() {
        return "<" + value + ">";
    }
}
