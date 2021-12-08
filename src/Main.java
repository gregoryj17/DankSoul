import java.util.ArrayList;
import java.util.Random;

public class Main {


    public static String[] bosses = new String[]{"Asylum", "Taurus", "Bell", "Capra", "Gaping Dragon", "Quelaag", "Butterfly",
    "Sif", "Pinwheel", "Iron Golem", "Priscilla", "Gwyndolin", "4 Kings", "O&S", "Discharge", "Firesage", "Centipede",
    "Bed", "Nito", "Seath", "Stray", "Gwyn", "Guardian", "Artorias", "Manus", "Kalameet"};

    public static ArrayList<Integer> order = new ArrayList<>();
    public static ArrayList<Integer> pool = new ArrayList<>();
    public static boolean dlc = true;
    public static Random r = new Random();

    public static void main(String[] args) {
        order.add(0);
        pool.add(1);
        pool.add(2);
        pool.add(3);
        pool.add(5);
        pool.add(6);
        pool.add(7);
        pool.add(8);
        pool.add(20);
        while(!pool.isEmpty()){
            int next = pickNext();
            add(next);
        }
        order.add(21);

        printOrder();
    }

    public static int pickNext(){
        return pool.remove(r.nextInt(pool.size()));
    }

    public static void add(int bossNum){
        order.add(bossNum);
        if(bossNum==3){
            pool.add(4);
        }
        else if (bossNum==2){
            if(order.contains(5))pool.add(9);
        }
        else if(bossNum==5){
            pool.add(14);
            if(order.contains(2))pool.add(9);
        }
        else if(bossNum==7){
            pool.add(12);
        }
        else if(bossNum==9){
            pool.add(10);
            pool.add(11);
            pool.add(13);
        }
        else if(bossNum==13){
            pool.add(17);
            pool.add(19);
            if(dlc){
                pool.add(22);
            }
            if(order.contains(14)){
                pool.add(15);
            }
            if(order.contains(8)){
                pool.add(18);
            }
        }
        else if(bossNum==14){
            if(order.contains(13)){
                pool.add(15);
            }
        }
        else if(bossNum==8){
            if(order.contains(13)){
                pool.add(18);
            }
        }
        else if(bossNum==15){
            pool.add(16);
        }
        else if(bossNum==22){
            pool.add(23);
        }
        else if(bossNum==23){
            pool.add(24);
            pool.add(25);
        }
    }

    public static void printOrder(){
        for(int i = 0; i < order.size(); i++){
            System.out.println((i+1)+". "+bosses[order.get(i)]);
        }
    }
    /*
        0 first always
        any of 1,2,3,5,6,7,8,20
        after 3 is completed, add 4 to the pool
        after 2 and 5, add 9
        after 5, add 14
        after 7, add 12
        after 9, add 10,11,13
        after 13, add 17,19,22(DLC)
        after 13 and 14, add 15
        after 13 and 8, add 18
        after 15, add 16

        DLC
        after 22, add 23
        after 23, add 24 and 25

        21 last always
     */


}
