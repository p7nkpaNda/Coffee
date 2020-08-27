import java.util.HashMap;
import java.util.Map;
public class SyrupAdditive extends Additive {
    Map <String,Integer> map;
    double unitPrice;
    double allprice;

    private Map <String,Double> syrup_price =  new HashMap<String, Double>(){{
        put("Original",1.0);
        put("Vanilla",2.0);
        put("Hazelnut",2.0);
        put("Caramel",2.5);
        put("Raspberry",3.0);
        put("Mocha",2.0);
    }};
    SyrupAdditive(){
        allprice = 0;
        map = new HashMap<>();
    }
    @Override
    public void addMenu(String type, int num){
        map.put(type, num);
    }
    @Override
    void calPrice(){
        for (String type:map.keySet()){
            allprice+=map.get(type)*syrup_price.get(type);
        }

    }
    @Override
    double getPrice(){
        return allprice;
    }

}
