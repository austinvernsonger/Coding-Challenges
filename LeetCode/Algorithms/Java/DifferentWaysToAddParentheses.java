/*
 * Given a string of numbers and operators, return all 
 * possible results from computing all the different 
 * possible ways to group numbers and operators. The 
 * valid operators are +, - and *.


 * Example 1
 * Input: "2-1-1".
 * 
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 * Output: [0, 2]
 * 
 * 
 * Example 2
 * Input: "2*3-4*5"
 * 
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 * Output: [-34, -14, -10, -10, 10]
 */
public class DifferentWaysToAddParentheses {

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<Integer>();
        boolean isAllDigit = true;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                isAllDigit = false;
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (int lValue : left) {
                    for (int rValue : right) {
                        result.add(calc(lValue, rValue, c));
                    }
                }
            }
            if (i == input.length() - 1 && isAllDigit) 
                result.add(Integer.parseInt(input));
        }
        return result;
    }

    public int calc(int a, int b, char operator) {
        switch (operator) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b;
        }
        return Integer.parseInt(null);
    }

}
