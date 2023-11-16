package class005;

/**
 * @author : YINAN
 * @date : 2023/11/15
 * @effect :
 */

/**
 * 1、你想测的方法a（最优解）
 * 2、实现复杂度不好但是容易实现的方法b（暴力破解）
 * 3、实现一个随机样本产生器（长度随机，值也随机）
 * 4、把方法a和方法b跑相同的输入样本，看看结果是否一样
 * 5、如果有一个随机样本使得对比结果不一致，打印这个出错的样本进行人工干预，改对方法a和方法b
 * 6、当样本数量很多时比对测试是否依然正确，可以确定方法a（最优解）已经正确。
 */
public class Validator {

    public static void main(String[] args) {
        // 随机数组最大长度
        int N = 10;
        // 随机数值在1~V之间
        int V = 1000;
        // 测试次数 testTimes
        int testTimes = 10000;
        System.out.println("测试开始");
        for(int i = 0; i < testTimes; i++){
            int n = (int)(Math.random() * N);
            // 得到随机数组
            int[] arr = randomArray(n, V);
            int[] arr1 = copyArray(arr);
            int[] arr2 = copyArray(arr);
            int[] arr3 = copyArray(arr);
            selectionSort(arr1);
            bubbleSort(arr2);
            insertionSort(arr3);
            if(!sameArray(arr1, arr2) || !sameArray(arr2, arr3)){
                System.out.println("出错了!");
                printArray(arr);
                printArray(arr1);
                printArray(arr2);
                printArray(arr3);
                break;
            }
        }
        System.out.println("测试结束.");
    }



    public static boolean sameArray(int[] arr1, int[] arr2){
        int n = arr1.length;
        for(int i = 0; i < n; i++){
            if(arr1[i] != arr2[i])
                return false;
        }
        return true;
    }

    public static void printArray(int[] arr){
        if(arr == null || arr.length ==0){
            System.out.println("[]");
            return;
        }
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < arr.length; i++){
            if(i == 0){
                res.append("[");
            }
            res.append(arr[i]);
            if(i != arr.length -1){
                res.append(",");
            }else{
                res.append("]");
            }
        }
        System.out.println(res);
    }






    // 得到一个长度位n的数组，每个元素的大小在[1,v]之间的整数
    public static int[] randomArray(int n, int v){
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            // Math.random() * v -> double -> [0,v)一个小数
            arr[i] = (int)(Math.random() * v) + 1;
        }
        return arr;
    }


    // 复制数组
    // 为了验证
    public static int[] copyArray(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            ans[i] = arr[i];
        }
        return ans;
    }



    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    private static void selectionSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        for(int i = 0; i < arr.length - 1; i++){
            int minIndex = i;
            for(int j = i + 1; j < arr.length; j++){
                if(arr[minIndex] > arr[j])
                    minIndex = j;
            }
            swap(arr, i, minIndex);
        }
    }

    private static void bubbleSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        for(int i = arr.length - 1; i > 0; i--){
            for(int j = 0; j < i; j++){
                if(arr[j] > arr[j+1]){
                    swap(arr, j, j+1);
                }
            }
        }
    }

    private static void insertionSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        for(int i = 1; i < arr.length; i++){
            int j = i - 1;
            int tmp = arr[i];
            while(j >= 0 && arr[j] > tmp){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = tmp;
        }
    }
}
