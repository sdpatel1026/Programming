// https://practice.geeksforgeeks.org/problems/next-larger-element-1587115620/1
class Solution
{
    //Function to find the next greater element for each element of the array.
    public static long[] nextLargerElement(long[] arr, int n)
    { 
        long[] resultArr = new long[n];
        Stack<Long>stack = new Stack<>();
        
        for(int i=n-1;i>=0;i--){
            
               long currentData = arr[i];
           
               while(!stack.isEmpty()&&stack.peek()<currentData)
                 stack.pop();
                if(stack.isEmpty())
                 resultArr[i]=-1;
                else
                 resultArr[i] = stack.peek();
                 
                stack.push(currentData); 
        }
        return resultArr;
    } 
}


TC:- O(n)
SC:- O(n)  
