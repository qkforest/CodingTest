/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public NestedInteger deserialize(String s) {
        if(s.charAt(0) != '[') {
            return new NestedInteger(Integer.parseInt(s));
        }
        StringBuilder num = new StringBuilder();
        Deque<NestedInteger> stack = new ArrayDeque<>();
        for(char c : s.toCharArray()) {
            if(c == '[') {
                stack.push(new NestedInteger());
            }
            else if(c == ',' || c == ']'){
                if(num.length() > 0) {
                    stack.peek().add(new NestedInteger(Integer.parseInt(num.toString())));
                    num.setLength(0);
                }
                if(stack.size() > 1 && c == ']') {
                    NestedInteger nestedInteger = stack.pop();
                    stack.peek().add(nestedInteger);
                }
            }
            else {
                num.append(c);
            }
        }
        return stack.peek();
    }
}