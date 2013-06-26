import java.util.BitSet;

/**
 * Created with IntelliJ IDEA.
 * User: Prashant
 * Date: 6/25/13
 * Time: 10:42 PM
 */
public class StringProblems {

    /*
     * 1000 iterations
     * Native in ns: 2820849
     * BitSet in ns: 10003639
     */
    //private static final String dedupstr = "aAbcdefghaezZ";
    //private static final String dedupstr = "a";
    private static final String dedupstr = "aAbBcCdD";
    private static String permuteStr1 = "abacd c";
    private static String permuteStr2 = "a accdb";
    private static String compressStr = "aabbbcdeffffgg";
    public static void main(String[] args) {
        compressString();
        //replaceWithPercent20(permuteStr1);
        //checkPermute(permuteStr1, permuteStr2);
        //runDedup();

    }

    private static void compressString() {
        StringBuffer compressed = new StringBuffer();
        for (int i = 0; i < compressStr.length(); i++) {
            char current  = compressStr.charAt(i);
            compressed.append(current);
            i++;
            int count = 1;
            while(i < compressStr.length() && compressStr.charAt(i) == current) {
                count++;
                i++;
            }
            compressed.append(count);
            i--;
        }
        System.out.println(compressed);
    }

    private static void replaceWithPercent20(String permuteStr1) {
        System.out.println(permuteStr1.replaceAll(" ", "%20"));
        char[] arr = permuteStr1.toCharArray();
        for( char c: arr) {

        }
    }

    private static void checkPermute(String permuteStr1, String permuteStr2) {
        int tot1 = 0;
        int tot2 = 0;
        if(permuteStr1.length() != permuteStr2.length()) {
            System.out.println("Not a permute");
            return;
        }
        for(int i=0;i<permuteStr1.length();i++) {
            tot1 += (int) permuteStr1.charAt(i);    // Cast to int not needed, but is more explicit
        }
        for(int i=0;i<permuteStr2.length();i++) {
            //tot2 += permuteStr2.charAt(i);
            tot2 += Character.codePointAt(permuteStr2, i);    // Better way to convert because this handles surrogate
                                                              // pairs if the string has chars outside of BMP(UTF-16)
        }
        if(tot1 != tot2) {
            System.out.println("Not a permute "+tot1+" "+tot2);
        }
        else {
            System.out.println("Permute !");
        }
    }

    private static void runDedup() {
        long nativeBefore = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            dedupNative();
        }
        long nativeAfter = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            dedupBitSet();
        }
        long bitsetAfter = System.nanoTime();

        System.out.println("Native in ns: " + (nativeAfter - nativeBefore));
        System.out.println("BitSet in ns: " + (bitsetAfter - nativeAfter));
    }

    private static boolean dedupBitSet() {
        BitSet dedup = new BitSet(54);
        for (int i = 0; i < dedupstr.length(); i++) {
            int ascii = dedupstr.charAt(i) - 'A';
            if (dedup.get(ascii)) {
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
        for (int i = 0; i < dedupstr.length(); i++) {
            // int ascii = Character.getNumericValue(dedupstr.charAt(i));    // returns 10-35 for both a-z and A-Z
            int ascii = dedupstr.charAt(i) - 'A';
            if ((dedup & ((long) 1 << ascii)) > 0) {
                //System.out.println("Duplicate!");
                return true;
            }
            dedup = dedup | ((long) 1 << ascii);
            //System.out.println((ascii));
            //System.out.println(Long.toBinaryString((long)dedup));
        }
        return false;
    }
}


