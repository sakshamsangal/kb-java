package com.example.demo.db_cache;

import com.hazelcast.config.*;
import org.springframework.context.annotation.*;

@Configuration
public class ProductCacheConfig {
    @Bean
    public Config cacheConfig() {
        Config config = new Config();
        config.setInstanceName("hazel-instance");
        config.addMapConfig(mapConfig());
        return config;
    }

    private MapConfig mapConfig() {
        MapConfig mapConfig = new MapConfig();
        mapConfig.setName("product-cache");
        mapConfig.setTimeToLiveSeconds(360);
        mapConfig.setMaxIdleSeconds(20);
        return mapConfig;
    }

}
