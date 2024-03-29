package Persistence;

/**
 * Class that creates the backup of the database
 * 
 * @author cloud
 */
public class Backup {

    /**
     * Performs the backup of the database
     * 
     */
    public static void backup(String dump, String save) {

        Process p = null;
        try {
            Runtime runtime = Runtime.getRuntime();
            //p = runtime.exec("C:/Program Files/MySQL/MySQL Server 5.7/bin/mysqldump.exe -u"root  */  "-p"/*password*/ "--add-drop-database -B blucyan -r"+"C:/Users/Usuario/Desktop/patata-backup.sql");
           p = runtime.exec(dump+" -u blucyan -prooterino@ --add-drop-database -h den1.mysql1.gear.host blucyan -r "+save);

            
            int processComplete = p.waitFor();
            if (processComplete == 0) {
                System.out.println("Bien\n");
            } else {
                System.out.println("Mal\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
