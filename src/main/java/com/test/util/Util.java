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

    public static String generateInsert(String code, String description, String stateId) {
        String str = "INSERT INTO district (`code`, `description`, `stateID`, `status`, `createdBy`) VALUES ('${code}', '${description}', ${stateId}, 3, 1);";
        Map<String, String> data = new HashMap<String, String>();
        data.put("code", code);
        data.put("description", description);
        data.put("stateId", stateId);
        String formattedString = StrSubstitutor.replace(str, data);
        return formattedString;
    }
    
    public static String generateInsertForItemCategory(String code, String description) {
        String str = "INSERT INTO itemcategory (`code`, `description`, `status`, `createdBy`) VALUES ('${code}', '${description}', 3, 1);";
        Map<String, String> data = new HashMap<String, String>();
        data.put("code", code);
        data.put("description", description);        
        String formattedString = StrSubstitutor.replace(str, data);
        return formattedString;
    }
    
    public static String generateInsertForItemGroup(String code, String description) {
        String str = "INSERT INTO itemgroup (`code`, `description`, `status`, `createdBy`) VALUES ('${code}', '${description}', 3, 1);";
        Map<String, String> data = new HashMap<String, String>();
        data.put("code", code);
        data.put("description", description);        
        String formattedString = StrSubstitutor.replace(str, data);
        return formattedString;
    }
    
    public static String generateInsertForItemType(String code, String description) {
        String str = "INSERT INTO itemtype (`code`, `description`, `status`, `createdBy`) VALUES ('${code}', '${description}', 3, 1);";
        Map<String, String> data = new HashMap<String, String>();
        data.put("code", code);
        data.put("description", description);        
        String formattedString = StrSubstitutor.replace(str, data);
        return formattedString;
    }
}
