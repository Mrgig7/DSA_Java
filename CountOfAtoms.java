import java.util.*;

public class CountOfAtoms {
    public String countOfAtoms(String formula) {
        Stack<Map<String, Integer>> stack = new Stack<>();
        stack.push(new HashMap<>());
        int n = formula.length();
        int i = 0;

        while (i < n) {
            if (formula.charAt(i) == '(') {
                stack.push(new HashMap<>());
                i++;
            } else if (formula.charAt(i) == ')') {
                Map<String, Integer> top = stack.pop();
                i++;
                int start = i;
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                int multiplicity = i > start ? Integer.parseInt(formula.substring(start, i)) : 1;
                Map<String, Integer> currentMap = stack.peek();
                for (String key : top.keySet()) {
                    currentMap.put(key, currentMap.getOrDefault(key, 0) + top.get(key) * multiplicity);
                }
            } else {
                int start = i;
                i++;
                while (i < n && Character.isLowerCase(formula.charAt(i))) {
                    i++;
                }
                String name = formula.substring(start, i);
                start = i;
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                int multiplicity = i > start ? Integer.parseInt(formula.substring(start, i)) : 1;
                Map<String, Integer> currentMap = stack.peek();
                currentMap.put(name, currentMap.getOrDefault(name, 0) + multiplicity);
            }
        }

        Map<String, Integer> result = stack.pop();
        List<String> sortedKeys = new ArrayList<>(result.keySet());
        Collections.sort(sortedKeys);
        StringBuilder sb = new StringBuilder();
        for (String key : sortedKeys) {
            sb.append(key);
            int count = result.get(key);
            if (count > 1) {
                sb.append(count);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        CountOfAtoms obj = new CountOfAtoms();
        String formula = "Mg(OH)2";
        System.out.println(obj.countOfAtoms(formula)); 
    }
}
