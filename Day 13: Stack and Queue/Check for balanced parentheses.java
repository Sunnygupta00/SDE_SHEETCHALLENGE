class Solution {
 public static boolean isValid(String s) {
	Deque <Character>st=new ArrayDeque<Character>();
	for(char c:s.toCharArray())  // INSERTING ONLY OPENING BRACKETS BECAUSE AT THE TIME OF CLOSING BRACKET WE CAN EASILY CHECK
	{
		if(c=='(')
		{
			st.push(')');
		}
		else if(c=='{')
		{
			st.push('}');
		}
		else if(c=='[')
		{
			st.push(']');
		}
		else if(st.isEmpty()||st.pop()!=c){ // IF NO VALUE IS THERE OR BOTH THE BRACKETS ARE NOT MATCHING RETURN FALSE;
			return false;
		}
        
	}
	return st.isEmpty();
}
}
