import com.emgcy120.core.common.util.BeanUtil;
import lombok.Data;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by weijieliao on 2017/12/12.
 */
public class BeanUtilTest {

    @Test
    public void map(){

        TestBean bean = new TestBean() ;
        Map<String,Object> map = new HashMap<>() ;
        List<String> list = new ArrayList<>() ;
        list.add( "a" ) ;
        list.add( "b" ) ;
        map.put( "id" , 1 ) ;
        map.put( "list" , list ) ;
        BeanUtil.transMap2Bean( map , bean ) ;

        System.out.println( "bean.id="+bean.getId()+",bean.list.size="+bean.getList().size() ) ;

    }

    @Data
    public class TestBean{

        public int id ;
        public List list ;

    }

}
