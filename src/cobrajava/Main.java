package cobrajava;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/*
 * 

         .           ___/             
 _   __ /|    ____ .'  /\   __.  .___ 
 |   /   |   (     |  / | .'   \ /   \
 `  /    |   `--.  |,'  | |    | |   '
  \/    _|_ \___.' /`---'  `._.' /    
                                      
			Source Code
	(i FINALLY know how to code in java)
	quick v1s0or tip: if your building a port scanner
	i recommend using "scanme.nmap.org" as your example to 
	test it
	
	(I DONT SUPPORT ANY ILLEGAL ACTIVITES IN CYBERCRIME, I LIKE
	DOING THESE PROJECTS FOR THE SILLYS AND BOREDOM)

 */

public class Main {
    public static void main(String[] args) {

    	System.out.println(" _____       _               \r\n"
    			+ "/  __ \\     | |              \r\n"
    			+ "| /  \\/ ___ | |____   ____ _ \r\n"
    			+ "| |    / _ \\| '_ \\ \\ / / _` |\r\n"
    			+ "| \\__/\\ (_) | |_) \\ V / (_| |\r\n"
    			+ " \\____/\\___/|_.__/ \\_/ \\__,_|                   \r\n"
    			+ " Cobra Parody made in Java, might be slow.\r\n"
    			+ " side project, spelt as CO + UV + A (B is slient)\r\n"
    			+ " made by v1s0or\r\n"
    			+ "" + RESET);
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Do you want to scan a single port? (y/n)");
        String answer = scanner.nextLine();
        
        while(true) {
            if(answer.equals("n")) {
            	main2(args);
            	break; // will only run once
            }
            else {
            	SinglePortScan.single(args); 
            	break;
            }
        }
    }
    
    private static void main2(String[] args) {
    	Scanner scanner2 = new Scanner(System.in);
        System.out.print("\nEnter host (e.g., localhost or 192.168.1.1): \n");
        String host = scanner2.nextLine();

        System.out.print("Enter starting port: ");
        int startPort = scanner2.nextInt();

        System.out.print("Enter ending port: ");
        int endPort = scanner2.nextInt();

        int timeout = 100; // milliseconds
        int openPortCount = 0; // int to uhhh open ports
        int closedPortCount = 0; // int to closed ports
        List<Integer> openPorts = new ArrayList<>(); // list of the port numbers

        System.out.println("\nScanning ports...\n");

        for (int port = startPort; port <= endPort; port++) {
            try (Socket socket = new Socket()) {
                socket.connect(new InetSocketAddress(host, port), timeout);
                System.out.println("[+] Port " + port + " is OPEN");
                openPorts.add(port); // counts the open port number
                openPortCount++; // how many ports are opened are counted
            } catch (IOException ex) {
                System.out.println("[-] Port " + port + " is CLOSED");
                closedPortCount++;
            }
        }

        System.out.println("\nScanning complete.");
        System.out.println("Open ports found: " + openPortCount);
        System.out.println(openPorts);
        System.out.println("\n");
        System.out.println("Closed Ports: " + closedPortCount);
        scanner2.close();
    }
}
