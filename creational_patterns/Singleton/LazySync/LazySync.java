package creational_patterns.Singleton.LazySync;

/**        
 * Title: Lazy singleton   
 * Description: Initialization is done when the getInstance method is first accessed, which avoid slow program loading.
 *      The multithreading security if a fatal problem if two threads access the instance at same time.
 *      Class loading is slow, but getting instance is fast. 
 * Multi-thread: Hunger singleton is thread safe.
 * @author Kappo       
 * @created 05/25/22  
 */   

public class LazySync {

	private static LazySync instance = null;
    //private final static Hunger instance = new Hunger();
	
	private LazySync(){		

	}	

	public static synchronized LazySync getInstance(){
        if (instance == null)
        {
            instance = new LazySync();
        }
		return instance;
	}    

    public static void main(String[] args) {
        // Prints "Hello, World" to the terminal window.
        LazySync instance1 = LazySync.getInstance();
        LazySync instance2 = LazySync.getInstance();

        //check if instance1 == instance2
		System.out.println(instance1 == instance2);
    }

}