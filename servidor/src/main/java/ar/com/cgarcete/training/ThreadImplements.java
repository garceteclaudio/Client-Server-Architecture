package ar.com.cgarcete.training;

public class ThreadImplements implements Runnable{

	public void run() {
	
        for(int i = 0; i<7 ; i++) {
        	System.out.println("holus from ThreadImplements");
        	try {
				Thread.sleep(1500);
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
	}
	
	
	public static void main(String[] args){
		new ThreadImplements().run();
		new ThreadImplements2().run();
	}
}

 class ThreadImplements2 implements Runnable{

	public void run() {
	
        for(int i = 0; i<11 ; i++) {
        	System.out.println("holus from ThreadImplements2");
        	try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
	}
	
	

}