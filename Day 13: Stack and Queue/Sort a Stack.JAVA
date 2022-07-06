
import java.util.*;
public class Solution {

	public static void sortStack(Stack<Integer> stack) {
		if(stack.size()==1)return ;
        Integer i=stack.pop();
        sortStack(stack);// removing all the elements
        insert(stack,i);
	}
    public static void insert(Stack<Integer>stack, int element){
        if(stack.size()==0 || stack.peek()<element){
            stack.push(element);  // agar ye element bada hai toh
            return;
        }
        Integer j=stack.pop();
        insert(stack,element);// trying to add element here :)
        stack.push(j);      // after insertion add this
    }  
}
