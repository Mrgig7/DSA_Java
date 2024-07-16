public class MinimumWindowSubstring{
    public String minWindow(String s, String t) {
        int[] li = new int[128];
        int[] ne = new int[128];
        int[] h = new int[128];
        int ct = 0;
        for (char c : t.toCharArray()) {
            ne[c]++;
            ct++;
        }
        int l = 0, r = 0, ml = Integer.MAX_VALUE, st = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            h[c]++;
            if (ne[c] > 0 && h[c] <= ne[c]) {
                ct--;
            }
            while (ct == 0) {
                if (r - l + 1 < ml) {
                    ml = r - l + 1;
                    st = l;
                }
                char d = s.charAt(l);
                h[d]--;
                if (ne[d] > 0 && h[d] < ne[d]) {
                    ct++;
                }
                l++;
                }
                r++;
                }
                
        return ml == Integer.MAX_VALUE? "" : s.substring(st, st + ml);
    }
    
    public static void main(String[] args) {
        MinimumWindowSubstring mws = new MinimumWindowSubstring();
        System.out.println(mws.minWindow("ADOBECODEBANC", "ABC"));
    }
}