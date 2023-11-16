package class004;

/**
 * @author : YINAN
 * @date : 2023/11/14
 * @effect :
 */
public class SelectBubbleInsert {


    public static void main(String[] args) {
        int[] arr = new int[]{2,31,5,9,7,6,8,3,5,7};
        printArr(arr);
        System.out.println("===原数组===");
//        selectionSort(arr);
//        printArr(arr);
//        System.out.println("===选择排序===");
//        bubbleSort(arr);
//        printArr(arr);
//        System.out.println("===冒泡排序===");

        insertSort(arr);
        printArr(arr);
        System.out.println("===插入排序===");


    }

    // 数组中交换i和j位置的数
    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // 选择排序
    private static void selectionSort(int[] arr){
        if(arr == null || arr.length < 2)
            return;
        for(int i = 0; i < arr.length - 1; i++){
            int minIndex = i;
            for(int j = i + 1; j < arr.length; j++){
                if(arr[minIndex] > arr[j])
                    minIndex = j;
            }
            swap(arr, i , minIndex);
        }
    }

    // 冒泡排序
    public static void bubbleSort(int[] arr){
        if(arr == null || arr.length < 2)
            return;
        for(int i = arr.length - 1; i > 0; i--){
            for(int j = 0; j < i; j++){
                if(arr[j] > arr[j+1])
                    swap(arr, j, j+1);
            }
        }
    }

    // 插入排序
    public static void insertSort(int[] arr){
        if(arr == null || arr.length < 2)
            return;
        for(int i = 1; i < arr.length; i++){
            int tmp = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j] > tmp){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = tmp;
        }
    }


    // 打印数组
    public static void printArr(int[] arr){
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
}
