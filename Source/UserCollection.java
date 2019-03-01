import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
/**
 * 
 * @author girayhan
 *
 */
public class UserCollection {


	static ArrayList<User> userlist=new ArrayList<User>();
	static SimpleDateFormat simpleDateFormat= new SimpleDateFormat("dd/MM/yyyy");

	/**
	 * This function adding user
	 * @param name of user
	 * @param userName of user
	 * @param password of user
 	 * @param dateOfBirth of user 
	 * @param schoolInfo of user
	 */
	public static void addUser(String name,String userName,String password,Date dateOfBirth,String schoolInfo){
		
		userlist.add(new User(name,userName,password,dateOfBirth,schoolInfo));
		
		System.out.println(name+" " +userName+" " +password+" "+simpleDateFormat.format(dateOfBirth)+" "+schoolInfo);
		System.out.println(name+" has been successfully added.");
	}
	/**
	 * This function removing user.
	 * @param id user id
	 * @return true or false
	 */
	public static boolean removeUser(int id){

		for (int i=0;i<userlist.size();i++){
			if(id==UserCollection.userlist.get(i).userID2){
				UserCollection.userlist.remove(i);
				return true;
			}
		}
		return false;
}
	/**
	 * This function allowing to the signing in.
	 * @param name name of user
	 * @param password password of user	
	 * @return access login
	 */
	
	public static String userSignin(String name,String password){
		for(User abc:userlist){
			if(abc.getUserName().contains(name)){
				if(abc.getPassword().equals(password)){
					abc.signIn();
					return "dogru";//System.out.println("You have successfully signed in.");
				}
				else; return "ysifre";
			}
			
		}
		
	return "yname";
	

	}
	/**
	 * This function showing all posts.
	 * @param user user
	 */
	public static void showPosts(String user){
		System.out.println("------------------------------");
		System.out.println("Command SHOWPOSTS "+user);
		int a=0;
		for (User user1: userlist){
			if (user1.getUserName().equals(user)){
				a=1;
				for (Post post : user1.postList){
					System.out.println(post);
				}
			}
		}if(a==0){
			System.out.println("No such user!");
		}
	}
}







