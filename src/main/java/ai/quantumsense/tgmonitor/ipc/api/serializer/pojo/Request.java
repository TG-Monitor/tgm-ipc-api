package ai.quantumsense.tgmonitor.ipc.api.serializer.pojo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Request {
    private String name;
    private List<Object> args;

    public Request(String name, Object... args) {
        this.name = name;
        this.args = Arrays.asList(args);
    }

    public Request(List<Object> l) {
        name = (String) l.get(0);
        args = l.size() > 1 ? l.subList(1, l.size()) : Collections.EMPTY_LIST;
    }

    public String getName() {
        return name;
    }

    public List<Object> getArgs() {
        return new ArrayList<>(args);
    }

    public List<Object> getAsList() {
        List<Object> l = new ArrayList<>();
        l.add(name);
        l.addAll(args);
        return l;
    }

    @Override
    public String toString() {
        return "<name=" + name + ", args=" + args + ">";
    }
}
