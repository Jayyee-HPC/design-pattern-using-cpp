package creational_patterns.Singleton.Hunger;

/**        
 * Title: Hunger singleton   
 * Description: Initialization is done when the class is loaded, which avoid the synchronization problem of multithreading.
 *      Class loading is slow, but getting instance is fast. 
 * Multi-thread: Hunger singleton is thread safe.
 * @author Kappo       
 * @created 05/25/22  
 */   

public class Hunger {

	private static Hunger instance = new Hunger();
    //private final static Hunger instance = new Hunger();
	
	private Hunger(){		

	}	

	public static Hunger getInstance(){
		return instance;
	}    

    public static void main(String[] args) {
        // Prints "Hello, World" to the terminal window.
        Hunger instance1 = Hunger.getInstance();
        Hunger instance2 = Hunger.getInstance();

        //check if instance1 == instance2
		System.out.println(instance1 == instance2);
    }

}