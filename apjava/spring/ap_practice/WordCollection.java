import java.util.ArrayList;

public class WordCollection{

    private ArrayList<String> collection;

    // constructor
    // postcondition: creates an empty WordCollection
    public WordCollection(){
      collection = new ArrayList<String>();
    }

    //postcondition: Copys from the String[] to the WordCollection
    public WordCollection(String [] words){
      collection = new ArrayList<String>();
      for(String s : words) {
        collection.add(s);
      }
    }

    // returns the total number of items stored in the collection
    public int size() {
      return collection.size();
    }

    // returns kth word in alphabetical order, where
    // 0 ≤ k < size()
    public String findKth(int k) {
      return collection.get(k);
    }

    // adds word to the collection (duplicates allowed) by maintaining
    // a sorted(ascending) list of words.
    // O(N ^ 2)
    public void insert(String word){
      for (int i = 0; i < collection.size(); i++) {
        if(collection.get(i).compareTo(word) == 1) {
          collection.add(i, word);
        }
      }
    }

    // returns the index of the first occurrence of word in the collection
    // returns -1 if not found.
    // O(N)
    public int indexOf(String word){
      for(int i = 0; i < collection.size(); i++) {
        if (collection.get(i).equals(word)) return i;
      }
      return -1;
    }

    // removes one instance of word from the collection if word is
    // present; otherwise, does nothing
    // O(N)
    public void remove(String word){
      if (indexOf(word) != -1) collection.remove(indexOf(word));
    }

    public String toString(){
	     return collection.toString();
    }

    public static int occurrences(WordCollection C, String  word) {
    // postcondition: returns the number of occurrences of word in C
      int count = 0;
      for (int i = 0; i < C.size(); i++) {
        if (C.findKth(i).equals(word))
          count++;
      }
      return count;
    }

    public static void removeDuplicates(WordCollection C, String word) {
      // postcondition: if word is present in C, all but one occurrence
      //is removed; otherwise, C is unchanged
      for (int i = 0; i <= occurrences(C, word); i++) {
        C.remove(word);
      }
    }

    // precondition: C is not empty
    // postcondition: returns the word that appears most often in C;
    //if there is more than one such word, returns any one of those words
    public static String mostCommon( WordCollection  C) {
      String most = null;
      int occurrences = 0;
      for(int i = 0; i < C.size(); i++) {
        if(occurrences(C, C.findKth(i)) > occurrences) {
          occurrences = occurrences(C, C.findKth(i));
          most = C.findKth(i);
        }
      }
      return most;
    }

    public static void main (String[] args) {
      WordCollection wc = new WordCollection();
      String[] arr = {"cde", "f", "ab"};
      wc = new WordCollection(arr);
      System.out.println(wc);
      System.out.println(wc.size());
      System.out.println("kth: " + wc.findKth(2));
      wc.insert("gh");
      System.out.println("after add \"gh\": " + wc);
      System.out.println("index of f: " + wc.indexOf("f"));
      wc.remove("cde");
      System.out.println("afer removing \"cde\": " + wc);

      String[] arr1 = {"a", "a", "b", "c", "c", "c", "c", "d", "d"};
      wc = new WordCollection(arr1);
      System.out.println(wc);
      System.out.println("most common: " + mostCommon(wc));
      System.out.println(occurrences(wc, "c"));
      removeDuplicates(wc, "c");
      System.out.println(wc);
    }
}
