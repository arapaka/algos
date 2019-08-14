package topics.twopointers;

import java.util.Arrays;

public class FirstMissingPositiveJava {


    public static int findFirstMissing(int[] ints) {

        for (int i = 0; i < ints.length; i++) {
             int resp = Math.abs(ints[i]);

             if(resp-1 < ints.length && ints[resp -1] < 0) {
                 ints[resp-1] = -ints[resp-1];
             }

        }
        for (int i = 0; i < ints.length; i++) {
            if(ints[i] > 0) {
                return i+1;
            }
        }
        return ints.length + 1;
    }


    public static void main(String[] args) {



    }
}
