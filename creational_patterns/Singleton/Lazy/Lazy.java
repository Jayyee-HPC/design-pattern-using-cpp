package creational_patterns.Singleton.Lazy;

/**        
 * Title: Lazy singleton   
 * Description: Initialization is done when the getInstance method is first accessed, which avoid slow program loading.
 *      The multithreading security if a fatal problem if two threads access the instance at same time.
 *      Class loading is slow, but getting instance is fast. 
 * Multi-thread: Hunger singleton is thread safe.
 * @author Kappo       
 * @created 05/25/22  
 */   

public class Lazy {

	private static Lazy instance = null;
    //private final static Hunger instance = new Hunger();
	
	private Lazy(){		

	}	

	public static Lazy getInstance(){
        if (instance == null)
        {
            instance = new Lazy();
        }
		return instance;
	}    

    public static void main(String[] args) {
        // Prints "Hello, World" to the terminal window.
        Lazy instance1 = Lazy.getInstance();
        Lazy instance2 = Lazy.getInstance();

        //check if instance1 == instance2
		System.out.println(instance1 == instance2);
    }

}