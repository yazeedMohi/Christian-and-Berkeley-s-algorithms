package daviddesigns;


import javax.jws.WebService;  
//Service Implementation  
@WebService(endpointInterface = "daviddesigns.ProvideTime")  
public class ProvideTimeImpl implements ProvideTime{  
    
	// Printing the time manifesting that it was changed in the slave (system time cannot be changed in java due to protection reasons)
    @Override
    public void setSlaveTime(String newTime) {
    	System.out.println("New Slave time:" + newTime);
    }
    @Override
    public long getSlaveMillis() {
    	return System.currentTimeMillis();
    }
}