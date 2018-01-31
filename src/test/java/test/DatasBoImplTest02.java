package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author wangzi
 * @date 18/1/25 上午6:38.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/applicationContext-dao.xml", "classpath*:spring/applicationContext-service.xml", "classpath*:spring/applicationContext-trans.xml", "classpath*:spring/springmvc.xml", "classpath*:mybatis/sqlMapConfig.xml"})
public class DatasBoImplTest02 {
    @Autowired
    private ApplicationContext context;

    @Test
    public void insert() {
//        AreasInstrumentsBoImpl test = context.getBean(AreasInstrumentsBoImpl.class);
        
    }
}
