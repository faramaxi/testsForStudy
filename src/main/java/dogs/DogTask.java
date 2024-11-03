package dogs;
/* Реализовать семейство псов, где будет 3 типа собаки
Изначально в семействе будет 30 собак
Нужно сделать так, что бы в течении 1 года, выбиралась случайная собака и выполяняла случайное действие.
Каждый 30 день, в семействе должна пополнятся 1 собака
Нужно вывести на экран сколько псов было до и сколько стало после
Использовать класс Random, Switch Case, If Else*/
import java.util.*;

public class DogTask {

    private static  Random random= new Random();

    public static void main(String[] args) {
        List<Dog> dogs =new ArrayList<>();
        for (int i = 0; i <30; i++) {
            dogs.add(getRandomDog());
        }
        for (int i = 0; i <365; i++) {
            int randomIndex= random.nextInt(dogs.size());
            Dog tempDog = dogs.get(randomIndex);
            tempDog.randomAction();
            if (i% 30 ==0){
                dogs.add(getRandomDog());
                System.out.println("Новая собака");
            }
        }
        System.out.println(dogs.size());

        Map<String, Integer> animals =new HashMap<>();
        for (Dog dog: dogs){
            String className=dog.getClass().getSimpleName();
            if (animals.containsKey(className)){
                int countName= animals.get(className);
                animals.put(className,countName+1);
            } else {
                animals.put(className, 1);
            }
        }
        for (String className: animals.keySet()){
            int count=animals.get(className);
            System.out.println(className+": "+count);
        }
    }

    public static Dog getRandomDog(){
        Random random= new Random();
        Dog tempDog=null;
        int randomNumber =random.nextInt(3);
        switch (randomNumber){
            case 0:
                tempDog= new Kayot();
                break;
            case 1:
                tempDog= new Shakal();
                break;
            case 2:
                tempDog= new Wolf();
                break;
        }
    return tempDog;
    }
}
