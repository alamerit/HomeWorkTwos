import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Integer[] array = new Integer[10];
        initUi(array);
        System.out.println(Arrays.toString(array));
        System.out.println( findElement(array,5));
        array = addElement(array,10,10);
        System.out.println(Arrays.toString(array));
        array = removeElement(array,5);
        System.out.println(Arrays.toString(array));
        fillRandom(array,100);
        System.out.println(Arrays.toString(array));

    }

    private static void fillRandom(Integer[] array, int t) {
        Random r = new Random();
        for (int i = 0; i<array.length; i++){
            array[i] = r.nextInt(t);
        }
    }

    public static Integer [] addElement (Integer[] array, int index , int element){
    Integer[] outputArray = new Integer[array.length +1];
    for (int i = 0 ; i <= array.length;i++){
        if (i > index){
            outputArray[i] = array[i-1];
        }else if (i == index){
            outputArray[i] = element;
        }else {
            outputArray[i] = array [i];
        }
    }
    return outputArray;

}


private  static Integer [] removeElement(Integer[] array,int element){
       Integer[] outputArray = new Integer[array.length - 1];
       int index = -1;
       for(int j = 0;j < array.length; j++ ){
           if(array[j] == element) {
               index = j;
               break;

           }
       }
       if (index == -1){
           throw new IllegalArgumentException("Element not found");
       }
       for (int i = 0 ; i < outputArray.length;i++) {
           if (i < index){
               outputArray[i] = array[i];
           } else  {
               outputArray[i] = array[i+1];
           }
       }
       return outputArray;
}

   private static void initUi(Integer[] array){
        int i = 0,j=array.length;
        while (i<array.length){
            array[i] = j;
            i++;
            j--;
        }

   }

   private  static Integer  findElement(Integer[] array, int element){
       System.out.println("find element");
        int divisible = array.length/2;
        if (array[divisible] < element) {
            return findElement(Arrays.copyOf(array, divisible), element);
        }else  if (array[divisible] == element){
            return  divisible;
        }else {
            return  findElement(Arrays.copyOfRange(array,divisible,array.length),element);
        }

   }
}
