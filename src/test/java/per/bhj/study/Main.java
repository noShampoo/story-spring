package per.bhj.study;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import per.bhj.study.domain.AccountDao;

/**
 * test class
 */
public class Main {

    /**
     * 测试从Spring IOC容器中获取Bean
     */
    @Test
    public void testGetBean() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        AccountDao accountDao = (AccountDao) beanFactory.getBean("accountDao");
        accountDao.showInfo();
    }
}
