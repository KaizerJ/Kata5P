package dbpersistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.PersonList;
import persistance.PersonLoader;

public class DBPersonLoader implements PersonLoader {
    private final String connectString = 
            "jdbc:sqlite:C:\\Users\\Jonay\\Documents\\NetBeansProjects\\Kata5P\\KATA5.db";
    private Connection connection = null;

    @Override
    public PersonList query() {
        PersonList personList = new PersonList();
        this.open();
        
        select_PERSONAS(personList);
        
        this.close();
        return personList;
    }
    
    private void open() {
        try {
            this.connection = DriverManager.getConnection(connectString);
        } catch (SQLException exception) {
            System.out.println("ERROR DataBase::open (SQLExcepton) " + exception.getMessage());
        }
    }
    
    private void close() {
        if(this.connection != null)
            try {
                this.connection.close();
        } catch (SQLException exception) {
            System.out.println("ERROR DataBase::close (SQLExcepton) " + exception.getMessage());
        }
    }
    
    private void select_PERSONAS(PersonList personList) {
        String SQL = "SELECT * FROM PEOPLE";
        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultset = statement.executeQuery(SQL);
            
            while(resultset.next()){
                personList.addPerson(resultset.getString("Name"), 
                        resultset.getString("Surname"), 
                        resultset.getString("Department"));
            }
                
            
        } catch (SQLException exception) {
            System.out.println("ERROR DataBase::select_PERSONAS (SQLExcepton) " + exception.getMessage());
        }
    }
}
