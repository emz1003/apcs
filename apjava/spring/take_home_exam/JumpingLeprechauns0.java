import java.util.HashMap;
import java.util.TreeMap;
import java.util.Iterator;

public class JumpingLeprechauns0 {

    public Double findLocation (Integer leprechaun, TreeMap<Double, Integer> map) {
        for (Double key: map.keySet()) {
            if (map.get(key) == leprechaun) return key;
        }
        return null;
    }
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
            int l = 1;
            Double nextKey = new JumpingLeprechauns0().findLocation(l, x_is); // make sure this leprechaun has the i of 1
            while (nextKey != null) {
                //System.out.println("leprechaun " + l);
                // set next location
                
                Integer current = x_is.remove(nextKey);
                int sign = Math.random() < .5 ? -1 : 1;
                Double newLocation = sign * Math.random() * g_is.get(current) + nextKey;
                x_is.put(newLocation, current);
                //System.out.println("new location: " + newLocation);
                // steal from other leprechauns
                Double left = 0.0;
                Double right = 0.0;
                if (newLocation != x_is.firstKey()){
                    Integer leftL = x_is.get(x_is.lowerKey(newLocation));
                    g_is.replace(leftL, 0.5 * g_is.get(leftL));
                    left = g_is.get(leftL);
                }
                if (newLocation != x_is.lastKey()){
                    Integer rightL = x_is.get(x_is.higherKey(newLocation));
                    g_is.replace(rightL, 0.5 * g_is.get(rightL));
                    right = g_is.get(rightL);
                }
                //System.out.println("the leprechaun on my left has : " + left);
                //System.out.println("the leprechaun on my right has : " + right);
                g_is.replace(current, g_is.get(current) + left + right);
                //System.out.println("I have: " + (g_is.get(current) + left + right));
                nextKey = new JumpingLeprechauns0().findLocation(++l, x_is);
            }
        }
        
        // output results:
        //double sum = 0;
        for (Double key: x_is.keySet()){
            int leprechaun = x_is.get(key);
            //sum += g_is.get(leprechaun);
            System.out.println("Leprechaun " + leprechaun + " at " + key + " has " + g_is.get(leprechaun) + " gold.");
        }
        //System.out.println("sum: " + sum);
        //System.out.println("should add up to: " + (numberOfLeprechauns * 1000000));
    }
}