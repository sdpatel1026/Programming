//https://leetcode.com/problems/decode-string/

class Solution 
{
    
    int i=0;
    public String decodeString(String str) 
    {
          int num = 0;
          StringBuilder result = new StringBuilder();
          while(i<str.length())
          {
                  char ch  = str.charAt(i);
                  if(Character.isDigit(ch))
                      num = num*10+(ch-'0');
                  else if(ch=='[')
                  {
                      i++;
                      String subResult = decodeString(str);
                      subResult = appendStringGivenTimes(num,subResult);
                      result.append(subResult);
                      num = 0;
                  }else if(ch==']'){
                    return result.toString();
                  }else{
                      result.append(ch);
                  }
                  i++;


          } 
          return result.toString();
    }
    
   

        String appendStringGivenTimes(int times,String subresult)
        {
              StringBuilder appendedString = new StringBuilder();
              while(times-->0)
                  appendedString.append(subresult);
              return appendedString.toString();
        }
}

TC:- O(n)
SC:- O(n)  
