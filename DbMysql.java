import java.sql.*;

public class DbMysql {
    private Connection c;

    public DbMysql() {
        try {
            c = DBUtility.getConnection();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ResultSet getCourses() {
        try {
            String select = "SELECT * FROM courses";
            PreparedStatement statement =c.prepareStatement(select);
            return statement.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public ResultSet getStudent() {
        try {
            String select = "SELECT * FROM student";
            PreparedStatement statement =c.prepareStatement(select);
            return statement.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }





    public void addCourse(String id, String name, boolean status) {
        try {
            String add = "INSERT INTO courses ( id, coursename, coursestatus) VALUES (?,?,?)";
            PreparedStatement statement =c.prepareStatement(add);
            statement.setString(1, id);
            statement.setString(2, name);
            statement.setBoolean(3, status);
            statement.executeUpdate();
            statement.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void addModules(int moduleID, String moduleName, int level, int semester, String courseID) {
        try {
            String add = "INSERT INTO modules ( id, modulename, modulelevel, semester,courseID ) VALUES (?,?,?,?,?)";
            PreparedStatement statement =c.prepareStatement(add);
            statement.setInt(1, moduleID);
            statement.setString(2, moduleName);
            statement.setInt(3, level);
            statement.setInt(4, semester);
            statement.setString(5, courseID);

            statement.executeUpdate();
            statement.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateCourseStatus(String courseID, boolean b) {
        try {
            String update = "UPDATE courses SET coursestatus = ? WHERE id = ?";
            PreparedStatement statement =c.prepareStatement(update);

            statement.setBoolean(1, b);
            statement.setString(2, courseID);

            statement.executeUpdate();
            statement.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void deleteCourse(String courseID) {
        try {
            String remove = "DELETE FROM courses WHERE id = ?";
            PreparedStatement statement =c.prepareStatement(remove);
            statement.setString(1, courseID);
            statement.executeUpdate();
            statement.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteModule(int moduleID) {
        try {
            String remove = "DELETE FROM modules WHERE id = ?";
            PreparedStatement statement =c.prepareStatement(remove);
            statement.setInt(1, moduleID);
            statement.executeUpdate();
            statement.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void changeCourseName(String courseID, String courseName) {
        try {
            String update = "UPDATE courses SET coursename = ? WHERE id = ?";
            PreparedStatement statement =c.prepareStatement(update);

            statement.setString(1, courseName);
            statement.setString(2, courseID);

            statement.executeUpdate();
            statement.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void addAssignFaculty(String FacultyName, String moduleId) {
        try {
            String add = "INSERT INTO Faculty( FacultyName, moduleId) VALUES (?,?)";
            PreparedStatement statement =c.prepareStatement(add);
            statement.setString(1, FacultyName);
            statement.setString(2, moduleId);
            statement.executeUpdate();
            statement.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void removeFaculty(int id) {
        try {
            String remove = "DELETE FROM Faculty WHERE id = ?";
            PreparedStatement statement =c.prepareStatement(remove);
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void studentRegistration(String stName, String courseId, int stdLevel) {
        try {
            String add = "INSERT INTO student ( studentname, courseId, courselevel) VALUES (?,?,?)";
            PreparedStatement statement =c.prepareStatement(add);
            statement.setString(1, stName);
            statement.setString(2, courseId);
            statement.setInt(3, stdLevel);

            statement.executeUpdate();
            statement.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ResultSet getModulesAlongwithFaculty() {
        try {
            String select = "select C.id as courseID ,M.id as ModuleID, M.modulename, M.modulelevel, M.semester, I.Facultyname from modules as M join Faculty as I on I.moduleId=M.id join courses as C on C.id = M.courseId;";
            PreparedStatement statement =c.prepareStatement(select);
            return statement.executeQuery();
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return null;
    }

    public ResultSet getFacultyAssignedModule() {
        try {
            String select = "select M.id as ModuleID, M.modulename, I.FacultyID from modules as M join Faculty as I on M.id = I.moduleID;";
            PreparedStatement statement =c.prepareStatement(select);
            return statement.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public ResultSet getStudentsInModules() {
        try {
            String select = "select S.id as StudentID, S.studentname, M.id as moduleid from student as S join modules as M on M.courseID = S.courseID and S.courselevel = M.modulelevel;";
            PreparedStatement statement =c.prepareStatement(select);
            return statement.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void markStudent(int mID, int stdID, int mark) {
        try {
            String add = "INSERT INTO Marks ( stdID, moduleID, moduleMark) VALUES (?,?,?)";
            PreparedStatement statement =c.prepareStatement(add);
            statement.setInt(1, stdID);
            statement.setInt(2, mID);
            statement.setInt(3, mark);

            statement.executeUpdate();
            statement.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    public ResultSet getMarks() {
        try {
            String select = "SELECT * FROM Marks";
            PreparedStatement statement =c.prepareStatement(select);
            return statement.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

}