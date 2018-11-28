package com.yougou.bi.mdp.web.utils;

public class BiCommonUtil {
	
	public static boolean checkPower(String power_value,int index){
	    boolean flag=false;
	    String [] powerArray = power_value.split(",");
	    for(int i=0; i<powerArray.length; i++){
	        if(Integer.parseInt(powerArray[i]) == index){
	            flag = true;
	            break;
	        }
	    }
	    return flag;
	}

}
