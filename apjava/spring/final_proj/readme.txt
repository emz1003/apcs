Guitar Hero

    Consists of RingBuffer.java, GuitarString.java, and GuitarHero.java
    RingBuffer is a class that contains frequencies in a vibration of a string. It operates in a manner where the beginning
    of the array considered the next after the last item of the array. It effectively simulates the transfer of energy along a string
    tied down on both ends.

    GuitarString uses RingBuffer and can simulate white noise through random frequencies, as well as after a guitar string is plucked,
    it uses the energy decay factor of 0.994 to simulate the dissipation of energy after being plucked.

    GuitarHero is the driver class and puts it all together so StdAudio, provided in the assignment, can play the notes.

    TO RUN: java GuitarHero
    a java application interface will come up, and by typing corresponding keys on the keyboard, there will be a sound of a guitar string
    being plucked

Randomized Queues and Deques
    Consists of RandomizedQueue.java, Deque.java, Subset.java, and Palindrome.java
    RandomizedQueue operates such that it maintains order of insertions, but when it comes to removing, it selects a random item of the 
    queue to remove.
    Deque is a queue that works both from the front end and the back end, such that one can insert from the front or the end, and same for
    removal of items.
    Subset takes system input of strings and outputs a random subset of the strings.
    Palindrome takes in a sequence of characters through system input, corresponding to DNA sequences. It compares the reversed version of
    the sequence to the sequence of the complement. If they are the same, they are palindromes. If they are different, they are not.

    TO RUN: 
    to test RandomizedQueue: java RandomizedQueue
    to test Deque: java Deque
    to run Subset: java Subset
    * input strings, each item separated by lines. if a new line is entered with no preceding content, the set of strings will be finished
    the program will run off the lines that were already entered
    to run Palindrome: java Palindrome
    * input a sequence of DNA sequence characters. Once a new line is entered, it will process the characters given.