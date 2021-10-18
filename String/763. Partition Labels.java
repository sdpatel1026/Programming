//https://leetcode.com/problems/partition-labels/

// 1st solution
class Solution {
    public List<Integer> partitionLabels(String S) 
    {
          Map<Character,Pair>map = new HashMap<>();
          PriorityQueue<Pair>pq = new PriorityQueue<>((p1,p2)->p1.start-p2.start);
          List<Integer>result = new ArrayList<>();
          for(int i=0;i<S.length();i++)
          {
              char ch = S.charAt(i);
              if(!map.containsKey(ch))
              {
                  Pair pair = new Pair(i);
                  map.put(ch,pair);
                  pq.add(pair);
              }
              else
              {
                  map.get(ch).end = i;
              }
          }
         
          Pair prev = pq.remove();
          while(!pq.isEmpty())
          {
              Pair  curr = pq.remove();
              if(prev.end<curr.start)
              {
                  result.add(prev.end-prev.start+1);
                  prev = curr;
              }
              else
              {
                  prev.end = Math.max(prev.end,curr.end);
              }
          }
        
          result.add(prev.end-prev.start+1);
          return result;
    }
}

class Pair
{
    int start,end;
    public Pair(int s)
    {
        start = end = s;
    }
}

//TC:- O(nlogn)
//SC:- O(n)

// 2nd solution

class Solution {
    public List<Integer> partitionLabels(String s) 
    {
          List<Integer>resultList = new ArrayList<>();
          Map<Character,Integer>map  = new HashMap<>();
          int len = s.length();
        
        for(int i=len-1;i>=0;i--)
        {
            char ch = s.charAt(i);
            if(!map.containsKey(ch))
                map.put(ch,i);
        }
        int partitionStartIndex = 0;
        int partitionLastIndex = 0;
        int i=0;
        while(i<len&&partitionLastIndex<len){
            
            char ch = s.charAt(i);
            partitionLastIndex = Math.max(partitionLastIndex,map.get(ch));
            if(partitionLastIndex==i){
                int sizeOfPartition = partitionLastIndex - partitionStartIndex+1;
                resultList.add(sizeOfPartition);
                 partitionLastIndex++;
                partitionStartIndex = partitionLastIndex;
               
            }
            i++;
        }
        return resultList;
    }
}
//TC:- O(n)
//SC:- O(n)
