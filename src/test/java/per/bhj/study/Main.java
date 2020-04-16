package per.bhj.study;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import per.bhj.study.domain.AccountDao;

/**
 * test class
 */
public class Main {

    /**
     * 测试从Spring IOC容器中获取Bean
     * 三个常用的ApplicationContext的实现类
     *      1、ClassPathXmlApplicationContext()          加载类路径下的xml文件
     *      2、FileSystemXmlApplicationContext()
     *      加载系统磁盘中的xml文件（但是必须有权限）[为了避免失误操作导致文件被删除无法使用，所以建议使用ClassPathXmlApplicationContext]
     *      3、AnnotationConfigApplicationContext()      加载注解创建的容器
     *
     *
     * ApplicationContext和BeanFactory的区别：
     *      ApplicationContext:在构建容器时，对象采用立即加载模式。也就是一旦读取到xml配置文件就会创建对象或者说实例化Bean
     *      单例的时候使用
     *
     *      BeanFactory:在构建容器时，对象采用延迟加载模式。也就是说对象是么时候创建，是在我调用它的时候才会使用(也就是获得Bean的时候才会实例化Bean)
     *      多例的时候使用
     *   【可以通过要装备的Bean的构造方法进行单步调试证明】
     */
    @Test
    public void testGetBean() {

        /**
         * 使用ApplicationContext，他会在装配完Bean就直接实例化Bean
         */
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
//        AccountDao accountDao = (AccountDao) applicationContext.getBean("accountDao");
//        accountDao.showInfo();

        /**
         * 使用BeanFactory，在调用的时候才会实例化Bean
         */
        Resource resource = new ClassPathResource("applicationContext.xml");
        BeanFactory beanFactory = new XmlBeanFactory(resource);
        AccountDao accountDao1 = (AccountDao) beanFactory.getBean("accountDao");
        accountDao1.showInfo();
    }
}
