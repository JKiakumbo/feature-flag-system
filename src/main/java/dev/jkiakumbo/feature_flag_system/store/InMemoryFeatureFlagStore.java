package dev.jkiakumbo.feature_flag_system.store;

import dev.jkiakumbo.feature_flag_system.model.FeatureFlag;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryFeatureFlagStore implements FeatureFlagStore {
    private Map<String, FeatureFlag> flags = new ConcurrentHashMap<>();

    @Override
    public FeatureFlag getFlag(String name) {
        return flags.get(name);
    }

    @Override
    public void setFlag(String name, FeatureFlag flag) {
        flags.put(name, flag);
    }

    @Override
    public Collection<FeatureFlag> getAllFlags() {
        return flags.values();
    }

    @Override
    public void deleteFlag(String name) {
        flags.remove(name);
    }
}
