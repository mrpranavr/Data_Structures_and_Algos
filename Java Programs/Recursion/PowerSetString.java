// print the powerset of the given word
// abc = {" ", a,b,c,ab,bc,ac,abc}
// time complexity - O(2^n)

class PowerSetString {

    static void powerSet(String s, int i, String curr) {
        if(i == s.length()){
            System.out.print(curr + ",");
            return;
        }

        powerSet(s,i+1, curr + s.charAt(i));
        powerSet(s, i+1, curr);
    }

    public static void main(String[] args) {
        powerSet("abc", 0, " ");
    }
}