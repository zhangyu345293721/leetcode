package leetcode.TestWeb;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: Direction2
 * @Description: TOTO
 * @date 2018/12/17 21:52
 **/


public enum Direction2 {
    FRONT("前面"), DEHIND("后面"), LEFT("左面"), RIGHT("右面");
    private String explain;

    Direction2(String explain) {
        this.explain = explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public String getExplain() {
        return explain;
    }

}
