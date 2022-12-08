package lesson36;

import java.io.*;

public class Example1 {
    public static void wrightObject(Object obj, String fileName){
        try(FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos= new ObjectOutputStream(fos))
        {
            oos.writeObject(obj);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static Object readObject( String fileName){
        Object obj = null;
        try(FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis))
        {
            obj = ois.readObject();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return obj;
    }

    public static void writeObjectEx(FishEx obj, String fileName){
        try(FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos))
        {
            obj.writeExternal(oos);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Object readObjectEx( String fileName){
        FishEx obj = new FishEx();
        try(FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis))
        {
            obj.readExternal(ois);


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return obj;
    }



    public static void main(String[] args) {
       /* Fish salmon = new Fish("salmon", 1000, 39.99);
        wrightObject(salmon,"fish.txt");
        Fish newFish = (Fish)readObject("fish.txt");
        System.out.println(newFish);
        */


        FishEx shark = new FishEx("sgark", 500, 89.99);
        writeObjectEx(shark, "fishEx.txt");
        FishEx newFishEx = (FishEx) readObjectEx("fishEx.txt");
        System.out.println(newFishEx);


    }

}
