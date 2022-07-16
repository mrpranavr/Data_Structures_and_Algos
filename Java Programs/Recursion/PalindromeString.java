// Check whether string is palindrome or not using recursion

class PalindromeString {

    static boolean isPalin(String s, int l, int r){
        if(l >= r){
            return true;
        }

        if(s.charAt(l) != s.charAt(r)){
            return false;
        }

        return isPalin(s,l+1,r-1);
    }

    public static void main(String[] args) {
        String word = "racecar";
        int l = 0;
        int r = word.length() - 1;
        System.out.println(isPalin(word,l,r));
    }
}