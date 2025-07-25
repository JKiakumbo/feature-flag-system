package dev.jkiakumbo.feature_flag_system.model;

import java.util.Objects;
import java.util.Set;

public class FeatureFlag {
    private String name;
    private boolean enabled;
    private Set<String> userWhitelist;
    private double rolloutPercentage;

    public FeatureFlag(String name, boolean enabled, Set<String> userWhitelist, double rolloutPercentage) {
        this.name = name;
        this.enabled = enabled;
        this.userWhitelist = userWhitelist;
        this.rolloutPercentage = rolloutPercentage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<String> getUserWhitelist() {
        return userWhitelist;
    }

    public void setUserWhitelist(Set<String> userWhitelist) {
        this.userWhitelist = userWhitelist;
    }

    public double getRolloutPercentage() {
        return rolloutPercentage;
    }

    public void setRolloutPercentage(double rolloutPercentage) {
        this.rolloutPercentage = rolloutPercentage;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        FeatureFlag that = (FeatureFlag) o;
        return enabled == that.enabled && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, enabled);
    }
}
