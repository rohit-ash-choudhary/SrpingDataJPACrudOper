package src.com.main.SrpingDataJPACrudOper;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sp.entity.Account;
import com.sp.resources.SpringConfig;
import com.sp.service.AccountService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Account acc=new  Account();
    	acc.setAcc_num(11);
    	acc.setAcc_type("Saving");
    	acc.setBalace(102000);
    	acc.setLast_name("Choudhayr");
    	acc.setPin_code(3343);
        ApplicationContext context=new AnnotationConfigApplicationContext(SpringConfig.class);
        AccountService as=(AccountService) context.getBean("accountService");
        
      // as.updateAccountDetail(1, 99999);
        
        ///as.deleteAccountDetail(1);
        
       Account acc1= as.getAccountDetail(11);
       System.out.println(acc1.getAcc_num());
       System.out.println(acc1.getBalace());
       
        
    }
}
