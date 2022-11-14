package com.aldwx.aldsdk;

import android.util.Log;

import org.json.JSONObject;

import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReNameRule {
    public static final String REGEX_ACCOUNT = "^[a-zA-Z][a-zA-Z0-9_]{0,65}$";
    public static final String RESUT_KEY_WORD_OK = "ok";

    // 预定义事件名
    public String checkPredeName(String eventName) {
        if (eventName.matches(REGEX_ACCOUNT) && !isStartWithNumber(eventName)) {
            if (eventName.startsWith("Ald")) {




                return checkKeyWord(eventName);

            } else {

                return "ERR_API_EVENT_ARGS_PREDIFINE_WRONG";
            }
        } else {
            return "ERR_API_EVENT_ARGS_WRONG";
        }

    }

    // 预定义属性名
    public String checkPredJson(JSONObject eventName) {
        Iterator<String> keys = eventName.keys();

        String name;
        while (keys.hasNext()) {
            name = keys.next();
            if (name.matches(REGEX_ACCOUNT) && !isStartWithNumber(name)) {

                String check = checkKeyWord(name);
                if (RESUT_KEY_WORD_OK.equals(check)) {
                    if (name.startsWith("ald_")) {
                        break;
                    } else {
                        return "ERR_API_PROPS_ARGS_PREDIFINE_WRONG";

                    }
                } else {
                    return check;
                }
            } else {
                return "ERR_API_EVENT_ARGS_WRONG";
            }
        }
        return "ok";
    }


    // 自定义事件名
    public String checkName(String eventName) {
        if (eventName.matches(REGEX_ACCOUNT) && !isStartWithNumber(eventName)) {
            if (!eventName.startsWith("Ald")) {


                return checkKeyWord(eventName);

            } else {
                return "ERR_API_EVENT_ARGS_CUSTOM_WRONG";
            }
        } else {
            return "ERR_API_EVENT_ARGS_WRONG";
        }

    }


    // 自定义事件名
    public String checkJson(JSONObject eventName) {
        Iterator<String> keys = eventName.keys();

        String name;
        while (keys.hasNext()) {
            name = keys.next();

            if (name.matches(REGEX_ACCOUNT) && !isStartWithNumber(name)) {
                if (!name.startsWith("ald_")) {

                    String check = checkKeyWord(name);
                    if (RESUT_KEY_WORD_OK.equals(check)) {
                        break;
                    }
                    return check;

                } else {
                    return "ERR_API_PROPS_ARGS_CUSTOM_WRONG";
                }
            } else {
                return "ERR_API_EVENT_ARGS_WRONG";
            }
        }

        return "ok";
    }


    public String checkKeyWord(String eventName) {
        if (eventName.equals("date") || eventName.equals("datetime")
                || eventName.equals("distinct_id")
                || eventName.equals("event")
                || eventName.equals("events")
                || eventName.equals("event_id")
                || eventName.equals("first_id")
                || eventName.equals("id")
                || eventName.equals("original_id")
                || eventName.equals("device_id")
                || eventName.equals("properties")
                || eventName.equals("second_id")
                || eventName.equals("time")
                || eventName.equals("user_id")
                || eventName.equals("users")
                || eventName.startsWith("user_group")
                || eventName.startsWith("user_tag")) {
            return "ERR_API_EVENT_ARGS_KEYWORDS";
        }

        return "ok";

    }

    //判断字符串是不是以数字开头
    public static boolean isStartWithNumber(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str.charAt(0) + "");
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

}
