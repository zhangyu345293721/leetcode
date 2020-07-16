package leetcode.math;

import org.junit.Test;

/**
 * @author: zhangyu
 * @date: 2020/04/11 23:56
 */
public class SuperEggDrop {

    @Test
    public void testSuperEggDrop(){
        int k=2;
        int n=6;
        int res=dp(k,n);
        System.out.println(res);
    }

    private int dp(int K, int N) {
        int res=Integer.MAX_VALUE;
        if(K == 1){ return N;}
        if (N == 0){ return 0;}
        for(int i=1;i<=N;i++){
            res = Math.min(res, Math.max(dp(K - 1, i - 1), dp(K, N - i)) + 1);
        }
        return res;
    }
}
