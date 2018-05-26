package com.emgcy120.core.common.util;


import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONString;

public class JSONStringObject implements JSONString{

    private String jsonString = null;
    
    public JSONStringObject(String jsonString){
        this.jsonString = jsonString;
    }

    @Override
    public String toString(){
        return jsonString;
    }

    public String toJSONString(){
        return jsonString;
    }
    
    public static void main(String[] args) {
    	String str = "{\"doctorId\":\"移动医生ID\",\"hospitalId\":\"医院ID\",\"deptCode\":\"科室代码\",\"shareOutpMgr\":\"是否共享病历\",\"transferDesc\":\"转诊说明\",\"attachItems\":[{\"attachType\":\"附件类型1\",\"attachName\":\"附件名称\",\"attachFileName\":\"文件路径\"},{\"attachType\":\"附件类型2\",\"attachName\":\"附件名称\",\"attachFileName\":\"文件路径\"}]}";
    	
    	try {
			JSONObject obj = new JSONObject(str);
			
		//	System.out.println("doctorId: "+ obj.getString("doctorId"));
			
			System.out.println( new JSONObject(obj.getJSONArray("attachItems").get(1).toString()).getString("attachType"));
			
		} catch (JSONException e) {
			
			e.printStackTrace();
		}
	}
}
