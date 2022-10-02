import java.sql.PreparedStatement;
public abstract class Account {

    String name;
    int ID;
    PreparedStatement pst;

    abstract boolean isInDatabase(int id);
}