package daviddesigns;

import java.net.URL;  
import javax.xml.namespace.QName;  
import javax.xml.ws.Service;  
import java.time.LocalDateTime;
import java.util.ArrayList;    
public class Master{  
    public static void main(String[] args) throws Exception {
    	// Storing the current time in a variable and printing it
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("Current Time:   "+ currentTime.toString());
        // Preparing temporary variables for connecting to the slaves
        URL url;
        Service service;
        ProvideTime pTime;
        QName qname = new QName("http://daviddesigns/", "ProvideTimeImplService");
        // Getting the current millis time (since LocalDateTime does not allow manipulating the milliseconds portion)
        long currentMillis = System.currentTimeMillis();
        // Creating a new ArrayList and filling it with the port addresses of the slaves
        ArrayList<Integer> slavesPorts = new ArrayList<Integer>();
        slavesPorts.add(7741);slavesPorts.add(7742);slavesPorts.add(7743);
        long sumDelta = 0;
        long deltaTemp;
        // Looping through the slaves port numbers and sending a request to each
        for(int portNum : slavesPorts) {
        	url = new URL("http://localhost:"+portNum+"/ws/time?wsdl");
            service = Service.create(url, qname);
            pTime = service.getPort(ProvideTime.class);
            // Calculating the delta
            deltaTemp = pTime.getSlaveMillis() - currentMillis;
            sumDelta += deltaTemp;
        }
        
        // Calculating the average
        long averageDelta = sumDelta/(slavesPorts.size()+1);
        // Setting the new time at the master (used plusNanos because plusMillis is not available)
        LocalDateTime newTime = currentTime.plusNanos(1000*1000*averageDelta);
        System.out.println("New Time (sync):"+ newTime.toString());

        // And finally, sending the updated time to the slaves
        for(int portNum : slavesPorts) {
        	url = new URL("http://localhost:"+portNum+"/ws/time?wsdl");
            service = Service.create(url, qname);
            pTime = service.getPort(ProvideTime.class);
            // The function for setting time at the slave
            pTime.setSlaveTime(newTime.toString());
        }
        
     }  
 }  