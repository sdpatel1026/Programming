//https://leetcode.com/problems/find-bottom-left-tree-value/
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        
        int result  = -1;
        Queue<TreeNode>queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            
            result =  queue.peek().val;
             while(size-->0){
                 
                 TreeNode node = queue.remove();
                 if(node.left!=null)
                     queue.add(node.left);
                 if(node.right!=null)
                     queue.add(node.right);
             }
            
        }
        return result;
        
    }
}

//TC:- O(n)
//SC :- O(n)
