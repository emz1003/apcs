public class RingBuffer {
    private int first;            // index of first item in buffer
    private int last;             // index of last item in buffer
    private int size;             // current number of items of buffer
    private double[] buffer; 

    // create an empty ring buffer, with given max capacity
    public RingBuffer(int capacity) { 
        first = 0;
        last = 0;
        size = 0;
        buffer = new double[capacity];
    }

    // return number of items currently in the buffer
    public int size() {                    
        return size;
    }

    // is the buffer empty (size equals zero)?
    public boolean isEmpty() {
        return size == 0;
    }
    // is the buffer full  (size equals capacity)?
    public boolean isFull() {
        return size == buffer.length;
    }              

    // add item x to the end
    public void enqueue(double x) {
        if (isFull()) throw new RuntimeException("Queue full");
        buffer[last] = x;
        last = (last + 1) % (buffer.length);
        size++;
    }      

    // delete and return item from the front
    public double dequeue() {
        if (isEmpty()) throw new RuntimeException("Queue empty");
        double val = buffer[first];
        buffer[first] = 0.0;
        first = (first + 1) % (buffer.length);
        size--;
        return val;
    }  
    
    // return (but do not delete) item from the front
    public double peek() {
        return buffer[first];
    }       
;
    @Override
    public String toString() {
        String ans = "";
        for( Double d: buffer) {
            System.out.print(d + " ");
        }
        return ans;
    }
    
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        RingBuffer buffer = new RingBuffer(N);
        for (int i = 1; i <= N; i++) {
            buffer.enqueue(i);
        }
        double t = buffer.dequeue();
        buffer.enqueue(t);
        System.out.println("Size after wrap-around is " + buffer.size());
        while (buffer.size() >= 2) {
            double x = buffer.dequeue();
            double y = buffer.dequeue();
            buffer.enqueue(x + y);
        }
        System.out.println(buffer.peek());
    }
}