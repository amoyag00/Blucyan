/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author alex
 */
public class DBConnection{
    private String dataBaseURL;
    private String driverName;
    private String user;
    private String pass;
    private Connection connection;
    public String getDataBaseURL() {
        return dataBaseURL;
    }
    
    public Connection getConnection(){
        return this.connection;
    }
    
    public String getDriverName(){
        return this.driverName;
    }
            
//…….. AQUÍ VAN TODOS LOS GETTERS & SETTERS DE LOS PARÁMETROS DE LA CLASE
    public DBConnection(){
        this.dataBaseURL = "jdbc:mysql://localhost:3306/Blucyan?autoReconnect=true&useSSL=true";
        this.driverName = "com.mysql.jdbc.Driver";
        this.user = "root";
        this.pass = "123455";
    }
    public void openConnection() throws Exception{
        if ((dataBaseURL=="") || (user=="") || (pass=="") || (driverName=="")){
            System.out.println("Error al crear la conexión (¿están inicializados?) con estos valores:");
        this.showConnectionValues();
        }else {
            try{
                Class.forName(this.driverName);
                this.connection = DriverManager.getConnection(this.dataBaseURL, this.user, this.pass);
            }catch (Exception e){
                throw new Exception("Al abrir la base de datos " + e.getMessage());
            }
        }
    }
    public void closeConnection() throws Exception {
        try {
            this.connection.close();
            System.out.println ("Cierre correcto de la conexión con la base de datos");
        }catch (Exception e){
            throw new Exception("Al cerrar la conexión de la base de datos. " + e.getMessage());
        }
    }
    
    public void showConnectionValues(){
        System.out.println("error");
    }
}

