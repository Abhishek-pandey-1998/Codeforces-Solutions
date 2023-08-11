import java.util.*;
import java.lang.*;

/* Name of the class has to be "Main" only if the class is public. */
public class ArrayColoring
{

	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            int n = sc.nextInt();
            int arr[] = new int[n];
            int tot = 0;
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
                tot+=arr[i];
            }
            boolean temp1 = ArrayColoring.findSol(0,n,arr[0],tot-arr[0],arr);
            boolean temp2 = ArrayColoring.findSol(0,n,0,tot,arr);
            boolean res = (temp1 || temp2);
            if(res==true){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
            t--;
        }
    }

    public static boolean findSol(int i,int n,int curr,int rem,int[] arr){
        if(i>=n){
            return false;
        }
        if(curr!=0){
            if((curr%2==0 && rem%2==0) || (curr%2!=0 && rem%2!=0)){
                return true;
            }
            return false;
        }
        boolean temp = findSol(i+1,n,curr+arr[i],rem-(curr+arr[i]),arr);
        if(temp==true){
            return true;
        }
        boolean temp1 = findSol(i+1,n,curr,rem,arr);
        return (temp || temp1);
    }
}