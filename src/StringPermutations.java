import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Prashant
 * Date: 5/16/13
 * Time: 10:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class StringPermutations {
    static final String in = "abcdefgh";

    public static void main(String[] args) {
        System.out.println(permute(in).toString());
    }

    private static ArrayList<String> permute(String in) {
        if(in.length() == 1) {
            ArrayList<String> ret = new ArrayList<String>();
            ret.add(in);
            return ret;
        }
        char start = in.charAt(0);

        return apply(in, start);
    }

    private static ArrayList<String> apply(String in, char start) {
        ArrayList<String> permuted = new ArrayList<String>();
        for(String p: permute(in.substring(1, in.length()))) {
            for(int i=0;i<=p.length();i++) {
                permuted.add(p.substring(0,i)+start+p.substring(i,p.length()));
            }
        }
        return permuted;
    }

}

/*
algo:

abc -> abc,bac,bca, acb,cab,cba
bc -> bc, cb
c -> c
permutations of ab are perms of a with b in each possible position
permutation of abc are perms of ab with c in each possible position


*/
