package mysql;

public interface UserDao {
   public void addUser(String name,String password);
   public User queryUser(String name,String password);
  
}
