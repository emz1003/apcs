public class Palindrome {
    public static void main(String[] args) {
        Deque<Character> d = new Deque<Character>();
        Deque<Character> complement = new Deque<Character>();
        while(StdIn.hasNextChar()) {
            Character ch = StdIn.readChar();
            if(Character.isWhitespace(ch)) break;
            d.addFirst(ch);
            if(ch.equals('A'))
                complement.addLast('T');
            else if(ch.equals('T'))
                complement.addLast('A');
            else if (ch.equals('C'))
                complement.addLast('G');
            else if(ch.equals('G'))
                complement.addLast('C');
        }

        System.out.println("sequence is a palindrome: " + d.toString().equals(complement.toString()));

    }
}