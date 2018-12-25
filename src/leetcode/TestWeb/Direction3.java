package leetcode.TestWeb;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: Direction3
 * @Description: TOTO
 * @date 2018/12/17 21:59
 **/


public enum Direction3 {
    FRONT() {
        public void fun() {
            System.out.println("FROND：重写了fun()方法");
        }
    },
    BEHIND() {
        public void fun() {
            System.out.println("BEHIND：重写了fun()方法");
        }
    },
    LEFT() {
        public void fun() {
            System.out.println("LEFT：重写了fun()方法");
        }
    },
    RIGHT() {
        public void fun() {
            System.out.println("RIGHT：重写了fun()方法");
        }
    };

    public void fun() {
        System.out.println("没有意义的方法");
    }
}

