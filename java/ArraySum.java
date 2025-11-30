public class ArraySum{
    public static void main (String[] args){

    int[] arr1 = {1,2,3,4,5};
    int[] arr2 = {6,7,8,9,10};

    int sum1 = 0, sum2 = 0, Total = 0;

    for(int i = 0; i < arr1.length; i++){
        sum1 += arr1[i];
    }

    for(int j = 0; j < arr2.length; j++){
        sum2 += arr2[j];
    }
    Total = sum1 + sum2;
    System.out.println("Sum of two arrays is: " + Total);
}
}