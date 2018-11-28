// write the method:
/* Assume: 0 <= data.length
 * Post: Returns a random sample of size r, chosen w/ replacement. This method cannot produce a side affect.
*/

private int[] SampleWithReplacement(int[] data, int r){
    int[] randSample = new int[r];
    for(int i = 0; i < randSample.length; i++){
      randIndex = (int) (Math.random() * data.length);
      randSample[i] = data[randIndex];
    }
    return randSample;
}

/* Precondition: 0 <= r <= data.length data != null
 * Postcondition: Returns a random sample, chosen without replacement of size r/ This method produces a side effect of reordering data
*/
private void shuffle(int [] data){
   for(int i = 0; i < data.length; i++){
     int randIndex = (int) (Math.random() * (data.length - 1));
     int mem = data[i];
     data[i] = data[randIndex];
     data[randIndex] = mem;
   }
}

private int[] SampleWithoutReplacement(int[] data, int r){
  int[] sample = new int[r];
  shuffle(data);
  for(int i = 0; i < data.length; i++){
    sample[i] = data[i];
  }
  return sample;
}
