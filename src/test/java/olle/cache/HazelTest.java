package olle.cache;

import olle.person.Person;
import org.junit.Assert;
import org.junit.Test;

import javax.cache.Cache;

/**
 *
 */
public class HazelTest {

    @Test
    public void testCache() throws InterruptedException {
        final HazelCache hazel = new HazelCache();
        final Cache<String, Person> cache = hazel.initCache("test-1", hazel.initCacheManager(), String.class, Person.class);
        cache.put("Olle", Person.OLLE);
        Assert.assertEquals(Person.OLLE, cache.get("Olle"));
        Assert.assertNotSame(Person.OLLE, cache.get("Olle"));
    }
}
