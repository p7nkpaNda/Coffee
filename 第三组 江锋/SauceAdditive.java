import java.util.HashMap;
import java.util.Map;

public class SauceAdditive extends Additive{
    Map<String,Integer> map;
    double unitPrice;
    double allprice;
    private Map <String,Double> sauce_price =  new HashMap<String, Double>(){{
        put("Mocha",1.0);
        put("Caramel",1.5);
    }};
    SauceAdditive(){
        allprice=0;
        map = new HashMap<>();
    }
    @Override
    void addMenu(String type,int num){
        map.put(type,num);

    }
    @Override
    void calPrice(){
        for(String type:map.keySet()){
            if(map.get(type)==1){
                allprice+=sauce_price.get(type);
            }
        }
    }
    @Override
    double getPrice(){
        return allprice;
    }
}
