package cn.che001.order.filter;

import cn.che001.order.Base.RestResult;
import cn.che001.order.utils.Constants;
import com.google.gson.Gson;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.List;


/**
 * Created by Swalight on 2017-04-20.
 */
public class LockFilter implements Filter {
    private static Logger logger = LoggerFactory.getLogger(LockFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("****LockFilter****");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String url = request.getRequestURI();
        //锁定、解锁点菜URL放行--简单应用不校验安全性
        if (url.indexOf(Constants.AUTHURL) > 0) {
            filterChain.doFilter(request, response);
        } else {
            //拦截非GET请求且当前状态为LOCK
            if(!request.getMethod().equals("GET")&&isLock()){
                logger.info("****LockFilter status is lock****");
                RestResult restResult = new RestResult(405,"LOCKING");
                Gson gson = new Gson();
                String json = gson.toJson(restResult);
                response.setStatus(405);
                response.setCharacterEncoding("UTF-8");
                response.setContentType("application/json; charset=utf-8");
                response.getWriter().write(json);
            }else {
                //GET请求、unlock状态下放行
                filterChain.doFilter(request,response);
            }
        }
    }

    @Override
    public void destroy() {

    }

    /**
     * 判断是否可以点菜
     * @return true-锁定 false-未锁定
     */
    private boolean isLock() {
        boolean lock = false;
        try {
            File f = new File(this.getClass().getResource("").getPath());
            String ss = f.getPath();
            String status = null;
            String url = URLDecoder.decode(ss.substring(0,ss.length()-22)+"lock.xml","utf-8");
            SAXReader reader = new SAXReader();
            Document document = reader.read(new File(url));
            Element rootElm = document.getRootElement();
            List<Element> elements = rootElm.elements("lock");
            for(Element elm : elements){
                status = elm.getTextTrim();
                logger.info("status = {}",elm.getText());
                if(status.equalsIgnoreCase("lock")){
                    lock=true;
                    break;
                }
            }
        }catch (Exception e){
            logger.info("error msg : {}",e.getMessage());
            return lock;
        }
        return lock;
    }
}
