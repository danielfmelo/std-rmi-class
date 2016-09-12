package compute;

import java.rmi.Remote;
import java.rmi.RemoteException;

//Defining the remote interface
public interface Compute extends Remote {
	//This interface just have one method, executeTask
	//executeTask use Generic notation and receive as a parameter a Task<T>
    <T> T executeTask(Task<T> t) throws RemoteException;
}
