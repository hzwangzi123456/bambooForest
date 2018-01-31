package test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wangzi
 * @date 18/1/19 上午3:32.
 */
public class test01 {
    private ApplicationContext classPathXmlApplicationContext;

    @Before
    public void init(){
        String[] strings = {"classpath:spring/applicationContext-dao.xml", "classpath:spring/applicationContext-service.xml", "classpath:spring/applicationContext-trans.xml","classpath:spring/springmvc.xml","classpath:mybatis/sqlMapConfig.xml"};
        classPathXmlApplicationContext = new ClassPathXmlApplicationContext(strings);

    }

    @Test
    public void test03() {

    }
}
