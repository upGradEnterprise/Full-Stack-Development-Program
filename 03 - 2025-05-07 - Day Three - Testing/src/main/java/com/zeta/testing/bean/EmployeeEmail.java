package com.zeta.testing.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmployeeEmail {
    private Map<Object, String> emailMap = new HashMap<Object, String>();

    public void addEmployeeEmail(Object key, String value) {
        if(isValidEmailId(value)) emailMap.put(key, value);
    }

    public String getEmployeeEmailId(Object key) {
        if(!(key instanceof String)) throw new IllegalArgumentException("key is not a Object");
        return emailMap.get(key);
    }

    public boolean isValidEmailId(String emailId) {
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(emailId);
        return matcher.matches();
    }

    public Map<Object, String> getEmailMap() {
        return emailMap;
    }

}
