public class Subset {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        RandomizedQueue<String> rq = new RandomizedQueue<String>();
        while(StdIn.hasNextLine()) {
            String line = StdIn.readLine();
            if(line.equals("")) break;
            rq.add(line);
        }
        for (int i = 0; i < k; i++) {
            System.out.println(rq.remove());
        }

    }
}