import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class TemperatureRMI {

    public interface TempConverter extends Remote {
        double celsiusToFahrenheit(double c) throws RemoteException;
        double fahrenheitToCelsius(double f) throws RemoteException;
    }

    public static class TempConverterImpl extends UnicastRemoteObject implements TempConverter {
        public TempConverterImpl() throws RemoteException { super(); }
        public double celsiusToFahrenheit(double c) { return (c * 9 / 5) + 32; }
        public double fahrenheitToCelsius(double f) { return (f - 32) * 5 / 9; }
    }

    public static void main(String[] args) {
        try {
            System.setProperty("java.rmi.server.hostname", "localhost");

            // ---- SERVER PART ----
            Registry registry = LocateRegistry.createRegistry(1100);
            registry.rebind("TempService", new TempConverterImpl());
            System.out.println("Server: Temperature service is ready.");

            // ---- CLIENT PART ----
            Registry reg = LocateRegistry.getRegistry("localhost", 1100);
            TempConverter conv = (TempConverter) reg.lookup("TempService");

            System.out.printf("%.2f C = %.2f F%n", 100.0, conv.celsiusToFahrenheit(100));
            System.out.printf("%.2f F = %.2f C%n", 212.0, conv.fahrenheitToCelsius(212));
            System.out.printf("%.2f C = %.2f F%n", 37.0, conv.celsiusToFahrenheit(37));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.exit(0);
    }
}
