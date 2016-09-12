package engine;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import compute.Compute;
import compute.Task;


//This class implements the Compute interface
public class ComputeEngine implements Compute {

	//The constructor
    public ComputeEngine() {
        super();
    }

	//This method is externalized in order to execute remote method
    public <T> T executeTask(Task<T> t) {
        return t.execute();
    }

    public static void main(String[] args) {
        
        try {
			//The name of the Remote Object
            String name = "Daniel";
			//Instace of ComputeEngine (Remote)
            Compute engine = new ComputeEngine();
			//Generate Stubs in running time
            Compute stub =
                (Compute) UnicastRemoteObject.exportObject(engine, 0);
			//Locate the Object Name Service (rmiregistry)
            LocateRegistry.createRegistry(1099);
                        
            Registry registry = LocateRegistry.getRegistry("127.0.0.1");
			//Registry the Remote Object
            registry.rebind(name, stub);
            System.out.println("ComputeEngine bound");
        } catch (Exception e) {
            System.err.println("ComputeEngine exception:");
            e.printStackTrace();
        }
    }
}
