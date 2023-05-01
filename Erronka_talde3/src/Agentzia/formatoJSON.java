package Agentzia;

import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class formatoJSON extends Formatter{

	@Override
	public String format(LogRecord record) {
		// TODO Auto-generated method stub
		return "<opcion>\n"+record.getMessage()+"\n</opcion>\n";
	}
	
	public String getHead(Handler h) {
		// TODO Auto-generated method stub
		return "<mensajes>\n	<mensaje>  \n";
	}
	
	public String getTail(Handler h) {
		// TODO Auto-generated method stub
		return "	</mensaje>\n</mensajes>\n";
	}

}
