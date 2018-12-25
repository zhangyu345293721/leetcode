package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: SpringTest
 * @Description: TOTO
 * @date 2018/11/30 17:20
 **/


public class SpringTest {
   private Properties contextConfig=new Properties();
   private Map<String,Object> beanMap=new ConcurrentHashMap<>();
   private List<String> classNames=new ArrayList<>();
   public  void fun(){
       // 1,定位
       doLocationConfig();
       // 2.加载
       doScanner();
       // 3.注册
       doRegistry();
       // 4.注入
       doAutowire();
   }
   // 分别实现里面的四个方法
    // 1.定位
    private void doLocationConfig() {
    }
    // 2.扫描
    private void doScanner() {
    }
    //3.注册
    private void doRegistry() {
    }
    //4.依赖注入
    private void doAutowire() {
    }

}
