package com.bayuedekui.algorithmsketch.dynamic;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class lc10_正则表达式匹配 {
    public boolean isMatch(String s, String p) {
        sStr = s;
        pStr = p;
        return dp(0, 0);
    }

    //采用自顶而下的dp
    Map<String, Boolean> map = new HashMap<>();
    String sStr;
    String pStr;

    public boolean dp(int sStart, int pStart) {
        int sLen = sStr.length();
        int pLen = pStr.length();

        if(pStart==pLen){
            return sStart == sLen;
        }

        String key = sStart + "" + pStart;
        if (map.get(key) != null) {
            return map.get(key);
        }

        //当前字符不是“*”，只处理“.”或者相等字符
        boolean first = (sLen > sStart && (pStr.charAt(pStart) == '.' || pStr.charAt(pStart) == sStr.charAt(sStart)));

        //遇到“*”
        boolean res;
        if (pLen - 2 >= pStart && pStr.charAt(pStart + 1) == '*') {
            //跳过字母星号（a*）,配置字母星号
            res = dp(sStart, pStart + 2) || (first && dp(sStart + 1, pStart));
        } else {
            res = first && dp(sStart+1, pStart+1);
        }
        map.put(key, res);
        return res;

    }
}
