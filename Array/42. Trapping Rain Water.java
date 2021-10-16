
//https://leetcode.com/problems/trapping-rain-water/
class Solution {
    public int trap(int[] height) {
        
        int len = height.length;
        
        if(len<3)
            return 0;
       
        int leftMax[]= new int[len];
        int rightMax[] = new int[len];
        leftMax[0] = height[0];
        for(int i=1;i<len;i++)
            leftMax[i] = Math.max(height[i],leftMax[i-1]);
        rightMax[len-1] = height[len-1];
        for(int i = len-2;i>=0;i--)
            rightMax[i]=Math.max(height[i],rightMax[i+1]);
        long count =0;
        for(int i=1;i<len-1;i++)
            count+=Math.min(leftMax[i],rightMax[i])-height[i];
        
        return (int)count;
        
    }
}

//TC:-O(n)
//SC:-O(n)  
//Space complexity can be optimized to O(1) using two pointer approach.
