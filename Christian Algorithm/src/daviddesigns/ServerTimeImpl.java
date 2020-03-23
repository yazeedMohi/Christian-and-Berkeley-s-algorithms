package daviddesigns;

import java.time.LocalDateTime;    
import javax.jws.WebService;  
//Service Implementation  
@WebService(endpointInterface = "daviddesigns.ServerTime")  
public class ServerTimeImpl implements ServerTime{  
	// Return the current server time in a string format, can be parsed at the client later into LocalDateTime format
	// Sent as string so that the marshaling overhead is minimized
    @Override  
    public String getServerTime() {
        return LocalDateTime.now().toString();
    }  
}