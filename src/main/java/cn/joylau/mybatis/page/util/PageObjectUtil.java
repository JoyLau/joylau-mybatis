/*******************************************************************************
 * Copyright (c) 2017 by JoyLau. All rights reserved
 ******************************************************************************/

package cn.joylau.mybatis.page.util;

import cn.joylau.mybatis.page.Page;
import cn.joylau.mybatis.page.PageException;
import org.apache.ibatis.reflection.MetaObject;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 分页参数对象工具类
 *
 * @author liuzh
 */
public abstract class PageObjectUtil {
    //request获取方法
    protected static Boolean hasRequest;
    protected static Class<?> requestClass;
    protected static Method getParameterMap;
    protected static Map<String, String> PARAMS = new HashMap<String, String>(5);

    static {
        try {
            requestClass = Class.forName("javax.servlet.ServletRequest");
            getParameterMap = requestClass.getMethod("getParameterMap", new Class[]{});
            hasRequest = true;
        } catch (Throwable e) {
            hasRequest = false;
        }
        PARAMS.put("pageNum", "pageNum");
        PARAMS.put("pageSize", "pageSize");
        PARAMS.put("count", "countSql");
        PARAMS.put("reasonable", "reasonable");
        PARAMS.put("pageSizeZero", "pageSizeZero");
    }

    /**
     * 对象中获取分页参数
     *
     * @param params
     * @return
     */
    public static <T> Page<T> getPageFromObject(Object params, boolean required) {
        int pageNum;
        int pageSize;
        MetaObject paramsObject = null;
        if (params == null) {
            throw new PageException("无法获取分页查询参数!");
        }
        if (hasRequest && requestClass.isAssignableFrom(params.getClass())) {
            try {
                paramsObject = MetaObjectUtil.forObject(getParameterMap.invoke(params, new Object[]{}));
            } catch (Exception e) {
                //忽略
            }
        } else {
            paramsObject = MetaObjectUtil.forObject(params);
        }
        if (paramsObject == null) {
            throw new PageException("分页查询参数处理失败!");
        }
        try {
            Object _pageNum = getParamValue(paramsObject, "pageNum", required);
            Object _pageSize = getParamValue(paramsObject, "pageSize", required);
            if (_pageNum == null || _pageSize == null) {
                return null;
            }
            pageNum = Integer.parseInt(String.valueOf(_pageNum));
            pageSize = Integer.parseInt(String.valueOf(_pageSize));
        } catch (NumberFormatException e) {
            throw new PageException("分页参数不是合法的数字类型!");
        }
        Page page = new Page(pageNum, pageSize);
        //count查询
        Object _count = getParamValue(paramsObject, "count", false);
        if (_count != null) {
            page.setCount(Boolean.valueOf(String.valueOf(_count)));
        }
        //分页合理化
        Object reasonable = getParamValue(paramsObject, "reasonable", false);
        if (reasonable != null) {
            page.setReasonable(Boolean.valueOf(String.valueOf(reasonable)));
        }
        //查询全部
        Object pageSizeZero = getParamValue(paramsObject, "pageSizeZero", false);
        if (pageSizeZero != null) {
            page.setPageSizeZero(Boolean.valueOf(String.valueOf(pageSizeZero)));
        }
        return page;
    }

    /**
     * 从对象中取参数
     *
     * @param paramsObject
     * @param paramName
     * @param required
     * @return
     */
    protected static Object getParamValue(MetaObject paramsObject, String paramName, boolean required) {
        Object value = null;
        if (paramsObject.hasGetter(PARAMS.get(paramName))) {
            value = paramsObject.getValue(PARAMS.get(paramName));
        }
        if (value != null && value.getClass().isArray()) {
            Object[] values = (Object[]) value;
            if (values.length == 0) {
                value = null;
            } else {
                value = values[0];
            }
        }
        if (required && value == null) {
            throw new PageException("分页查询缺少必要的参数:" + PARAMS.get(paramName));
        }
        return value;
    }

    public static void setParams(String params) {
        if (StringUtil.isNotEmpty(params)) {
            String[] ps = params.split("[;|,|&]");
            for (String s : ps) {
                String[] ss = s.split("[=|:]");
                if (ss.length == 2) {
                    PARAMS.put(ss[0], ss[1]);
                }
            }
        }
    }

}
