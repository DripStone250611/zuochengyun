package class003;

/**
 * @author : YINAN
 * @date : 2023/11/14
 * @effect :
 */
public class BinarySystem {


    // 打印一个int类型的数字，32位进制的状态
    // 左侧是高位，右侧是低位
    public static void printBinary(int num){
        for(int i = 31; i >= 0; i--){
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }

    public static void main(String[] args){

        //非负数
        int a = 78;
        System.out.println(a);
        printBinary(a);
        System.out.println("===a===");

        //负数
        int b = -6;
        System.out.println(b);
        printBinary(b);
        System.out.println("===b===");

        //直接写二进制得形式定义变量
        int c = 0b1001110;
        System.out.println(c);
        printBinary(c);
        System.out.println("===c===");

        //直接写16进制定义变量
        int d = 0x4e;
        System.out.println(d);
        printBinary(d);
        System.out.println("===d===");

        //~、相反数
        System.out.println(a);
        printBinary(a);
        printBinary(~a);
        int e = ~a + 1;
        System.out.println(e);
        printBinary(e);
        System.out.println("===e===");

        // int、long的最小值，取相反数、绝对值，都是自己
        int f = Integer.MIN_VALUE;
        System.out.println(f);
        printBinary(f);
        printBinary(-f);
        System.out.println(~f + 1);
        printBinary(~f + 1);
        System.out.println("===f===");

        // | & ^
        int g = 0b0001010;
        int h = 0b0001100;
        printBinary(g | h);
        printBinary(g & h);
        printBinary(g ^ h);
        System.out.println("===g、h===");
        System.out.println("test1测试开始");
        boolean test1 = returnTrue() | returnFalse();
        System.out.println("test1结果," + test1);
        System.out.println("test2测试开始");
        boolean test2 = returnTrue() || returnFalse();
        System.out.println("test2结果," + test2);
        System.out.println("test3测试开始");
        boolean test3 = returnFalse() & returnTrue();
        System.out.println("test3结果，" + test3);
        System.out.println("test4测试开始");
        boolean test4 = returnFalse() && returnTrue();
        System.out.println("test4结果，" + test4);
        System.out.println("===|、&、||、&&===");
        // <<
        int i = 0b0011010;
        printBinary(i);
        printBinary(i << 1);
        printBinary(i << 2);
        printBinary(i << 3);
        System.out.println("===i <<  ===");



    }

    public static boolean returnTrue(){
        System.out.println("进入了returnTrue函数");
        return true;
    }
    public static boolean returnFalse(){
        System.out.println("进入了returnFalse函数");
        return false;
    }
}
