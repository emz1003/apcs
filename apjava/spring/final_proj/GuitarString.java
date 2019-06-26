public class GuitarString {

    RingBuffer string;
    int numTicks;

    // create a guitar string of the given frequency, using a sampling rate of 44,100
    public GuitarString(double frequency) {
        int N = (int) Math.round(44100 / frequency);
        string = new RingBuffer(N);
        while (!string.isFull()) {
            string.enqueue(0.0);
        }
    }

    // create a guitar string whose size and initial values are given by the array
    public GuitarString(double[] init) {
        string = new RingBuffer(init.length);
        for (double val: init) {
            string.enqueue(val);
        }

    }  

    // set the buffer to white noise
    public void pluck() {
        for (int i = 0; i < string.size(); i++) {
            string.dequeue();
            string.enqueue(-1.0 + Math.random());
        }

    }

    // advance the simulation one time step
    public void tic() {
        numTicks++;
        string.enqueue((string.dequeue() + string.peek()) / 2.0 * .994);
    }

    // return the current sample
    public double sample() {
        return string.peek();
    }

    // return number of tics
    public int time() {
        return numTicks;
    }                      
}