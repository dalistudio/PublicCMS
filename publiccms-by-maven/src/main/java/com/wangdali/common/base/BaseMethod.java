package com.wangdali.common.base;

import static com.wangdali.common.tools.TemplateModelUtils.converBoolean;
import static com.wangdali.common.tools.TemplateModelUtils.converDate;
import static com.wangdali.common.tools.TemplateModelUtils.converDouble;
import static com.wangdali.common.tools.TemplateModelUtils.converInteger;
import static com.wangdali.common.tools.TemplateModelUtils.converLong;
import static com.wangdali.common.tools.TemplateModelUtils.converMap;
import static com.wangdali.common.tools.TemplateModelUtils.converShort;
import static com.wangdali.common.tools.TemplateModelUtils.converString;
import static com.wangdali.common.tools.TemplateModelUtils.converStringArray;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import freemarker.template.TemplateHashModelEx;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;

/**
 * 
 * BaseMethod FreeMarker自定义方法基类
 *
 */
public abstract class BaseMethod extends Base implements TemplateMethodModelEx {

	/*
	 * 获得数据模型
	 */
    private static TemplateModel getModel(int index, List<TemplateModel> arguments) {
        if (index < arguments.size()) {
            return arguments.get(index);
        }
        return null;
    }

    /*
     * 获得映射
     */
    public static TemplateHashModelEx getMap(int index, List<TemplateModel> arguments) throws TemplateModelException {
        return converMap(getModel(index, arguments));
    }

    /*
     * 获得字符串
     */
    public static String getString(int index, List<TemplateModel> arguments) throws TemplateModelException {
        return converString(getModel(index, arguments));
    }

    /*
     * 获得整型
     */
    public static Integer getInteger(int index, List<TemplateModel> arguments) throws TemplateModelException {
        return converInteger(getModel(index, arguments));
    }

    /*
     * 获得短整型
     */
    public static Short getShort(int index, List<TemplateModel> arguments) throws TemplateModelException {
        return converShort(getModel(index, arguments));
    }

    /*
     * 获得长整型
     */
    public static Long getLong(int index, List<TemplateModel> arguments) throws TemplateModelException {
        return converLong(getModel(index, arguments));
    }

    /*
     * 获得双浮点型
     */
    public static Double getDouble(int index, List<TemplateModel> arguments) throws TemplateModelException {
        return converDouble(getModel(index, arguments));
    }

    /*
     * 获得字符串数组
     */
    public static String[] getStringArray(int index, List<TemplateModel> arguments) throws TemplateModelException {
        return converStringArray(getModel(index, arguments));
    }

    /*
     * 获得整型数组
     */
    public static Integer[] getIntegerArray(int index, List<TemplateModel> arguments) throws TemplateModelException {
        String[] arr = getStringArray(index, arguments);
        if (notEmpty(arr)) {
            Integer[] ids = new Integer[arr.length];
            int i = 0;
            for (String s : arr) {
                ids[i++] = Integer.valueOf(s);
            }
            return ids;
        }
        return null;
    }

    /*
     * 获得长整型数组
     */
    public static Long[] getLongArray(int index, List<TemplateModel> arguments) throws TemplateModelException {
        String[] arr = getStringArray(index, arguments);
        if (notEmpty(arr)) {
            Long[] ids = new Long[arr.length];
            int i = 0;
            for (String s : arr) {
                ids[i++] = Long.valueOf(s);
            }
            return ids;
        }
        return null;
    }

    /*
     * 获得布尔型
     */
    public static Boolean getBoolean(int index, List<TemplateModel> arguments) throws TemplateModelException {
        return converBoolean(getModel(index, arguments));
    }

    /*
     * 获得日期时间
     */
    public static Date getDate(int index, List<TemplateModel> arguments) throws TemplateModelException, ParseException {
        return converDate(getModel(index, arguments));
    }
}
