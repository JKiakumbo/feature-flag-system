package dev.jkiakumbo.feature_flag_system.store;

import dev.jkiakumbo.feature_flag_system.model.FeatureFlag;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryStore {
    private Map<String, FeatureFlag> flags = new ConcurrentHashMap<>();

    public FeatureFlag getFlag(String name) {
        return flags.get(name);
    }

    public void setFlag(String name, FeatureFlag flag) {
        flags.put(name, flag);
    }

    public Collection<FeatureFlag> getAllFlags() {
        return flags.values();
    }

    public void deleteFlag(String name) {
        flags.remove(name);
    }
}
