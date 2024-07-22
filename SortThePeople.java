import java.util.*;
public class SortThePeople {
    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            map.put(heights[i], names[i]);
        }
        List<Map.Entry<Integer, String>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (a, b) -> b.getKey() - a.getKey());
        String[] res = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            res[i] = list.get(i).getValue();
        }
        return res;
    }

    public static void main(String[] args){
        SortThePeople stp = new SortThePeople();
        String[] names = {"Mary","John","Emily"};
        int[] heights = {180,165,170};
        String[] sortedNames = stp.sortPeople(names, heights);
        for(String name : sortedNames){
            System.out.println(name);
        }
    }

}
