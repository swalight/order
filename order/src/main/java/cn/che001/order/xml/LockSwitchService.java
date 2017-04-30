package cn.che001.order.xml;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

/**
 * Created by Swalight on 2017-04-20.
 */
@Service
public class LockSwitchService {
   private static Logger logger = LoggerFactory.getLogger(LockSwitchService.class);
    /**
     * 判断是否可以点菜
     * @return true-锁定 false-未锁定
     */
    public boolean isLock() {
        boolean lock = false;
        try {
            String url = getXmlUrl("lock.xml");
            SAXReader reader = new SAXReader();
            Document document = reader.read(new File(url));
            Element rootElm = document.getRootElement();
            List<Element> elements = rootElm.elements();
            for(Element elm : elements){
                if(elm.getText().equalsIgnoreCase("lock")){
                    logger.info("element's txt = {}",elm.getText());
                    lock=true;
                }
            }

        }catch (Exception e){
            return lock;
        }
        return lock;

    }

    /**
     * 更新点菜状态
     * @param lock lock-锁定 unlock-不锁定
     * @return true 成功
     */
    public boolean updateLock(String lock){
        try {
            String url = getXmlUrl("lock.xml");
            SAXReader reader = new SAXReader();
            Document document = reader.read(new File(url));
            Element rootElm = document.getRootElement();
            Element lockElm = rootElm.element("lock");
            lockElm.setText(lock);
            OutputFormat format = OutputFormat.createPrettyPrint();
            XMLWriter writer =  new XMLWriter(new OutputStreamWriter(new FileOutputStream(url),"utf-8"),format);
            writer.write(document);
            logger.info("lockUpdate---start-->");
            logger.info("--"+lock+"--->");
            logger.info(document.asXML());
            logger.info("----end--->");
            writer.flush();
            writer.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * xml URL获取
     * @return
     * @throws UnsupportedEncodingException
     */
    private String getXmlUrl(String xmlName) throws UnsupportedEncodingException {
        String path = this.getClass().getResource(xmlName).getPath();
        path= URLDecoder.decode(path,"utf-8");
        return path;
    }

}
