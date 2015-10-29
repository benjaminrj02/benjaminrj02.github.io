package viewui;

import java.util.Scanner;

import model.BaseballStats;
import model.IBaseballStatsDAO;
import model.datastore.mysql.BaseballStatsDAO;

/**
 * @author Richard Benjamin
 * @version 20151015
 * 
 */
public class BaseballstatsApp {

	IBaseballStatsDAO baseballstatsList = new BaseballStatsDAO();
	Scanner sc = new Scanner(System.in);

	public BaseballstatsApp() {
		menuLoop();
	}

	private void menuLoop() {
		int playerId;
		String last, first, singles, doubles, triples, homeruns;
		String choice = "1";
		while (!choice.equals("0")) {
			System.out.println("\nBaseball Stats App");
			System.out.println("0 = Quit");
			System.out.println("1 = List All Records");
			System.out.println("2 = Create New Record");
			System.out.println("3 = Retrieve Record");
			System.out.println("4 = Update Record");
			System.out.println("5 = Delete Record");
			choice = Validator.getLine(sc, "Number of choice: ", "^[0-5]$");

			switch (choice) {
			case "1":
				System.out.println(baseballstatsList.retrieveAllRecords());
				break;
			case "2":
				playerId = Validator.getInt(sc, "New player ID: ");
				last = Validator.getLine(sc, "Last name: ");
				first = Validator.getLine(sc, "First name: ");
				singles = Validator.getLine(sc, "Singles ");
				doubles = Validator.getLine(sc, "Doubles ");
				triples = Validator.getLine(sc, "Triples ");
				homeruns = Validator.getLine(sc, "Homeruns ");
				baseballstatsList.createRecord(new BaseballStats(playerId, last, first, singles, doubles,triples,homeruns));
				break;
			case "3":
				playerId = Validator.getInt(sc, "Player ID to retrieve: ");
				System.out.println(baseballstatsList.retrieveRecordById(playerId));
				break;
			case "4":
				playerId = Validator.getInt(sc, "Player ID to update: ");
				last = Validator.getLine(sc, "Last name: ");
				first = Validator.getLine(sc, "First name: ");
				singles = Validator.getLine(sc, "Singles: ");
				doubles = Validator.getLine(sc, "Doubles: ");
				triples = Validator.getLine(sc, "Triples: ");
				homeruns = Validator.getLine(sc, "Homeruns: ");
				baseballstatsList.createRecord(new BaseballStats(playerId, last, first, singles, doubles,triples,homeruns));
				break;
			case "5":
				playerId = Validator.getInt(sc, "Player ID to delete: ");
				System.out.println(baseballstatsList.retrieveRecordById(playerId));
				String ok = Validator.getLine(sc, "Delete this record? (y/n) ", "^[yYnN]$");
				if (ok.equalsIgnoreCase("Y")) {
					baseballstatsList.deleteRecord(playerId);
				}
			case "6":
				playerId = Validator.getInt(sc, "Most Homeruns");
				baseballstatsList.getMostHomeRuns();
				break;
			}
		}
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		new BaseballstatsApp();
	}
}
