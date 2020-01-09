package leetcodejava.string;


import org.junit.Test;

/**
 * 劝阻IP
 *
 * @author: zhangyu
 */
public class DefangingIP1108 {

    @Test
    public void defangingIpTestDemo() {
        String address = "255.100.50.0";
        String s = defangIPaddr2(address);
        System.out.println("s = " + s);
    }

    /**
     * 对于.位置改为[.]
     *
     * @param address 地址
     * @return
     */
    public String defangIPaddr(String address) {
        return address.replaceAll("\\.", "[\\.]");
    }

    /**
     * 对于.位置改为[.]
     *
     * @param address 地址
     * @return 修改
     */
    public String defangIPaddr2(String address) {
        StringBuilder sb = new StringBuilder();
        for (char ch : address.toCharArray()) {
            if (ch == '.') {
                sb.append("[.]");
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
