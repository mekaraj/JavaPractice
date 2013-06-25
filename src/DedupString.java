import java.util.BitSet;

/**
 * Created with IntelliJ IDEA.
 * User: Prashant
 * Date: 5/22/13
 * Time: 9:21 PM
 * 1000 iterations
 * Native in ns: 2820849
 * BitSet in ns: 10003639
 */
public class DedupString {
    //private static final String str = "aAbcdefghaezZ";
    //private static final String str = "a";
    private static final String str = "aAbBcCdD";

    public static void main(String[] args) {
        long nativeBefore = System.nanoTime();
        for(int i=0; i<1000; i++) {
            dedupNative();
        }
        long nativeAfter = System.nanoTime();
        for(int i=0; i<1000; i++) {
            dedupBitSet();
        }
        long bitsetAfter = System.nanoTime();

        System.out.println("Native in ns: "+(nativeAfter-nativeBefore));
        System.out.println("BitSet in ns: "+(bitsetAfter-nativeAfter));
    }

    private static boolean dedupBitSet() {
        BitSet dedup = new BitSet(54);
        for(int i=0; i<str.length();i++) {
            int ascii = str.charAt(i) - 'A';
            if( dedup.get(ascii) ) {
                //System.out.println("Duplicate!");
                return true;
            }
            dedup.set(ascii);
            //System.out.println((ascii));
            //System.out.println(dedup.toString());
        }
        return false;
    }
    private static boolean dedupNative() {
        long dedup = 0L;
        //System.out.println(Long.toBinaryString(dedup));
        for(int i=0; i<str.length();i++) {
            // int ascii = Character.getNumericValue(str.charAt(i));    // returns 10-35 for both a-z and A-Z
            int ascii = str.charAt(i) - 'A';
            if( (dedup & ((long)1<<ascii)) > 0 ) {
                //System.out.println("Duplicate!");
                return true;
            }
            dedup = dedup | ((long)1 << ascii);
            //System.out.println((ascii));
            //System.out.println(Long.toBinaryString((long)dedup));
        }
        return false;
    }
}

/**
   bitmap in java ?
   create a 26 bits bitmap (assuming lower case only)
   take each char,
    if bit is already one (check by xor) - return false
    if not, set bit to 1 (bit = ascii of char - 97) set to 1 = xor with 1
**/