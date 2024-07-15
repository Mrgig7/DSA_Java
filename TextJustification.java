
import java.util.*;

public class TextJustification{
public List<String> fullJustify(String[] words, int mw) {
    List<String> r = new ArrayList<>();

    for(int i=0; i<words.length; i++) {
        StringBuilder sb = new StringBuilder();
        int l = 0,wl =0,s=i,e = i;
        while(e<words.length && l + words[e].length() <= mw) {
            l += words[e].length()+1;
            wl += words[e].length();
            e++;
        }
        int g = e - s - 1;
        int p = e == words.length ? g : mw-wl;

        int sp = g == 0 ? 1 : p / g;
        int es = g != 0 ? p % g : 0;
        for(int j=s; j<e; j++) {
            sb.append(words[j]);
            if(j!= e-1) {
                sb.append(" ".repeat(sp));
            }
            if(es>0) {
                sb.append(" ");
                es--;
            }
        }
        while(sb.length() < mw) {
            sb.append(" ");
        }
        i = e-1;
        r.add(sb.toString());
    }
    return r;
}

public static void main(String[] args) {
    TextJustification t = new TextJustification();
    String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
    int maxWidth = 16;
    System.out.println(t.fullJustify(words, maxWidth));
}
}