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
                help = "In this view you can see the elements you\nhave added to your"
                        + "personal lists. You have\n3 types of Lists: Videogames, Comics and\nShows."
                        + "In this view you can delete the entries\nyou have added or modify the values "
                        + "you\ngave to them. You can also search\nother elements or users by using the\nsearcher.";
            }
            else if(view.equals("Search")){
                help = "In this view you can search for the\nelements available in the database.\nOnce you have made a "
                        + "search you can\nselect one of the results and access to\nadditional information of it by clicking on\n"
                        + "its image. Youcan also search for\nuser profiles. Those users who does not\nhave their\nprofiles as"
                        + " private will be\nshown. You can go back to the HOME\nview by clicking BACK button";
            }  
            else if(view.equals("ElementCard")){
                help = "In this view you can see all the\ninformation available of an element."
                        + "You\ncan add the element to your list by\nclicking add and specify a value,"
                        + "a status\nlike planned to watch in a future or\ncompleted and similar ones. "
                        + "You can also\nwrite a personal review for that element.\nYou will be the only one able"
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