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
                help = "Texto ayuda home";
            }
            else if(view.equals("Search")){
                help = "Texto ayuda search";
            }  
            else if(view.equals("ElementCard")){
                help = "Texto ayuda elementCard";
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