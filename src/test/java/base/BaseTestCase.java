package base;

import com.lmgd.customer.util.PageBean;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//Spring Test+JUnit完美组合：第二步(创建BaseTestCase,并在该类上加上两个注解)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})//读取spring上下文
public class BaseTestCase {
    protected PageBean pageBean;
    @Before
    public void setUp() throws Exception {
        pageBean=new PageBean();
    }

}
