package model;

public class NotesAndAlerts {

	public NotesAndAlerts(String note , String title , String symbol , String date){
		Symbol = symbol;
		Note = note;
		AlertTitle = title;
		AlertDate = date;
	}

	private String AlertTitle,Note,Id,Symbol, AlertDate;
}
