public class Candy {
    public int candy(int[] r) {
        if (r == null || r.length == 0)
            return 0;
        int t = 1, p = 1, c = 0;
        for (int i = 1; i < r.length; i++) {
            if (r[i] >= r[i - 1]) {
                if (c > 0) {
                    t += c * (c + 1) / 2;
                    if (c >= p)
                        t += c - p + 1;
                    c = 0;
                    p = 1;
                }
                p = r[i] == r[i - 1] ? 1 : p + 1;
                t += p;
            } else
                c++;
        }
        if (c > 0) {
            t += c * (c + 1) / 2;
            if (c >= p)
                t += c - p + 1;
        }
        return t;
    }

    public static void main(String[] args) {
        Candy candy = new Candy();
        int[] ratings = { 1, 0, 2 };
        System.out.println(candy.candy(ratings));
    }
}