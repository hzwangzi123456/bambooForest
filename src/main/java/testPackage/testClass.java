package testPackage;

import com.bamboo.vo.User;

/**
 * @author wangzi
 * @date 18/2/1 上午4:53.
 */
public class testClass {
    public static void main(String[] args) {

        int a;
        //user其实是一个引用变量(就是c语言里的指针变量)
        //u1:引用变量 == 地址变量 == 指针变量(c),
        User u1 = new User();
        User u2 = new User();
        System.out.println("u1里面放的值" + u1);
        System.out.println("u2里面放的值" + u2);
//        initUser01(u1);
    }

    /**
     * 初始化user的值
     *
     * @param uTemp 等待初始化的user 对象
     * @return true:初始化成功,false:失败
     */
    public static boolean initUser01(User uTemp) {//形参 -> null
        System.out.println("uTemp里面放的值:" + uTemp);
        uTemp.setId(1);
        uTemp.setPassword("123");
        uTemp.setUsername("wangzi");
        return true;
    }


    /**
     * 初始化user的值
     *
     * @param u 等待初始化的user 对象
     */
    public static void initUser02(User u) {
        u.setId(2);
        u.setPassword("123456");
        u.setUsername("zhouzhixing");
    }

    /**
     * 打印user里面的信息
     *
     * @param u 等待打印的user 对象
     */
    public static void printUser(User u) {
        System.out.println("开始打印");
        System.out.println("user的id:" + u.getId());
        System.out.println("user的密码:" + u.getPassword());
        System.out.println("user的账号" + u.getUsername());
        System.out.println();
    }

//    public static void testFun() {
////        System.out.println(Uuid.get32UUID());
//        Uuid uuid = new Uuid();
//        System.out.println(uuid.get32UUID());
//    }
}
