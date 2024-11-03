package dogs;

import java.util.Random;

public class Shakal extends Dog {
    @Override
    void search() {
        System.out.println("Шакал идет днем");
    }
    public void randomAction(){
        Random random= new Random();
        int randomNumber= random.nextInt(3);
        switch (randomNumber){
            case 0 :
                search();
                break;
            case 1:
                hunt();
                break;
            case 2:
                gavgav();
                break;
        }
    }
    public void hunt(){
        System.out.println("Шакал охотится");
    }
    public void gavgav(){
        System.out.println("Шакал гавкает");
    }

}
