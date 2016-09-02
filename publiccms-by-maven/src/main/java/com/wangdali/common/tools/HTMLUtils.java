package com.wangdali.common.tools;

import java.util.regex.Pattern;

import com.wangdali.common.base.Base;

public class HTMLUtils extends Base {
    public static final Pattern HTML_PATTERN = Pattern.compile("<[^>]+>");

    public static String removeHtmlTag(String string) {
        if (notEmpty(string)) {
            return HTML_PATTERN.matcher(string).replaceAll(BLANK);
        }
        return string;
    }
}
