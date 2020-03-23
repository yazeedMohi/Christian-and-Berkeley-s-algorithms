package daviddesigns;

import javax.jws.WebMethod;  
import javax.jws.WebService;  
import javax.jws.soap.SOAPBinding;  
import javax.jws.soap.SOAPBinding.Style;
//Service Endpoint Interface  
@WebService  
@SOAPBinding(style = Style.RPC)  
public interface ProvideTime{  
	// Sets the time at the slave process using string formation which can later be parsed into LocalDateTime format
    @WebMethod void setSlaveTime(String newTime); 
    // Gets the current time milliseconds at the slave
    @WebMethod long getSlaveMillis();
}  