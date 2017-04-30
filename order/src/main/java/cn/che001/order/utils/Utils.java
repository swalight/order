package cn.che001.order.utils;

import cn.che001.order.Base.Entity;
import cn.che001.order.Base.RestResult;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 170246 on 2017/4/17.
 */
public class Utils {
    /**
     * 字符串转日期
     *
     * @param str    字符串类型时间
     * @param format 格式
     * @return date 日期
     */
    public static Date str2Date(String str, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 日期类型转字符串
     *
     * @param date
     * @param format
     * @return 字符串类型日期
     */
    public static String date2Str(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String time = sdf.format(date);
        return time;
    }

    /**
     * bean转map
     * @param entity
     * @return
     */
    public static Map<String, Object> convertBeanToMap(Entity entity) {

        if (entity == null) {
            return new HashMap<String, Object>();
        }
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(entity.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();
                if (!key.equals("class")) {
                    Method getter = property.getReadMethod();
                    Object value =  getter.invoke(entity);
                    map.put(key, value);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    public static RestResult restResultByRow(int row){
        RestResult restResult = row>=0 ? new RestResult(RestResult.SUCCESS_CODE,RestResult.SUCCESS_MSG,row) :
                new RestResult(RestResult.ERROR_CODE,RestResult.ERROR_MSG,0);
        return restResult;
    }

    public static RestResult successResult(Object object){
        return new RestResult(RestResult.SUCCESS_CODE,RestResult.SUCCESS_MSG,object);
    }

    public static RestResult errorResult(Object object){
        return new RestResult(RestResult.ERROR_CODE,RestResult.ERROR_MSG,object);
    }


}
