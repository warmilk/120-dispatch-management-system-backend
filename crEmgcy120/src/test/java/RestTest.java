import com.emgcy120.core.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

/**
 * Created by weijieliao on 2018/1/9.
 */
@RunWith( SpringJUnit4ClassRunner.class )
@SpringBootTest( classes = Application.class )
public class RestTest {

    @Autowired
    RestTemplate restTemplate ;

    @Test
    public void test(){

        System.out.println( restTemplate.getForObject( "http://www.baidu.com" , String.class ) ) ;

    }

}
