package olle.cache;

import olle.person.Person;

import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.expiry.AccessedExpiryPolicy;
import javax.cache.expiry.Duration;
import javax.cache.spi.CachingProvider;
import java.net.URI;

/**
 *
 */
public class HazelCache {

    protected CachingProvider cachingProvider;

    public CacheManager initCacheManager(URI uri) {
        //resolve a cache manager
        cachingProvider = Caching.getCachingProvider();
        return cachingProvider.getCacheManager(uri, null);
    }

    public CacheManager initCacheManager() {
        return initCacheManager(null);
    }

    /**
     * we initialize a cache with name
     *
     * @param name
     */
    public <K,V> Cache<K, V>  initCache(String name, CacheManager cacheManager, Class<K> keyClass, Class<V> valueClass) {
        Cache<K, V> cache = cacheManager.getCache(name, keyClass, valueClass);
        if (cache != null)
            return cache;
        //configure the cache
        MutableConfiguration<K, V> config = new MutableConfiguration<>();

        config.setStoreByValue(true)
                .setTypes(keyClass, valueClass)
                .setExpiryPolicyFactory(AccessedExpiryPolicy.factoryOf(Duration.TEN_MINUTES))
                .setStatisticsEnabled(false);

        //create the cache
        return cacheManager.createCache(name, config);
    }

}
