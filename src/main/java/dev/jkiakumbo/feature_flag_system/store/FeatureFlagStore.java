package dev.jkiakumbo.feature_flag_system.store;

import dev.jkiakumbo.feature_flag_system.model.FeatureFlag;

import java.util.Collection;

public interface FeatureFlagStore {
    FeatureFlag getFlag(String name);
    void setFlag(String name, FeatureFlag flag);
    Collection<FeatureFlag> getAllFlags();
    void deleteFlag(String name);
}
