import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

public class main {
    public static int missingNumber(int[] nums, int maxNum){
        Set<Integer> set= Arrays.stream(nums).boxed().collect(Collectors.toSet());
        for(int i = 1; i < maxNum; i++){
            if(!set.contains(i)){
                return i;
            }
        }
        return 0;
    }

    public static boolean balancedParenth(String s){
        int leftParenth = 0;
        int rightParenth = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                leftParenth++;
            } else if(s.charAt(i) == ')'){
                rightParenth++;
            }
            if(leftParenth == rightParenth){
                return true;
            }
        }
        return false;
    }

    public static boolean balancedBrackets(String s){
        Stack<Character> stack = new Stack<Character>();
        HashMap<Character, Character> bracketPairs = new HashMap<Character, Character>();
        bracketPairs.put(')', '(');
        bracketPairs.put(']','[');
        bracketPairs.put('>','<');
        bracketPairs.put('}','{');

        for(int i = 0; i < s.length(); i++){
            if(bracketPairs.containsValue(s.charAt(i))){
                stack.push(s.charAt(i));
            } else if(bracketPairs.containsValue(s.charAt(i))){
                if(stack.isEmpty()){
                    return false;
                }
                Character mostRecentBracket = stack.pop();
                if (!mostRecentBracket.equals(bracketPairs.get(s.charAt(i)))){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    public static void main (String[] args){
        System.out.print(missingNumber(new int[]{2, 1, 4, 3, 6, 5, 7, 10, 9}, 10));
    }
}
