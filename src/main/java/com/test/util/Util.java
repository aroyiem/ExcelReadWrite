/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.util;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.text.StrSubstitutor;

/**
 *
 * @author 330085
 */
public class Util {

    public static String generateInsert(String code, String name, String stateId) {
        String str = "INSERT INTO city (`code`, `name`, `stateId`, `status`, `createdBy`) VALUES ('${code}', '${name}', ${stateId}, 3, 1);";
        Map<String, String> data = new HashMap<String, String>();
        data.put("code", code);
        data.put("name", name);
        data.put("stateId", stateId);
        String formattedString = StrSubstitutor.replace(str, data);
        return formattedString;
    }
}
