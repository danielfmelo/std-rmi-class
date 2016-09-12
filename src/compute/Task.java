package compute;

//This interface defines the generic method execute
//Task receive anything (<T>) as a parameter
public interface Task<T> {
    T execute();
}
