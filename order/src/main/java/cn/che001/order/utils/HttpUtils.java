package cn.che001.order.utils;

import cn.che001.order.Base.Entity;
import com.google.common.base.Strings;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.time.DateUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * Created by 170246 on 2017/4/17.
 */
public class HttpUtils {
    /**
     * 自动匹配参数赋值到实体bean中
     * @param bean
     * @param request
     * @param format 日期类型格式，null时默认yyyy-MM-dd hh:mm:ss
     */
    public static void request2Bean(Entity bean, HttpServletRequest request, String format){
        String dateFormat = Strings.isNullOrEmpty(format)==true?"yyyy-MM-dd hh:mm:ss":format;
        Class<? extends Object> clazz = bean.getClass();
        Method ms[] = clazz.getMethods();
        String methodName;
        String field;
        String fieldType;
        String value;
        for(Method m : ms){
            methodName = m.getName();
            if(!methodName.startsWith("set")
                    || ArrayUtils.isEmpty(m.getParameterTypes())){
                continue;
            }
            try{
                field = methodName.toLowerCase().charAt(3) + methodName.substring(4, methodName.length());
                value = request.getParameter(field);
                if(StringUtils.isEmpty(value)){
                    continue;
                }
                fieldType = m.getParameterTypes()[0].getName();
                //确认value类型
                if(String.class.getName().equals(fieldType)){
                    m.invoke(bean, (String)value);
                }else if(Integer.class.getName().equals(fieldType) && NumberUtils.isDigits((String)value)){
                    m.invoke(bean, Integer.valueOf((String)value));
                }else if(Short.class.getName().equals(fieldType) && NumberUtils.isDigits((String)value)){
                    m.invoke(bean, Short.valueOf((String)value));
                }else if(Float.class.getName().equals(fieldType) && NumberUtils.isNumber((String)value)){
                    m.invoke(bean, Float.valueOf((String)value));
                }else if(Double.class.getName().equals(fieldType) && NumberUtils.isNumber((String)value)){
                    m.invoke(bean, Double.valueOf((String)value));
                }else if(Date.class.getName().equals(fieldType)){
                    m.invoke(bean, DateUtils.parseDate((String)value, dateFormat));
                }else{
                    m.invoke(bean, value);
                }
            }catch(Exception e){
                e.printStackTrace();
                continue;
            }
        }
    }
}
