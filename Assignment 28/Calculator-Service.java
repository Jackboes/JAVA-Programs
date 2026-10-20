import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class CalculatorRMI {

    // 1. Remote interface
    public interface Calculator extends Remote {
        double add(double a, double b) throws RemoteException;
        double subtract(double a, double b) throws RemoteException;
        double multiply(double a, double b) throws RemoteException;
        double divide(double a, double b) throws RemoteException;
    }

    // 2. Remote object implementation (server side)
    public static class CalculatorImpl extends UnicastRemoteObject implements Calculator {
        public CalculatorImpl() throws RemoteException { super(); }
        public double add(double a, double b) { return a + b; }
        public double subtract(double a, double b) { return a - b; }
        public double multiply(double a, double b) { return a * b; }
        public double divide(double a, double b) throws RemoteException {
            if (b == 0) throw new RemoteException("Division by zero");
            return a / b;
        }
    }

    public static void main(String[] args) {
        try {
            System.setProperty("java.rmi.server.hostname", "localhost");

            // ---- SERVER PART ----
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("CalculatorService", new CalculatorImpl());
            System.out.println("Server: Calculator service is ready.");

            // ---- CLIENT PART ----
            Registry reg = LocateRegistry.getRegistry("localhost", 1099);
            Calculator calc = (Calculator) reg.lookup("CalculatorService");   // this is the STUB
            System.out.println("10 + 5 = " + calc.add(10, 5));
            System.out.println("10 - 5 = " + calc.subtract(10, 5));
            System.out.println("10 * 5 = " + calc.multiply(10, 5));
            System.out.println("10 / 5 = " + calc.divide(10, 5));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.exit(0);   // stop RMI threads
    }
}
