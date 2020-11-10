package YuchenZhao.No4.run;

public class Calculation {  
    //method that returns maximum number  
    public static int findMax(int arr[]){  
        int max = arr[0];  
        for(int i = 1; i < arr.length; i++){  
            if(max < arr[i])  
                max = arr[i];  
        }  
        return max;  
    }
    
}  