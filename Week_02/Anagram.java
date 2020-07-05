//是否是异位词
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        char[] ss=s.toCharArray();
        char[] tt=t.toCharArray();
        HashMap<Character,Integer> hashmap=new HashMap();
        for(int i=0;i<ss.length;i++){
            if(hashmap.containsKey(ss[i])){
                hashmap.put(ss[i],hashmap.get(ss[i])+1);
            }else{
                hashmap.put(ss[i],1);
            }
        }
        for(char ch:tt){
            //比如上一步，存的是a 2  b 3 c 4
            //这里取出了b
            Integer count=hashmap.get(ch);
            if(count==null){
                return false;
            }else if(count>1){
                hashmap.put(ch,count-1);
            }else{ //说明这里a已经取完了
                hashmap.remove(ch);
            }
        }
        return hashmap.isEmpty();
    }
}