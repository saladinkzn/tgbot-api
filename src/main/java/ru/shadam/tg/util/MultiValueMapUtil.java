package ru.shadam.tg.util;

import org.springframework.util.MultiValueMap;

/**
 * @author sala
 */
public class MultiValueMapUtil {
    public static <K> void addIfNotNull(MultiValueMap<K, Object> map, K key, Object value) {
        if (value != null) {
            map.add(key, String.valueOf(value));
        }
    }
}
