package leetcode.select;


import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 统计运行次数
 *
 * @author: zhangyu
 */
public class RunCount {
    @Test
    public void fun() throws IOException {
        Properties prop = new Properties();
        File file = new File("d://count.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileInputStream fis = new FileInputStream(file);
        prop.load(fis);
        int count = 0;
        String value = prop.getProperty("time");
        if (value != null) {
            count = Integer.parseInt(value);
            if (count > 5) {
                System.out.println("您好你的使用次数已经到了，该充钱了!");
                return;
            }
            System.out.println(count);
        }
        count++;
        prop.setProperty("time", count + "");
        FileOutputStream fos = new FileOutputStream(file);
        prop.store(fos, "");
        fos.close();
        fis.close();
    }
}
