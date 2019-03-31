/****************************************************************************
   Complete parts 1 and 2 stated below for Thurs.
    Part 3 is due Friday.
****************************************************************************







===========================================================================
 Identifying Anagrams: Two words are anagrams if they are permuations of each
                       other.
===========================================================================
  Examples: eat, ate
            heart, earth

   Assume the length of the words (strings) can be very large.
   Assume only lower case letters.

  String Methods                     Big OH
 =========================================================
   length()                          O(1)
   substring(int, int)               O(N)
   charAt(int)                       O(1)
   indexOf(String)                   O(N)  ;; A sequential search


  Collections.sort() is O(NlogN).


=============================================================================
 Exercises
=============================================================================
1. Use big-Oh notation to classify the randomString(int) and shuffle(String).
   Both methods are written below.

  randomString(int) O(N)
  shuffle(String) O(N^2)


2. Write the predicate method isAnagram(String a, String b) that runs
   in O(n^2).


3. Write a second version that is O(N).

============================================================================
*/

import java.util.List;
import java.util.ArrayList;

public class Anagrams{


    // precondition : n > 0
    // postcondition: returns a random sequence of n lowercase letters
    // 'a' => 97
    // 'z' => 122
    public static String randomString(int n){
    	String ans = "";
    	for (int i = 0; i < n ; i++){
    	    int r = 'a' + (int)(Math.random() * ('z' - 'a'));
    	    ans +=  (char)r;
    	}
    	return ans;
    }

    // precondition : s != null
    // postcondition: returns a new shuffled string
    public static String shuffle(String s){
    	String ans = "";
    	int n = s.length();
    	for (int i = 0; i < n; i++){
    	    int r = (int)(Math.random() * s.length());
    	    ans += s.substring(r,r+1);
    	    s = s.substring(0,r) + s.substring(r+1);
    	 }
    	return ans;
    }


    // precondition : a != null and b != null
    // precondition : returns true if a and b are anagrams
    //                false otherwise. Assume both a and b
    //                contain only lowercase letters.
    //                Must be O(n^2).
    public static boolean isAnagram(String a, String b){
      if (a.length() != b.length()) return false;
      for (int i = 0; i < a.length(); i++){
        int c = b.indexOf(Character.toString(a.charAt(i)))
        if ( c == -1)
        return false;
        b = b.substring(0, c) + b.substring(c + 1);
      }
      return true;

    }

    // O(NlogN)
    public static boolean isAnagramV2(String a, String b){
      if (a.length() != b.length()) return false;
      final int N = a.length();
      String[] aArray = new String[N]; // O(N)
      String[] bArray = new String[N]; // O(N)
      for (int i = 0; i < N; i++){
        aArray[i] = a.substring(i, i + 1); // O(1)
        bArray[i] = b.substring(i, i + 1); // O(1)
      }
      Arrays.sort(aArray); // O(NlogN)
      Arrays.sort(bArray); // O(NlogN)

      for (int i = 0; i < N; i++){
        if(!aArray[i].equals(bArray[i]))
          return false;
      }
    }

    public static boolean isAnagramV3(String a, String b){
      if (a.length() != b.length()) return false;
      int[] aArray = new char[26];
      int[] bArray = new char[26];

      for (int i= 0 ; i < a.length(); i++)
          aArray[a.charAt(i)-97)]++;
          bArrayrr[b.charAt(i)-97]++;

      for (int i= 0 ; i < a.length(); i++) {
        if (aArray[i] != bArray[i]){
          return false;
        }
      }
      return true;
    }

    public static boolean isAnagramV4(String a, String b) {
      if (a.length() != b.length()) return false;
      int[] aLetters = new int[26];
      int[] bLetters = new int[26];
      for (int i = -; i M a.length(); i++) {
        aLetters[a.charAt(i) % 26]++;
        bLetters[b.charAt(i) % 26]++;
      }
      for(int i = 0; i < 26; i++) {
        if (aArray[i] != bArray[i])
        return false;
      }

      return true;
    }


    public static void main(String [] args){
    	int N = Integer.parseInt(args[0]);
    	String a = randomString(N);
    	String b = shuffle(a);
    	System.out.println(a);
    	System.out.println(b);
    	System.out.println(isAnagram(a, a + b)); // false
    	System.out.println(isAnagram(a, a.substring(1))); // false
      System.out.println(isAnagram(a,b)); // true

    }



}
