package cn.easycms.base;

import cn.easycms.util.StringUtil;
import freemarker.core.Environment;
import freemarker.template.TemplateModelException;

import java.util.Map;

/**
 *
 * Created by hackingwu on 2014/4/12.
 */
public class BaseDirective {

    public String getParam(Map data,String key){
        String value = "";
        if (StringUtil.isNotEmpty(key)){
            value = data.get(key).toString();
        }
        return value;
    }
    public String getParam(Map data,String key,String defaultParam){
        String value = defaultParam;
        if (StringUtil.isNotEmpty(key)){
            value = data.get(key).toString();
        }
        return value;
    }
    public int getParam(Map data,String key,int defaultParam){
        int value = defaultParam;
        if (StringUtil.isNotEmpty(key)){
            value = Integer.parseInt(data.get(key).toString());
        }
        return value;
    }


    public String getData(Environment env,String key){
        Object value = null;
        try {
            value = env.getDataModel().get(key);
        } catch (TemplateModelException e) {
            e.printStackTrace();
        }
        return value!=null?value.toString():"";

    }
    public String getData(Environment env,String key,String defaultData){
        String temp = getData(env,key);
        return temp.equals("")?defaultData:temp;
    }
}
