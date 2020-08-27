import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Order {
    static Map<String,Double> cup_price =  new HashMap<String, Double>(){{
        put("Small",13.0);
        put("Medium",15.0);
        put("Big",18.0);
    }};
    static Map <String,Double> syrup_price =  new HashMap<String, Double>(){{
        put("Original",1.0);
        put("Vanilla",2.0);
        put("Hazelnut",2.0);
        put("Caramel",2.5);
        put("Raspberry",3.0);
        put("Mocha",2.0);
    }};
    static Map <String,Double> sauce_price =  new HashMap<String, Double>(){{
        put("Mocha",1.0);
        put("Caramel",1.5);
    }};
    public static void main(String[] args) throws IOException {
        System.out.println("我们的饮料基础价格如下：");
        System.out.println("小杯是"+cup_price.get("Small")+"元   "
                            + "中杯是"+cup_price.get("Medium")+"元   "
                            + "大杯是"+cup_price.get("Big")+"元");
        System.out.println("可以免费选择温度和牛奶哦！！！");
        System.out.println("另外，饮料还可以搭配不同的糖浆和淋酱");
        System.out.println("糖浆有以下几种：");
        System.out.println("原味糖浆单价 "+ syrup_price.get("Original")+ " 元");
        System.out.println("香草糖浆单价 "+ syrup_price.get("Vanilla")+ " 元");
        System.out.println("榛果糖浆单价 "+ syrup_price.get("Hazelnut")+ " 元");
        System.out.println("焦糖糖浆单价 "+ syrup_price.get("Caramel")+ " 元");
        System.out.println("覆盆子糖浆单价 "+ syrup_price.get("Raspberry")+ " 元");
        System.out.println("摩卡酱单价 "+ syrup_price.get("Mocha")+ " 元");
        System.out.println("淋酱有以下几种：");
        System.out.println("摩卡淋酱单价 "+ sauce_price.get("Mocha")+ " 元");
        System.out.println("焦糖风味酱单价 "+ sauce_price.get("Caramel")+ " 元");
        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        Cup cup = Cup.Big;
        while (!flag){

            System.out.println("您好，请问您想要怎样的饮料？ [1-小杯，2-中杯，3-大杯]");
            int cupInt = sc.nextInt();
            switch (cupInt){
                case 1:
                    cup = Cup.Small;
                    flag = true;
                    break;
                case 2:
                    cup = Cup.Medium;
                    flag = true;
                    break;
                case 3:
                    cup = Cup.Big;
                    flag = true;
                    break;
                default:
                    System.out.println("请选择正确的杯型！");
            }
        }
        flag = false;
        Temperture temperture = Temperture.Ice;
        while (!flag){

            System.out.println("您好，请问您想要什么温度？ [1-非常热，2-热，3-常温，4-冰，5-少冰，6-去冰]");
            int tempertureInt = sc.nextInt();
            switch (tempertureInt){
                case 1:
                    temperture = Temperture.VeryHot;
                    flag = true;
                    break;
                case 2:
                    temperture = Temperture.Hot;
                    flag = true;
                    break;
                case 3:
                    temperture = Temperture.Homoeothermy;
                    flag = true;
                    break;
                case 4:
                    temperture = Temperture.Ice;
                    flag = true;
                    break;
                case 5:
                    temperture = Temperture.LessIce;
                    flag = true;
                    break;
                case 6:
                    temperture = Temperture.NoIce;
                    flag = true;
                    break;
                default:
                    System.out.println("请选择合适的温度！");
            }
        }
        flag = false;
        Milk milk = Milk.OatMilk;
        while (!flag){
            System.out.println("您好，请问您想要怎样的牛奶？ [1-全脂牛奶，2-燕麦奶，3-脱脂牛奶，4-豆奶]");
            int milkInt = sc.nextInt();
            switch (milkInt){
                case 1:
                    milk = Milk.WholeMilk;
                    flag = true;
                    break;
                case 2:
                    milk = Milk.SkimmedMilk;
                    flag = true;
                    break;
                case 3:
                    milk = Milk.OatMilk;
                    flag = true;
                    break;
                case 4:
                    milk = Milk.SoyMilk;
                    flag = true;
                    break;
                default:
                    System.out.println("请选择合适的牛奶！");
            }
        }
        Coffee coffee = new Coffee(cup.toString(),temperture,milk);
        Additive syrupAdditive = new SyrupAdditive();
        flag = false;
        Syrup syrup = Syrup.Caramel;
        int count = 0;
        while (!flag){
            System.out.println("请问您需要糖浆吗？ [0-不需要，1-原味糖浆，2-香草糖浆，3-榛果糖浆，4-焦糖糖浆，5-覆盆子糖，6-摩卡酱]");
            int syrupInt = sc.nextInt();
            System.out.println("请问您需要几份这个糖浆？");
            count= sc.nextInt();
            switch (syrupInt){
                case 0:
                    flag = true;
                    break;
                case 1:
                    syrup = Syrup.Original;
                    flag = true;
                    break;
                case 2:
                    syrup = Syrup.Vanilla;
                    flag = true;

                    break;
                case 3:
                    syrup = Syrup.Hazelnut;
                    flag = true;
                    break;
                case 4:
                    syrup = Syrup.Caramel;
                    flag = true;
                    break;
                case 5:
                    syrup = Syrup.Raspberry;
                    flag = true;
                    break;
                case 6:
                    syrup = Syrup.Mocha;
                    flag = true;
                    break;
                default:
                    System.out.println("请选择本店有的糖浆！");
            }
        }
        if(count>0) {
            syrupAdditive.addMenu(syrup.toString(), count);
        }

        Additive sauceAdditive = new SauceAdditive();
        flag = false;
        Sauce sauce = Sauce.Caramel;
        int needsauce = 1;
        while (!flag){
            System.out.println("您好，请问您需要淋酱吗？ [0-不需要，1-摩卡淋酱，2-焦糖风味酱]");
            int sauceInt = sc.nextInt();
            switch (sauceInt){
                case 0:
                    needsauce = 0;
                    flag = true;
                    break;
                case 1:
                    sauce = Sauce.Mocha;
                    flag = true;
                    break;
                case 2:
                    sauce = Sauce.Caramel;
                    flag = true;
                    break;
                default:
                    System.out.println("请选择本店有的淋酱！");
            }
        }

        if(needsauce==1) {
            sauceAdditive.addMenu(sauce.toString(), 1);
        }

        coffee.additives.add(syrupAdditive);
        coffee.additives.add(sauceAdditive);
        double a = coffee.getAllPrice();
        System.out.println("本次您的咖啡价格是 " + a +" 元，欢迎下次光临！");










    }







}
