import com.emgcy120.core.Application;
import com.emgcy120.core.system.org.service.IOrgService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by weijieliao on 2017/11/28.
 */
@RunWith( SpringJUnit4ClassRunner.class )
@SpringBootTest(classes=Application.class)
public class OrgTest {

    @Autowired
    private IOrgService orgService ;

    @Test
    public void listTest(){

//        List list = orgService.hospList() ;
//        System.out.println( list ) ;
//        Assert.assertNotNull( list ) ;

    }

}
