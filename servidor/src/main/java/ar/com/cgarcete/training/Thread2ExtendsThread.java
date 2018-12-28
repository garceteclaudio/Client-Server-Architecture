package ar.com.cgarcete.training;

public class Thread2ExtendsThread extends Thread {
	
	private int dormir;
	
    public Thread2ExtendsThread(String name, int dormir) {
        super(name);
        this.dormir = dormir;
    }

    @Override
    public void run() {
        for(int i = 0; i<15 ; i++) {
        	System.out.println("Thread name: ["+this.getName()+"] id: ["+ this.getId()+"]"+" iteracion: ["+i+"]");
        	try {
				sleep(dormir);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }
    }
    
    public static void main(String[] args){
    	Thread2ExtendsThread hilo1 = new Thread2ExtendsThread("ABC",200);
    	Thread2ExtendsThread hilo2 = new Thread2ExtendsThread("xy",400);
    	
    	hilo1.start();
    	hilo2.start();
    }

}
