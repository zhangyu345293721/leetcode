package leetcode.array.arrangementselect;


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
        String path = "d://count.txt";
        int time = 5;
        String comment = "comment";
        runFixedTime(path, time, comment);
    }

    /**
     * 文件能执行次数
     *
     * @param filePath 文件名字
     * @param time     次数
     * @param comment  评论
     */
    public void runFixedTime(String filePath, int time, String comment) {
        Properties prop = new Properties();
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try (FileInputStream fis = new FileInputStream(file)) {
            prop.load(fis);
            int count = 0;
            String value = prop.getProperty("time");
            if (value != null) {
                count = Integer.parseInt(value);
                if (count > time) {
                    System.out.println("您好你的使用次数已经到了，该充钱了!");
                    return;
                }
                System.out.println(count);
            }
            count++;
            prop.setProperty("time", count + "");
        } catch (Exception e) {
        }
        try (FileOutputStream fos = new FileOutputStream(file)) {
            prop.store(fos, "");
        } catch (Exception e) {

        }
    }
}
