class Resource{
    private int number=0;
    private int size=10;

    public synchronized void increase(){
        while(number>=size){
            try{
                wait();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        number++;
        System.out.println("生产了一个，共有"+number);
        notifyAll();
    }

    public synchronized void decrease(){
        while (number<=0){
            try{
                wait();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        number--;
        System.out.println("消耗了一个，共有"+number);
        notifyAll();
    }

}

class Producer implements Runnable{
    private Resource resource;
    public Producer(Resource resource){
        this.resource=resource;
    }
    @Override
    public void run(){
        while (true){
            resource.increase();
        }
    }

}

class Consumer implements Runnable{
    private Resource resource;
    public Consumer(Resource resource){
        this.resource=resource;
    }

    public void run(){
        while(true){
            resource.decrease();
        }
    }
}
public class TestThread{
    public static void main(String[] args){
        Resource resource=new Resource();
        new Thread(new Producer(resource)).start();
        //new Thread(new Producer(resource)).start();
        //new Thread(new Producer(resource)).start();
        new Thread(new Consumer(resource)).start();
    }
}
