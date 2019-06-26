import java.util.HashMap;

public class GuitarHero {
    public static void main (String[] args) {
        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        GuitarString[] strings = new GuitarString[keyboard.length()];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = new GuitarString(440 * Math.pow(1.05956, i - 24));
        }

        while (true) {
            double sample = 0;
            if (StdDraw.hasNextKeyTyped()) {
                  char key = StdDraw.nextKeyTyped();
                  if (keyboard.indexOf(key) != -1) {
                      strings[keyboard.indexOf(key)].pluck();
                  }
            }

            for (GuitarString gs : strings) {
                sample += gs.sample();
            }
            StdAudio.play(sample);
            
            for (GuitarString s: strings) {
                s.tic();
            }
        }
    }
}