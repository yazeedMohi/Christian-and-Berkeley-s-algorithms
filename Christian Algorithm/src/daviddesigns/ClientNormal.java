package daviddesigns;

import java.net.URL;  
import javax.xml.namespace.QName;  
import javax.xml.ws.Service;  
import java.time.LocalDateTime;    
public class ClientNormal{  
    public static void main(String[] args) throws Exception {  
    	URL url = new URL("http://localhost:7778/ws/time?wsdl");   
        QName qname = new QName("http://daviddesigns/", "ServerTimeImplService");  
        Service service = Service.create(url, qname);  
        ServerTime tServ = service.getPort(ServerTime.class);  
        // Printing the time manifesting that it was changed in the client (system time cannot be changed in java due to protection reasons)
        // Printing both the previous time (before synchronization) and the sync server time for contrasting
        System.out.println("Cleint Time (before sync): " +LocalDateTime.now());
        System.out.println("Server Time (synced time): " + tServ.getServerTime()); 
     }  
 }  