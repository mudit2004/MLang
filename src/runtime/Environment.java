package runtime;

import java.util.HashMap;
import java.util.Map;

public class Environment {
    private final Map<String, Object> values = new HashMap<>();

    public void define(String name, Object value) {
        values.put(name, value);
    }

    public void assign(String name, Object value) {
        if (values.containsKey(name)) {
            values.put(name, value);
        } else {
            throw new RuntimeException("Undefined variable '" + name + "'.");
        }
    }

    public Object get(String name) {
        if (values.containsKey(name)) {
            return values.get(name);
        }
        throw new RuntimeException("Undefined variable '" + name + "'.");
    }
}