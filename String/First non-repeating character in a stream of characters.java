//Problem Statement
//https://www.interviewbit.com/problems/first-non-repeating-character-in-a-stream-of-characters/

public class Solution {
    public String solve(String A) {

        
        StringBuilder result = new StringBuilder();
        int i=0;
        Queue<Character>queue = new LinkedList<>();
        HashMap<Character,Integer>map = new HashMap();
        while(i<A.length()){
            char ch = A.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
            if (map.get(ch)==1)
             queue.add(ch);
            
            while(!queue.isEmpty()&&map.get(queue.peek())>1)
              queue.remove();
             
              if(!queue.isEmpty())
               result.append(queue.peek());
               else{
                   result.append("#");
               }
               i++;

        }
        return result.toString();

    }
}
//TC:-O(n)
//SC:- O(n)
