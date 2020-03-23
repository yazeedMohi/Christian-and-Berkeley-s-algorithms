package daviddesigns;

import javax.xml.ws.Endpoint;  
//Endpoint publisher  
public class PublisherSlave2{  
  public static void main(String[] args) {  
     Endpoint.publish("http://localhost:7742/ws/time", new ProvideTimeImpl());  
      }  
}  