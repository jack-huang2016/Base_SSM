package com.yougou.bi.mdp.web.utils;

import java.util.List;
import cn.wonhigh.retail.uc.common.api.utils.CommonUtil;
import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;
public class EncodeURLMethod implements TemplateMethodModel {
	
    @SuppressWarnings("rawtypes")
	@Override
    public Object exec(List args) throws TemplateModelException {
        boolean flag=false;
         
        if(args!=null&&args.size()>1){
            String s1=(String) args.get(0);
            String s2=(String) args.get(1);
            //最开始的判断是这样的((CommonUtil.hasValue(s1)&&CommonUtil.validateLong(s1))&&(CommonUtil.hasValue(s2)&&CommonUtil.validateLong(s2)))
            if(CommonUtil.hasValue(s1)&&(CommonUtil.hasValue(s2)&&CommonUtil.validateLong(s2))){
            	 //flag=CommonUtil.checkPower(Integer.valueOf(s1), Integer.valueOf(s2));
               flag=BiCommonUtil.checkPower(s1, Integer.valueOf(s2));
            }
        }
        return flag;
    }
}
