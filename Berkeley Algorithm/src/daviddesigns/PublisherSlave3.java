package daviddesigns;

import javax.xml.ws.Endpoint;  
//Endpoint publisher  
public class PublisherSlave3{  
  public static void main(String[] args) {  
     Endpoint.publish("http://localhost:7743/ws/time", new ProvideTimeImpl());  
      }  
}  