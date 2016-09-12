package client;

import java.math.BigDecimal;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import compute.Compute;

//Client code the uses the Remote Object
public class ComputePi {
    public static void main(String args[]) {

        try {
			//Remote Object name
            String name = "Daniel";
			//Locate the Object Name Service (rmiregistry) as an argument (localhost)
            Registry registry = LocateRegistry.getRegistry("localhost");
			//Instantiate the Remote Object connecting to it
            Compute comp = (Compute) registry.lookup(name);
			//Generate a new task to be executed by this remote object (Value)
            Pi task = new Pi(Integer.parseInt("1000"));
			//Execute the Task (Like a local execution)
			//Note that there's nothing here saying to send or receive data
            BigDecimal pi = comp.executeTask(task);
            
            Prime taskPrime = new Prime(Integer.parseInt("2003"));
            long before = System.currentTimeMillis();
            BigDecimal prime = comp.executeTask(taskPrime);
            long after = System.currentTimeMillis();
            //after = after-before;
            System.out.println("tempo total "+(after-before));
            System.out.println(pi);
            System.out.println(prime);

        } catch (Exception e) {
            System.err.println("ComputePi exception:");
            e.printStackTrace();
        }
    }    
}
