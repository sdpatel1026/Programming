//Leetcode https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int sum = 0;
    Map<Integer,Integer>parentMap;
    public int sumEvenGrandparent(TreeNode root) {
        
        parentMap = new HashMap<Integer,Integer>();
        calculateSum(root,1);
        return sum;
      
        
    }
    
    public void calculateSum(TreeNode root,int level){
        if(root==null)
            return;
        
        Integer grandParentsLevel = level-2; //Integer grandParentsLevel = level-k
        if(parentMap.containsKey(grandParentsLevel)&&parentMap.get(grandParentsLevel)%2==0)
        {
                sum+=root.val;   
        }
        parentMap.put(level,root.val);
        calculateSum(root.left,level+1);
        calculateSum(root.right,level+1);
        parentMap.remove(level);
       
    }
}
// TC:-O(n)
// SC:-O(n) for worst case like skew tree  


//This solution can be used for following problem statement by updating line no. 34 as show in comment.
//Statement:- We are given a Binary Tree and a number k. We want to find the sum of all nodes whose kth parent is even
