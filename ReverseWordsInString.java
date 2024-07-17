public class ReverseWordsInString {
    public String reverseWords(String s) {
        s = s.trim();
        StringBuilder sb = new StringBuilder();
        String[] arr = s.split("\\s+");

        for (int i = arr.length - 1; i >= 0; i--) {
            sb.append(arr[i]);
            sb.append(" ");
        }

        return sb.toString().trim();
    }
    public static void main(String[] args) {
        ReverseWordsInString solution = new ReverseWordsInString();
        String s = "the sky is blue";
        System.out.println(solution.reverseWords(s));   
    }
}
