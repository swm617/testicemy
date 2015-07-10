package server;

import printer.PrinterI;

public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int status=0;
		Ice.Communicator ic=null;
		
		try{
			ic=Ice.Util.initialize(args);
			Ice.ObjectAdapter adapter=ic.createObjectAdapterWithEndpoints("SimplePrinterAdapter", "default -h localhost -p 10000");
			Ice.Object object=new PrinterI();
			adapter.add(object, Ice.Util.stringToIdentity("SimplePrinter"));
			adapter.activate();
			ic.waitForShutdown();
		}catch(Ice.LocalException e){
			e.printStackTrace();
			status=1;
		}catch(Exception e){
			System.err.println(e.getMessage());
			status=1;
		}finally{
			if(ic!=null)
				ic.destroy();
		}
		System.exit(status);
	}

}
