public interface MySQLDatabaseConnection {
    void connect();
    void disconnect();
    boolean isConnected();
    void executeQuery(String query);
    
}
