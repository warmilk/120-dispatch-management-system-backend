package com.emgcy120.core.common.inHosp;

import com.alibaba.fastjson.JSONObject;
import com.emgcy120.core.common.config.AppConfig;
import com.emgcy120.core.common.constants.Constant;
import com.emgcy120.core.common.enm.ErrorCode;
import com.emgcy120.core.common.exception.CustomException;
import com.emgcy120.core.common.inHosp.dto.Emergency;
import com.emgcy120.core.common.inHosp.dto.EmergencyOrg;
import com.emgcy120.core.system.event.web.dto.EventReceiveCommonReqDto;
import com.emgcy120.core.system.sys.mapper.DictItemMapper;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by weijieliao on 2018/2/5.
 */
@Component
public class InHospUtil {

    private final Logger logger = LoggerFactory.getLogger( getClass() ) ;

    @Autowired
    AppConfig appConfig ;
    @Autowired
    RestTemplate restTemplate ;

    @Autowired
    DictItemMapper dictItemMapper ;

    /**
     * 获取医院列表
     * @return
     */
    public Object hospList(){

        //从院内系统获取
        String url = appConfig.getCrEmgcyBaseUrl()+ Constant.URI_ORGVEHICLE ;

        return getForObject( url ) ;

    }

    /**
     * 受理普通急救
     * @param req
     */
    public Object receiveCommon(EventReceiveCommonReqDto req) {

        String url = appConfig.getCrEmgcyBaseUrl()+Constant.URI_ORDINARYSAVE ;

        Emergency bean = new Emergency() ;
        bean.setName( req.getPatientName() ) ;
        bean.setAge( req.getPatientAge() ) ;
        bean.setSex( req.getPatientSex()+"" ) ;
        bean.setIdentity( convertIdentity( req.getPatientIdentity() ) ) ;
        bean.setContactName( req.getReporter() ) ;
        bean.setContactPhone( req.getPhone() ) ;
        //地址需要拼接，先通过id获取乡镇名然后添加具体地址
        bean.setAddress( dictItemMapper.selectById( req.getRegion() ).getDictItemValue()+req.getPlace() ) ;
        //指派医院的列表
        List<EmergencyOrg> list = new ArrayList<>() ;
        EmergencyOrg eo = new EmergencyOrg() ;
        eo.setOrgHospitalId( req.getHospId() ) ;
        eo.setVehicleNum( req.getCarNum() ) ;
        list.add( eo ) ;
        bean.setList( list ) ;
        bean.setRescueType( req.getRescueType() ) ;
        bean.setInformantDesc( req.getReporterDesc() ) ;
        bean.setPatientDesc( req.getPatientDesc() ) ;
        bean.setCritical( req.getLevel()+"" ) ;

        Gson gson = new Gson() ;

        return postForObject( url , gson.toJson( bean ) ) ;

    }

    private Object getForObject( String url ){

        Map resultMap = restTemplate.getForObject( url , Map.class ) ;

        checkResultMap( resultMap , url ) ;

        return resultMap.get( Constant.KEY_DATA ) ;

    }

    /**
     *
     * @param url
     * @param paramStr  json字符串格式的参数
     * @return
     */
    private Object postForObject( String url , String paramStr ) {

        HttpHeaders headers = new HttpHeaders() ;
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8") ;
        headers.setContentType(type) ;
        headers.add("Accept", MediaType.APPLICATION_JSON.toString()) ;
        HttpEntity<String> formEntity = new HttpEntity<>( paramStr , headers) ;

        Map resultMap = restTemplate.postForObject( url , formEntity , Map.class ) ;

        checkResultMap( resultMap , url ) ;

        return resultMap.get( Constant.KEY_DATA ) ;

    }

    /**
     * 检查返回的result map
     * @param resultMap
     */
    private void checkResultMap(Map resultMap , String url ) {

        if( resultMap == null ){
            logger.error( "访问院内接口失败，url="+url ) ;
            throw new CustomException( ErrorCode.SERVER_ERROR ) ;
        }
        String code = ( String )resultMap.get( Constant.KEY_CODE ) ;
        if( !Constant.RETURN_CODE_EMGCY_OK.equals( code ) ){
            //访问院内服务器报错
            throw new CustomException( ErrorCode.IN_HOSP_ERROR.getCode()
                    , ErrorCode.IN_HOSP_ERROR.getDescription()+resultMap.get( Constant.KEY_MSG ) ) ;
        }

    }

    /**
     * 将急救中心的患者身份转换为院内工作站的患者身份
     * @param identity
     * @return
     */
    public String convertIdentity(Integer identity) {

        return ( identity-1 )+"" ;

    }

}
