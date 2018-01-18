package Persistence;

public class Backup {

	public static void backup() {
            
            Process p=null;
        try {
            Runtime runtime = Runtime.getRuntime();
            p=runtime.exec("C:/Program Files/MySQL/MySQL Server 5.7/bin/mysqldump.exe -u"root*/ "-p"/*password*/ "--add-drop-database -B blucyan -r"+"C:/Users/Usuario/Desktop/patata-backup.sql");
            
            int processComplete = p.waitFor();
            if (processComplete==0) {
              System.out.println("Bien\n");
            }else{
              System.out.println("Mal\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        }
        
        
         public static void main (String args[]){
             backup();
        }
}