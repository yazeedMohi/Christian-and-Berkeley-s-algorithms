package daviddesigns;

import java.net.URL;  
import javax.xml.namespace.QName;  
import javax.xml.ws.Service;  
import java.time.LocalDateTime;    
public class ClientWithRoundTrip{  
    public static void main(String[] args) throws Exception {  
    	URL url = new URL("http://localhost:7778/ws/time?wsdl");  
    
        QName qname = new QName("http://daviddesigns/", "ServerTimeImplService");  
        Service service = Service.create(url, qname);  
        ServerTime tServ = service.getPort(ServerTime.class);
        LocalDateTime timeBeforeSleep = LocalDateTime.now();
        
        try {
        	Thread.sleep(5000);
        }catch(Exception e) {
        	System.out.println(e.getMessage());
        }
        // Same as the normal client code but with the addition of a 5 second sleep at the client (representing round trip delay)
        String servTime = tServ.getServerTime();
        System.out.println("Client Time (before sync): "+ timeBeforeSleep.toString());
        System.out.println("Server Time (synced time): " + servTime);
     }  
 }  