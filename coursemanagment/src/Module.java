import java.sql.ResultSet;
import java.sql.SQLException;
public class Module extends Account {
    public Module(){}

    public String getName(){
        return name;
    }

    public int getID() {
        return ID;
    }
    public boolean isInDatabase(int id) {
        String sql = "select module_id,module_name from module where module_id = ?";
        try {
            pst = Database.getConnection().prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                initializeAccount(rs);
                return true;
            }
        } catch (SQLException ex) {
            System.out.println();
            System.out.println("Error: "+ ex.getMessage());
        }
        return false;
    }
    private void initializeAccount(ResultSet rs) {

        try {
            this.ID = rs.getInt(1);
            this.name = rs.getString(2);
        } catch (SQLException ex) {
            System.out.println();
            System.out.println("Error: "+ ex.getMessage());
        }
    }
    public boolean checkModulesInDataBase(int courseID){
        String sql= "select * from module where course_id=?";
        try{
            pst = Database.getConnection().prepareStatement(sql);
            pst.setInt(1,courseID);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                return true;
            }
        }catch (SQLException e){
            System.out.println("Error: "+e.getMessage());
            System.out.println();
        }
        return false;
    }
}