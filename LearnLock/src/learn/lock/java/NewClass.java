package learn.lock.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class NewClass {
	
   public static HashMap<String, Product>  product = new HashMap<>();
   
   ServerSocket myServerSocket;
   boolean ServerOn = true;
   
   public NewClass() { 
	  product.put("ahihi", new Product("f101", "LOL", 16));
	   
      try {
         myServerSocket = new ServerSocket(8888);
      } catch(IOException ioe) { 
         System.out.println("Quitting.");
         System.exit(-1);
      } 
		
      Calendar now = Calendar.getInstance();
      SimpleDateFormat formatter = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
      System.out.println("Server is running : " + formatter.format(now.getTime()));
      
      while(ServerOn ) { 
    		  try { 
    	            Socket clientSocket = myServerSocket.accept();
    	            ClientServiceThread cliThread = new ClientServiceThread(clientSocket);
    	            cliThread.start(); 
    	            
    	         } catch(IOException ioe) { 
    	            System.out.println("Exception found on accept. Ignoring. Stack Trace :"); 
    	            ioe.printStackTrace(); 
    	         }  
    	      } 
      try { 
         myServerSocket.close(); 
         System.out.println("Server Stopped"); 
      } catch(Exception ioe) { 
         System.out.println("Error Found stopping server socket"); 
         System.exit(-1); 
      } 
   }
	
   public static void main (String[] args) { 
	   new NewClass();        
   } 

   class ClientServiceThread extends Thread {
	   
      Socket myClientSocket;
      boolean m_bRunThread = true; 
      public ClientServiceThread() { 
         super(); 
      } 
		
      ClientServiceThread(Socket s) { 
         myClientSocket = s; 
      } 
		
      public void run() { 
    	  
         BufferedReader in = null; 
         PrintWriter out = null; 
         System.out.println("Accepted Client Address - " + myClientSocket.getInetAddress().getHostName());
         
         try { 
            in = new BufferedReader(new InputStreamReader(myClientSocket.getInputStream()));
            out = new PrintWriter(new OutputStreamWriter(myClientSocket.getOutputStream()));
            
            out.println("[*]- 1: Add Product" );
            out.println("[*]- 2: Show Product" );
            out.flush();
            
            while(m_bRunThread) { 
            	
               String clientCommand = in.readLine(); 
               System.out.println("Client :" + clientCommand);
               
               if(!ServerOn) { 
                  System.out.print("Server has already stopped"); 
                  out.println("Server has already stopped"); 
                  out.flush(); 
                  m_bRunThread = false;
               } 
               if(clientCommand.equalsIgnoreCase("quit")) {
                  m_bRunThread = false;
                  System.out.print("Stopping client thread for client : ");
               } 
               else if(clientCommand.equalsIgnoreCase("end")) {
                  m_bRunThread = false;
                  System.out.print("Stopping client thread for client : ");
                  ServerOn = false;
               }
               
               else if(clientCommand.equalsIgnoreCase("1")) {
            	   
            		   out.flush();
            		   out.println("[*]: Add/Wait");
            		   out.flush();
            		   synchronized (product) {
						
            		   out.print("Id: ");
	            	   out.flush();
            		   String id = in.readLine();
            		   out.print("PName: ");
	            	   out.flush();
                       String name = in.readLine();
                	   out.print("Amount: ");
	            	   out.flush();
                	   Integer sl = Integer.parseInt(in.readLine());
                		   
                	   if(product.get(id) != null) {
                			Integer nAmnt = product.get(id).getPAmount() + sl;
                			product.get(id).setPAmount(nAmnt);
                		 }
                		else {
                			 product.put(id ,new Product(id, name, sl));
                		   }
					}	   
                }
               else if(clientCommand.equalsIgnoreCase("2")) {
            	 
					Set<String> keys = product.keySet();
					Iterator<String> irt = keys.iterator();
					
					String key;
					String value;
					Integer amt;
					out.println();
					out.println("Id         Name           Amount");
					out.println("********************************");
					while(irt.hasNext())
				        {
				            key = (String)irt.next();
				            value = product.get(key).getPName();
				            amt = product.get(key).getPAmount();
				            out.printf( key + "       " + value + "            " + amt);
				            out.println();
				            out.println();
				            Thread.sleep(500);
				        }
					
            	   out.flush();
            	   out.print("********************************");
            	   out.flush();
            	   out.println();
            	   out.flush();
                }
               
               else {
            	   out.println("[*]- 1: Add Product" );
                   out.println("[*]- 2: Show Product" );
                   out.flush();
                   
               } 
            } 
         } catch(Exception e) { 
            e.printStackTrace(); 
         } 
         
         finally { 
            try { 
               in.close(); 
               out.close(); 
               myClientSocket.close(); 
               System.out.println("...Stopped"); 
            } catch(IOException ioe) { 
               ioe.printStackTrace(); 
            } 
         } 
      } 
   }
   
   class Product{
	   
	    private String Id;
	    private String PName;
	    private Integer PAmount;
	   
	    public Product() {}
	   
		public Product(String id, String pName, Integer pAmount) {
			super();
			Id = id;
			PName = pName;
			PAmount = pAmount;
		}
		public String getId() {
			return Id;
		}
		public void setId(String id) {
			Id = id;
		}
		public String getPName() {
			return PName;
		}
		public void setPName(String pName) {
			PName = pName;
		}
		public Integer getPAmount() {
			return PAmount;
		}
		public void setPAmount(Integer pAmount) {
			PAmount = pAmount;
		}
    }
}