public class Permutation {
    
    static void permute(String s, String newString){

        if(s.length() == 0){
            System.out.print(newString + " , ");
            return;
        }

        for(int i = 0 ; i < s.length(); i++){
            char curr = s.charAt(i);
            String rest = s.substring(0,i) + s.substring(i+1);
            permute(rest, newString + curr);
        }
    }

    public static void main(String[] args){
        String a = "ABC";
        permute(a, "");
    }
}
