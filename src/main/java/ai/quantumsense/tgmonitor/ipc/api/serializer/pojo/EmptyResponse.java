package ai.quantumsense.tgmonitor.ipc.api.serializer.pojo;

public class EmptyResponse extends Response {

    public EmptyResponse() {
        super(null, true);
    }

    @Override
    public String toString() {
        return "<>";
    }
}
