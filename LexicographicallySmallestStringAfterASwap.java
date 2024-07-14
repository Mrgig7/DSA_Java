public class LexicographicallySmallestStringAfterASwap{
    public String smallestString(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;

        for (int i = 0; i < n - 1; i++) {
            if ((ch[i] - '0') % 2 == (ch[i + 1] - '0') % 2) {
                if (ch[i] > ch[i + 1]) {
                    char t = ch[i];
                    ch[i] = ch[i + 1];
                    ch[i + 1] = t;
                    break;
                }
            }
        }
        return new String(ch);
    }
    public static void main(String[] args) {
        LexicographicallySmallestStringAfterASwap l = new LexicographicallySmallestStringAfterASwap();
        String s = "45320";
        System.out.println(l.smallestString(s));
    }
}