import java.util.HashMap;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.Set;

public class JumpingLeprechauns0 {
    public static void main(String[] args){
        int numberOfLeprechauns = Integer.parseInt(args[0]);
        int numberOfIterations = Integer.parseInt(args[1]);

        HashMap<Integer, Double> g_is = new HashMap<Integer, Double>();
        TreeMap<Double, Integer> x_is = new TreeMap<Double, Integer>();
        // populates the maps
        for (int i = 1; i <= numberOfLeprechauns; i++) {
            g_is.put(i, 1000000.0);
            int sign = Math.random() < .5 ? -1 : 1;
            x_is.put(sign * Math.random() * g_is.get(i), i);
        }
        // go through a number of iterations, args[1]
        for (int i = 0; i < numberOfIterations; i++) {
            // for each location of the leprechaun

            Double nextKey = x_is.firstKey();
            while (nextKey != null) {
                // set next location
                Integer current = x_is.remove(nextKey);
                int sign = Math.random() < .5 ? -1 : 1;
                Double newLocation = sign * Math.random() * g_is.get(current);
                x_is.put(newLocation, current);
                // steal from other leprechauns
                Double left = 0.0;
                Double right = 0.0;
                if (current != 1){
                    g_is.replace(current - 1, 0.5 * g_is.get(current - 1));
                    if(x_is.higherKey(newLocation) != null) left = g_is.get(x_is.get(x_is.higherKey(newLocation)));
                }
                if (current != numberOfLeprechauns){
                    g_is.replace(current + 1, 0.5 * g_is.get(current + 1));
                    if(x_is.lowerKey(newLocation) != null) right = g_is.get(x_is.get(x_is.lowerKey(newLocation)));
                }
                g_is.replace(current, g_is.get(current) + left + right);
                nextKey = x_is.higherKey(nextKey);
            }
        }
        
        // output results:
        for (Double key: x_is.keySet()){
            int leprechaun = x_is.get(key);
            System.out.println("Leprechaun " + leprechaun + " at " + key + " has " + g_is.get(leprechaun) + " gold.");
        }
    }
}