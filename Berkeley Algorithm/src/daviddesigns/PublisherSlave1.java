package daviddesigns;

import javax.xml.ws.Endpoint;  
//Endpoint publisher  
public class PublisherSlave1{  
  public static void main(String[] args) {  
     Endpoint.publish("http://localhost:7741/ws/time", new ProvideTimeImpl());  
      }  
}  