package com.emgcy120.core.common.constants;

public class Constant {
	
	//session存放用户对象的key
    public static final String USER_SESSION_KEY = "currentUser";

    //用户密码最小位数
    public static final int PASSWORD_LENGTH_MIN = 8 ;
    
    /**
     * 删除标记（0：正常；1：删除；2：审核；）
     */
    public static final String DEL_FLAG_NORMAL = "0";
    public static final String DEL_FLAG_DELETE = "1";
    public static final String DEL_FLAG_AUDIT = "2";

    /**
     * 重置密码申请的资料校验结果：-1、全部，0、错误，1、正确
     */
    public static final int PWD_APPLY_CHECK_RESULT_ALL = -1 ;
    public static final int PWD_APPLY_CHECK_RESULT_WRONG = 0 ;
    public static final int PWD_APPLY_CHECK_RESULT_OK = 1 ;

    /**
     * 重置密码申请处理结果：0、全部，1.已回复初始密码，2.已忽略申请，3、未处理
     */
    public static final int PWD_APPLY_PROCESS_RESULT_ALL = 0 ;
    public static final int PWD_APPLY_PROCESS_RESULT_INIT = 1 ;
    public static final int PWD_APPLY_PROCESS_RESULT_IGNORE = 2 ;
    public static final int PWD_APPLY_PROCESS_RESULT_WAIT = 3 ;

    //120用户状态：停用
    public static final int USER_120_STATUS_DISABLE = -1 ;
    //120用户状态：未激活
    public static final int USER_120_STATUS_UNACTIVE = 0 ;
    //120用户状态：可用
    public static final int USER_120_STATUS_ENABLE = 1 ;
    //120用户状态：删除
    public static final int USER_120_STATUS_DELETE = 2 ;

    //事件类型——普通急救
    public static final int EVENT_TYPE_COMMON = 1 ;
    //事件类型——群体事件
    public static final int EVENT_TYPE_GROUP = 2 ;

    //受理状态（1、待受理；2、已受理；3、未受理；4、派单超时；5、已取消）
    public static final int RECEIVE_STATUS_WAIT_FOR = 1 ;
    public static final int RECEIVE_STATUS_ACCEPT = 2 ;
    public static final int RECEIVE_STATUS_REFUSE = 3 ;
    public static final int RECEIVE_STATUS_TIMEOUT = 4 ;
    public static final int RECEIVE_STATUS_CANCEL = 5 ;

    //执行状态：0、无，1、已出车；2、已到达；3、已中断；4、已完成
    public static final int EXECUTE_STATUS_NONE = 0 ;
    public static final int EXECUTE_STATUS_ASSIGN_CAR = 1 ;
    public static final int EXECUTE_STATUS_ARRIVE = 2 ;
    public static final int EXECUTE_STATUS_STOP = 3 ;
    public static final int EXECUTE_STATUS_FINISH = 4 ;

    //患者身份——普通
    public static final int PATIENT_IDENTITY_COMMON = 1 ;
    //患者身份——三无
    public static final int PATIENT_IDENTITY_3NOT = 2 ;
    //患者身份——其他
    public static final int PATIENT_IDENTITY_ORTHER = 3 ;

    //呼叫类型（1、呼入；2、呼出）
    public static final int CALL_TYPE_IN = 1 ;
    public static final int CALL_TYPE_OUT = 2 ;

    //是否已接听（1、已接听；2、未接听）
    public static final int HAD_CONNECTED = 1 ;
    public static final int NOT_CONNECTED = 2 ;

    public static final String KEY_PAGE_INDEX = "pageIndex" ;
    public static final String KEY_PAGE_SIZE = "pageSize" ;
    public static final String KEY_TOTAL_SIZE = "totalSize" ;
    public static final String KEY_LIST = "list" ;
    public static final String KEY_ASSIGN_LIST = "assignList" ;
    public static final String KEY_ASSIGN_CAR_LIST = "assignCarList" ;
    public static final String KEY_ASSIGN_ID = "assignId" ;
    public static final String KEY_CAR_NUM = "carNum" ;
    public static final String KEY_OPE_LOG_LIST = "opeLogList" ;
    public static final String KEY_TOKEN = "token" ;
    public static final String KEY_USER_ID = "userId" ;
    public static final String KEY_EMPLOYEE_ID = "employeeId" ;
    public static final String KEY_EMAIL = "email" ;
    public static final String KEY_NAME = "name" ;
    public static final String KEY_PHONE = "phone" ;
    public static final String KEY_PHOTO = "photo" ;
    public static final String KEY_STATUS = "status" ;
    public static final String KEY_ATTACHMENT_ID = "attachmentId" ;
    public static final String KEY_DOWNLOAD_URL = "downloadUrl" ;
    public static final String KEY_REGION_LIST = "regionList" ;
    public static final String KEY_EVENT_COUNT = "eventCount" ;
    public static final String KEY_NEW_EVENT_COUNT = "newEventCount" ;
    public static final String KEY_EVENT_GROWTH_RATE = "eventGrowthRate" ;
    public static final String KEY_NEW_ASSIGN_COUNT = "newAssignCount" ;
    public static final String KEY_ASSIGN_GROWTH_RATE = "assignGrowthRate" ;
    public static final String KEY_NEW_ASSIGN_CANCEL_COUNT = "newAssignCancelCount" ;
    public static final String KEY_ASSIGN_CANCEL_GROWTH_RATE = "assignCancelGrowthRate" ;
    public static final String KEY_NEW_ASSIGN_FINISH_COUNT = "newAssignFinishCount" ;
    public static final String KEY_ASSIGN_FINISH_GROWTH_RATE = "assignFinishGrowthRate" ;
    public static final String KEY_NEW_AVG_TIME = "newAvgTime" ;
    public static final String KEY_AVG_TIME_GROWTH_RATE = "avgTimeGrowthRate" ;
    public static final String KEY_COMMON_EVENT_COUNT = "commonEventCount" ;
    public static final String KEY_RECEIVE_RATE = "assignRate" ;
    public static final String KEY_ASSIGN_CAR_RATE = "assignAcceptRate" ;
    public static final String KEY_ASSIGN_FINISH_RATE = "assignFinishRate" ;
    public static final String KEY_EVENT_PROPORTION = "eventProportion" ;
    public static final String KEY_CODE = "code" ;
    public static final String KEY_MSG = "msg" ;
    public static final String KEY_DATA = "data" ;

    /** 院内接口返回code */
    public static final String RETURN_CODE_EMGCY_FAIL = "0" ;
    public static final String RETURN_CODE_EMGCY_OK = "1" ;

    /** uri————获取医院列表及每个医院的车辆数 */
    public static final String URI_ORGVEHICLE = "/rest/web/emergency/orgVehicle" ;
    /** uri————发送普通急救信息到院内工作站 */
    public static final String URI_ORDINARYSAVE = "/rest/web/emergency/ordinarySave" ;

}
