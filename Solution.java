import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        //System.out.println("Enter the no. of elements in array: ");
        int n = s.nextInt();
        //System.out.println("Enter the elements in array: ");
        double[] array = new double[n];
        for(int i=0;i<n;i++)
        {
            array[i] = s.nextDouble();
        }

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(array[i]>array[j]){
                    double temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

        Solution ss = new Solution();
        double mean = ss.mean(array,n);
        System.out.printf("%.1f\n",mean);
        double median = ss.median(array,n);
        System.out.printf("%.1f\n",median); 
        double mode = ss.mode(array,n);
        System.out.println(mode);       
    }

    public double mean(double[] array, int n){
        double sum = 0;
        for(int i=0;i<n;i++){
            sum += array[i];
        }
        sum /= n;
        return sum;
    }

    public double median(double[] array, int n){
        double sum =0;
        if(n%2==0){
            sum = array[n/2]+array[(n/2)-1];
            sum /= 2;
        }
        else{
            sum = array[n/2];
        }
        return sum;
        
    }

    public double mode(double[] array, int n){
        double result=0;
        double[][] sum = new double[n][1];
        for(int i=0;i<n;i++){
            sum[i][0]=1;
            for(int j=i+1;j<n;j++){
                if(array[i]==array[j]){
                    sum[i][0] += 1;
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(sum[i][0] > sum[j][0]){
                    double temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                    double temp2 = sum[i][0];
                    sum[i][0] = sum[j][0];
                    sum[j][0] = temp2;
                }   
            }
        }
        result = array[0];
        return result;

    }
}
