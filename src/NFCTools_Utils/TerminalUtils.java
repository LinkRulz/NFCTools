package NFCTools_Utils;



import java.util.ArrayList;
import java.util.List;

import javax.smartcardio.CardException;
import javax.smartcardio.CardTerminal;
import javax.smartcardio.TerminalFactory;

import org.nfctools.scio.Terminal;
import org.nfctools.scio.TerminalHandler;
import org.nfctools.spi.acs.AcsTerminal;

public class TerminalUtils {
	public static Terminal getAvailableTerminal() {
		return getAvailableTerminal(null);
	}

	public static Terminal getAvailableTerminal(String preferredTerminalName) {
		TerminalHandler terminalHandler = new TerminalHandler();
		terminalHandler.addTerminal(new AcsTerminal());
		return terminalHandler.getAvailableTerminal(preferredTerminalName);
	}

	public static List<String> getAvailableTerminals() throws CardException {
		List<String> terminals = new ArrayList<String>();
		TerminalFactory terminalFactory = TerminalFactory.getDefault();
		List<CardTerminal> cardTerminals = terminalFactory.terminals().list();
		for (CardTerminal cardTerminal : cardTerminals) {
			terminals.add(cardTerminal.getName());
		}
		return terminals;
	}
}
