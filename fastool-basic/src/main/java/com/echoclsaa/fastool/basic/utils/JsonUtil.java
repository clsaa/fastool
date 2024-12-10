package com.echoclsaa.fastool.basic.utils;


import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author clsaa
 */
public class JsonUtil {
    public static boolean isJson(String jsonString) {
        return JSON.isValid(jsonString);
    }

    public static String toJsonString(Object object) {
        return JSON.toJSONString(object);
    }

    public static <T> T toObject(String jsonString, Class<T> clazz) {
        return JSON.parseObject(jsonString, clazz);
    }

    public static <T> T toObject(Map jsonString, Class<T> clazz) {
        return JSON.parseObject(toJsonString(jsonString), clazz);
    }

    public static Map toMap(Object object) {
        return JSON.parseObject(toJsonString(object));
    }

    public static Map toMap(String jsonString) {
        return JSON.parseObject(jsonString);
    }


    public static <T> List<T> toArrayObject(String jsonString, Class<T> clazz) {
        return JSON.parseArray(jsonString, clazz);
    }

    public static String merge(String oldJson, String newJson) {
        JSONObject oldJsonObj = JSON.parseObject(oldJson);
        if (oldJsonObj == null) {
            oldJsonObj = new JSONObject();
        }
        JSONObject newJsonObj = JSON.parseObject(newJson);
        if (newJsonObj == null) {
            return oldJsonObj.toJSONString();
        }
        oldJsonObj.putAll(newJsonObj);
        return oldJsonObj.toJSONString();
    }


    public static <T> T getObjectFromKv(Map<String, Object> properties, String keyPrefix, Class<T> clazz) {
        String jsonStringFromKv = getJsonStringFromKv(properties, keyPrefix);

        T object = com.alibaba.fastjson2.JSON.parseObject(jsonStringFromKv, clazz);

        return object;
    }

    public static String getJsonStringFromKv(Map<String, Object> properties, String keyPrefix) {
        //一般情况下接口使用者不喜欢在最后额外加一个点
        if (!StringUtils.endsWithIgnoreCase(keyPrefix, ".")) {
            keyPrefix = keyPrefix + ".";
        }

        Map<String, Object> geiProperties = new HashMap<>();
        for (Map.Entry<String, Object> entry : properties.entrySet()) {
            if (entry.getKey().startsWith(keyPrefix)) {
                String newKey = entry.getKey().replace(keyPrefix, "");
                geiProperties.put(newKey, entry.getValue());
            }
        }
        String jsonStringFromKv = getJsonStringFromKv(geiProperties);
        return jsonStringFromKv;
    }

    /**
     * a.x=1
     * a.y=2
     * b.z=3
     * -->
     * {
     * "a": {
     * "x": 1,
     * "y": 2
     * },
     * "b": {
     * "z": 3
     * }
     * }
     */
    public static String getJsonStringFromKv(Map<String, Object> properties) {
        Map jsonObject = new HashMap();

        for (Map.Entry<String, Object> entry : properties.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            com.alibaba.fastjson2.JSONObject jsonCur = getJsonCur(key, value);
            jsonObject = deepMerge(jsonObject, jsonCur);
        }

        return com.alibaba.fastjson2.JSON.toJSONString(jsonObject);
    }

    private static JSONObject getJsonCur(String key, Object value) {
        com.alibaba.fastjson2.JSONObject jsonObject = new com.alibaba.fastjson2.JSONObject();
        String[] split = key.split("\\.");
        if (split.length == 1) {
            jsonObject.put(key, value);
            return jsonObject;
        }
        int firstIndexOfDot = key.indexOf(".");
        String restKey = key.substring(firstIndexOfDot + 1);

        com.alibaba.fastjson2.JSONObject jsonCur = getJsonCur(restKey, value);

        String currentKey = split[0];
        jsonObject.put(currentKey, jsonCur);

        return jsonObject;
    }

    private static Map deepMerge(Map original, Map newMap) {
        for (Object key : newMap.keySet()) {
            if (newMap.get(key) instanceof Map && original.get(key) instanceof Map) {
                Map originalChild = (Map) original.get(key);
                Map newChild = (Map) newMap.get(key);
                original.put(key, deepMerge(originalChild, newChild));
            } else if (newMap.get(key) instanceof List && original.get(key) instanceof List) {
                List originalChild = (List) original.get(key);
                List newChild = (List) newMap.get(key);
                for (Object each : newChild) {
                    if (!originalChild.contains(each)) {
                        originalChild.add(each);
                    }
                }
            } else {
                original.put(key, newMap.get(key));
            }
        }
        return original;
    }
}
