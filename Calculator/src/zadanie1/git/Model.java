package zadanie1.git;

import jdk.jshell.JShell;
import jdk.jshell.SnippetEvent;
import java.util.List;



public class Model {
	/**
	 * 
	 * @param numbers to są wyrażenia matematyczne wysyłane to JShell
	 * @return jezeli wyliczenia wywołują błedy,to jest wysyłany Error  
	 */
	public String JShell_calculate(String numbers) {
		
		JShell jshell = JShell.create();
		try (jshell) { 
		List<SnippetEvent> events = jshell.eval(numbers);
		for (SnippetEvent e : events) {
		if (e.causeSnippet() == null) {
		switch (e.status()) {
		case VALID:
		if (e.value() != null) {
			return  e.value();
		}
		break;
		default: return "Error\n";
		} } } }
		
		return numbers="Error\n";
		
		
		
}}
	
	
	



