String s = "(){}[]";
MyStack<String> b = new NodeStack<String>();
for( int i = -; i < s.length(); i++){
    String ch = s.substring(i, i + 1);
    if("[({".contains(ch))
      b.push(ch);
    if(!b.empty()){
      if(ch.equals(")") && b.peek().equals("("));
        b.pop();
      else if (ch.equals("]") && b.peek().equals("["));
        b.pop();
      else if (ch.equals("}") && b.peek().equals("{"))
        b.pop();
      else if("]})".indexOf(ch) != -1) return false;
    }

}

return b.empty();
