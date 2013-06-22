/**
 * Created with IntelliJ IDEA.
 * User: Prashant
 * Date: 5/22/13
 * Time: 9:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class DedupString {
    //private static final String str = "aAbcdefghaezZ";
    //private static final String str = "a";
    private static final String str = "aAbBcCdD";

    public static void main(String[] args) {
        long dedup = 0L;
        //System.out.println(Long.toBinaryString(dedup));
        for(int i=0; i<str.length();i++) {
           // int ascii = Character.getNumericValue(str.charAt(i));
            int ascii = str.charAt(i) - 'A';
            if( (dedup & ((long)1<<ascii)) > 0 ) {
                System.out.println("Duplicate!");
                break;
            }
            dedup = dedup | ((long)1 << ascii);
            System.out.println((ascii));
            System.out.println(Long.toBinaryString((long)dedup));
        }
    }

}

/**
   bitmap in java ?
   create a 26 bits bitmap (assuming lower case only)
   take each char,
    if bit is already one (check by xor) - return false
    if not, set bit to 1 (bit = ascii of char - 97) set to 1 = xor with 1
**/