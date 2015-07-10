package printer;

import Ice.Current;
import PrinterInterface._PrinterDisp;

public class PrinterI extends _PrinterDisp {

	@Override
	public void printString(String s, Current __current) {
		// TODO Auto-generated method stub
		System.out.println("Server recieve from client: "+s);
		System.out.println("Server send back to client: "+compute(s));
		
	}

	private String compute(String s) {
		// TODO Auto-generated method stub
		s="server->client: Hello cilent!";
		return s;
	}

}
