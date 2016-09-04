package com.wangdali.common.base;

import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static org.apache.commons.logging.LogFactory.getLog;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.logging.Log;

/*
 * 抽象基类
 */
public abstract class Base {
    public static final Random r = new Random(); // 随机数
    public static final String DEFAULT_CHARSET = "UTF-8"; // 默认编码字符集
    public static final String SEPARATOR = "/"; // 分割符
    public static final String BLANK = ""; // 空
    public static final String BLANK_SPACE = " "; // 空格
    public static final String COMMA_DELIMITED = ","; // 逗号分割符
    protected final Log log = getLog(getClass()); // 日志

    /*
     * 获得日期时间
     */
    public static Date getDate() {
        return new Date();
    }

    /*
     * 判断字符串不为空
     */
    public static boolean notEmpty(String var) {
        return isNotBlank(var);
    }

    /*
     * 判断字符串为空
     */
    public static boolean empty(String var) {
        return isBlank(var);
    }

    /*
     * 判断对象不为空
     */
    public static boolean notEmpty(Object var) {
        return null != var;
    }

    /*
     * 判断链表不为空
     */
    public static boolean notEmpty(List<?> var) {
        return null != var && !var.isEmpty();
    }

    /*
     * 判断映射不为空
     */
    public static boolean notEmpty(Map<?, ?> var) {
        return null != var && !var.isEmpty();
    }

    /*
     * 判断链表为空
     */
    public static boolean empty(List<?> var) {
        return null == var || var.isEmpty();
    }

    /*
     * 判断映射为空
     */
    public static boolean empty(Map<?, ?> var) {
        return null == var || var.isEmpty();
    }

    /*
     * 判断对象为空
     */
    public static boolean empty(Object var) {
        return null == var;
    }

    /*
     * 判断文件为空
     */
    public static boolean empty(File file) {
        return null == file || !file.exists();
    }

    /*
     * 判断文件不为空
     */
    public static boolean notEmpty(File file) {
        return null != file && file.exists();
    }

    /*
     * 判断对象数组为空
     */
    public static boolean empty(Object[] var) {
        return null == var || 0 == var.length;
    }

    /*
     * 判断对象数组不为空
     */
    public static boolean notEmpty(Object[] var) {
        return null != var && 0 < var.length;
    }
}
