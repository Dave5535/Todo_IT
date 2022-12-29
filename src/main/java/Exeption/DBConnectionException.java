package Exeption;

public class DBConnectionException extends Exception{
    public DBConnectionException(String message){
        super(message);
    }
}
