package per.bhj.study.domain.impl;

import per.bhj.study.domain.AccountDao;

public class AccountDaoImpl implements AccountDao {

    /**
     * 用于证明BeanFactory和ApplicationContext创建对象（实例化Bean）的时间
     */
    public AccountDaoImpl() {
        System.out.println("对象创建了");
    }

    public void showInfo() {
        System.out.println("this is AccountDaoImpl");
    }
}
