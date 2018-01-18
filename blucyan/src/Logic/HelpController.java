package Logic;

public class HelpController {

	/**
	 * 
	 * @param currentView
	 */
        private static HelpController instance;
        
	public String requestHelp(String currentView) {
		// TODO - implement HelpController.requestHelp
            Help h = Help.getInstance();
                    
            return h.getHelp(currentView);
	}
        
        public static HelpController getInstance(){
            if(instance == null){
                instance = new HelpController();
            }
            
            return instance;
        }
}