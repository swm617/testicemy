package client;

import PrinterInterface.PrinterPrx;
import PrinterInterface.PrinterPrxHelper;

public class Client {
	public static void main(String[] args){
		int status=0;
		Ice.Communicator ic=null;
		try{
			ic=Ice.Util.initialize(args);
			Ice.ObjectPrx base=ic.stringToProxy("SimplePrinter:default -h localhost -p 10000");
			PrinterPrx printer=PrinterPrxHelper.checkedCast(base);
			if(printer==null)
				throw new Error("Invalid proxy");
			printer.printString("client->server:Hello server!");
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
