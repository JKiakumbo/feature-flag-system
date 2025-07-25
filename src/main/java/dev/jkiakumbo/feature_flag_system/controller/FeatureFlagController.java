package dev.jkiakumbo.feature_flag_system.controller;

import dev.jkiakumbo.feature_flag_system.model.FeatureFlag;
import dev.jkiakumbo.feature_flag_system.service.FeatureFlagService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Map;

@RestController
@RequestMapping("/api/flags")
public class FeatureFlagController {
    private final FeatureFlagService service;

    public FeatureFlagController(FeatureFlagService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> getAllFlags() {
        Collection<FeatureFlag> flags = service.getAllFeatureFlags();
        return ResponseEntity.ok(flags);
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getFlag(@PathVariable String name) {
        FeatureFlag flag = service.getFeatureFlag(name);
        return ResponseEntity.ok(flag);
    }

    @GetMapping("/{name}/status")
    public ResponseEntity<?> checkFlag(
            @PathVariable String name,
            @RequestParam String userId
    ) {
        boolean isEnabled = service.isFeatureFlagEnabled(name, userId);
        return ResponseEntity.ok(Map.of("enabled", isEnabled));
    }

    @PostMapping
    public ResponseEntity<?> setFlag(@RequestBody FeatureFlag flag) {
        service.setFeatureFlag(flag.getName(), flag);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{name}")
    public ResponseEntity<?> updateFlag(
            @PathVariable String name,
            @RequestBody FeatureFlag flag)
    {
        FeatureFlag featureFlag = service.updateFeatureFlag(name, flag);
        return ResponseEntity.ok(featureFlag);
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<?> deleteFlag(@PathVariable  String name) {
        service.deleteFeatureFlag(name);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
