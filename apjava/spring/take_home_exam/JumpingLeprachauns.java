import java.util.HashMap;
import java.util.TreeMap;
import java.util.Iterator;
public class JumpingLeprechauns {
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
            Iterator itr = x_is.keySet().iterator();
            Double prevKey = null;
            while(itr.hasNext()) {
                // set next location
                Double nextKey = itr.next();
                Integer current = x_is.remove(nextKey);
                Double newLocation = sign * Math.random() * g_is.get(nextKey);
                x_is.put(newLocation, current);
                // steal from other leprechauns
                g_is.replace(current - 1, 0.5 * g_is.get(current - 1));
                g_is.replace(current + 1, 0.5 * g_is.get(current + 1));
                g_is.replace(current, g_is.get(x_is.get(x_is.higherKey(newLocation))) + g_is.get(x_is.get(x_is.lowerKey(newLocation))));
            }
        }
        
        // output results:
        for (Double key: x_is.keySet()){
            int leprechaun = x_is.get(key);
            System.out.println("Leprechaun " + leprechaun + " at " + key + " has " + g_is.get(leprechaun) + " gold.");
        }
    }
}