// Print all permutations of the string
// abc -> {abc,acb,bac,bca,cab,cba}
// Time complexity - O(n*n!)

class PermutationString {

    static void permute(String s, int l , int r){
        if(l == r){
            System.out.print(s+ " ");
            return;
        }

        for(int i = l; i<= r; i++) {
            s = swap(s,l,i);
            permute(s,l+1,r);
            s = swap(s,l,i);
        }
    }

    static String swap(String s, int l, int i){
        char ch[] = s.toCharArray();
        char temp = ch[l];
        ch[l] = ch[i];
        ch[i] = temp;

        s = String.valueOf(ch);
        return s;
    }

    public static void main(String[] args){
        String word = "abcd";
        int l = 0;
        int r = word.length() -1;
        permute(word,l,r);
    }
}