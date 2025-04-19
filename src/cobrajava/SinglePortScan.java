package cobrajava;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class SinglePortScan {
	
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    
	public static void single(String[] args) {
		Scanner scanner1 = new Scanner(System.in);
		
		System.out.println("\nEnter Host: ");
		String host = scanner1.nextLine();
		
		System.out.println("\nEnter Port to scan");
		int port = scanner1.nextInt();
		
		int timeout = 100;
		
		if(isPortOpen(host, port, timeout)) {
			System.out.println("Port " + port + " is " + GREEN + "OPEN" + RESET);
			}
		else {
			System.out.println("Port " + port + " is " + RED + "CLOSED" + RESET);
		}
		
		}
		
	    public static boolean isPortOpen(String host, int port, int timeout) {
	        try (Socket socket = new Socket()) {
	            // Try to connect to the host and port within the given timeout
	            socket.connect(new InetSocketAddress(host, port), timeout);
	            return true; // If successful, the port is open
	        } catch (IOException e) {
	            return false; // If connection failed, the port is closed
	    }
	}
}
