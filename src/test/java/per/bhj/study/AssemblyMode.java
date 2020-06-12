package per.bhj.study;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import per.bhj.study.service.impl.AccountServiceImpl;

/**
 * 该类主要测试装配方式
 */
public class AssemblyMode {

    /**
     * 使用构造方法依赖注入
     * Dependency injection
     * 在xml中直接仅使用bean标签搭配id和class进行装配bean的时候默认就是使用构造器注入。如果类中没有默认构造方法（也就是说没有无参构造方法）
     * 的时候这个对象无法创建。但是如果需要使用参数的话就可以使用constructor-arg标签进行带参数注入.
     *
     * 可以通过将AccountServiceImpl中的构造器进行重写，将无参构造器覆盖掉，就会无法创建对象
     */
    @Test
    public void testUsingConstructorDI() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath" +
                ":applicationContext.xml");
        AccountServiceImpl accountService = (AccountServiceImpl) applicationContext.getBean("accountService");
        accountService.getInfor();
    }
}
