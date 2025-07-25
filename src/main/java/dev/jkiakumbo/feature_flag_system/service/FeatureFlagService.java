package dev.jkiakumbo.feature_flag_system.service;

import dev.jkiakumbo.feature_flag_system.model.FeatureFlag;
import dev.jkiakumbo.feature_flag_system.store.InMemoryStore;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class FeatureFlagService {
    private final InMemoryStore store;

    public FeatureFlagService(InMemoryStore store) {
        this.store = store;
    }

    public boolean isFeatureEnabled(String featureName, String userId) {
        FeatureFlag flag = store.getFlag(featureName);
        if (flag == null) {
            return false;
        }

        if (flag.getUserWhitelist().contains(userId)){
            return true;
        }

        if (flag.getRolloutPercentage() > 0) {
            return userId.hashCode() % 100 < flag.getRolloutPercentage();
        }

        return flag.isEnabled();
    }

    public Collection<FeatureFlag> getAllFeatureFlags() {
        return store.getAllFlags();
    }

    public FeatureFlag getFeatureFlag(String name) {
        return store.getFlag(name);
    }

    public void setFeatureFlag(String name, FeatureFlag flag) {
        store.setFlag(name, flag);
    }

    public FeatureFlag updateFeatureFlag(String name, FeatureFlag flag) {
        store.setFlag(name, flag);
        return store.getFlag(name);
    }

    public void deleteFeatureFlag(String name) {
        store.deleteFlag(name);
    }
}
