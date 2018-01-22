package Logic;

public class HelpController {

	/**
	 * Controller class for accesing the Help
	 * @param currentView
         * @author Carlos, Alejandro, Samuel
	 */
        private static HelpController instance;
         /**
          * returns the help corresponding to the view currentView
          * @param currentView
          * @return the help corresponding to currentView
          */
	public String requestHelp(String currentView) {
		
            Help h = Help.getInstance();
                    
            return h.getHelp(currentView);
	}
        /**
         * returns a unique instance of this class according to the singleton 
         * pattern
         * @return 
         */
        public static HelpController getInstance(){
            if(instance == null){
                instance = new HelpController();
            }
            
            return instance;
        }
}