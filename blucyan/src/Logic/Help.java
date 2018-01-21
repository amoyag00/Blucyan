package Logic;

public class Help {

	/**
	 * 
	 * @param view
	 */
        private static Help instance;
        String help;
        
	public String getHelp(String view) {
		
            if(view.equals("Home")){
                help = "In this view you can see the elements you have added to your"
                        + "personal lists. You have 3 types of Lists: Videogames, Comics and Shows."
                        + "In this view you can delete the entries you have added or modify the values "
                        + "you gave to them. You can also search other elements or users by using the searcher.";
            }
            else if(view.equals("Search")){
                help = "In this view you can search for the elements available in the database. Once you have made a "
                        + "search you can select one of the results and access to additional information of it by clicking on"
                        + "its image. You can also search for user profiles. Those users who does not have their profiles as"
                        + " private will be shown. You can go back to the HOME view by clicking BACK button";
            }  
            else if(view.equals("ElementCard")){
                help = "In this view you can see all the information available of an element."
                        + "You can add the element to your list by clicking add and specify a value,"
                        + "a status like planned to watch in a future or completed and similar ones. "
                        + "You can also write a personal review for that element. You will be the only one able"
                        + "to see it.";
            }
            
            return help;
	}
        
        public static Help getInstance() {
            if(instance == null){
                instance = new Help();
            }
            
            return instance;
        }
}