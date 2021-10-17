//https://leetcode.com/problems/most-frequent-subtree-sum/
class Solution {
    
    int maxSumCount;
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer,Integer>sumCounts  = new HashMap<Integer,Integer>();
        maxSumCount = 0;
        findSubTreeSum(root,sumCounts);
        List<Integer>list = new ArrayList<>();
        for(Map.Entry<Integer,Integer>entry:sumCounts.entrySet()){
            
            int value= entry.getValue();
            if(value==maxSumCount)
                list.add(entry.getKey());
        }
        int result[]  = new int[list.size()];
        for(int i=0;i<list.size();i++){
            result[i] = list.get(i);
        }
        return result;
        
        
    }
    
    public int findSubTreeSum(TreeNode root,Map<Integer,Integer>sumCounts){
        
        if(root==null)
            return 0;
        int leftSum = findSubTreeSum(root.left,sumCounts);
        int rightSum = findSubTreeSum(root.right,sumCounts);
        int totalSum = leftSum+rightSum+root.val;
        int totalSumCount = sumCounts.getOrDefault(totalSum,0)+1;
        sumCounts.put(totalSum,totalSumCount);
        maxSumCount = Math.max(maxSumCount,totalSumCount);
        return totalSum;
    }
}

//TC:- O(n)
//SC:- O(n)
