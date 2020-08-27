import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Coffee {
    Object cup;
    Object temperture;
    Object milk;
    List<Additive> additives;
    double allprice = 0;
    public Coffee(Object cup,Object temperture,Object milk){
        this.cup = cup;
        this.temperture = temperture;
        this.milk = milk;
        this.additives = new LinkedList<>();
    }
    private Map<Object,Double> cup_price =  new HashMap<Object, Double>(){{
        put("Small",13.0);
        put("Medium",15.0);
        put("Big",18.0);
    }};
    double getAllPrice(){
        allprice+=cup_price.get(cup);
        if(!additives.isEmpty()){
            for (Additive a:additives){
                a.calPrice();
                allprice+=a.getPrice();
            }
        }

      return allprice;

    }

}
