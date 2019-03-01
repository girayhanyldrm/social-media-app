import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * 
 * @author girayhan
 *
 */
public class User {

	public static int userID;
	public int userID2;
	private String name;
	private String userName;
	private String password;
	private Date dateOfBirth; 
	private String schoolInfo;
	public boolean signIn;
	public ArrayList<User> friendList=new ArrayList<User>();
	public ArrayList<User> blockList=new ArrayList<User>();
	public ArrayList<Post> postList=new ArrayList<Post>();

	SimpleDateFormat simpleDateFormat= new SimpleDateFormat("MM/dd/yyyy");
	
	
	
	public void signOut(){
		this.signIn=false;
	}

	public void signIn(){
		
		this.signIn=true;
	}
	/**
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 
	 * @return user name
	 */
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 
	 * @return user password
	 */
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 
	 * @return date of birth 
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	/**
	 * 
	 * @return School name
	 */
	public String getSchoolInfo() {
		return schoolInfo;
	}
	public void setSchoolInfo(String schoolInfo) {
		this.schoolInfo = schoolInfo;
	}
	
	/**
	 * This user constructor.
	 * @param name	name of user
	 * @param userName	user name of user
	 * @param password	password of user	
	 * @param dateOfBirth	date of birth of user
	 * @param schoolInfo	scholl name of user
	 */
	public User(String name,String userName,String password,Date dateOfBirth,String schoolInfo){
		this.name=name;
		this.userName=userName;
		this.password=password;
		this.dateOfBirth=dateOfBirth;
		this.schoolInfo=schoolInfo;
		userID++;
		userID2=userID;
		
	}


	/**
	 * This function updating profile name , date of birth and school name.
	 * @param name user name
	 * @param dateOfBirth user date of birth
	 * @param schoolInfo user school name
	 */
	public void updateProfile(String name,Date dateOfBirth,String schoolInfo){
		
		this.name=name;
		this.dateOfBirth=dateOfBirth;
		this.schoolInfo=schoolInfo;
		System.out.println("\nYour user profile has been successfully updated.");
	}
	
	/**
	 * This function controlling old pass .Depends on the situation and new pass or error.
	 * @param oldPass old password
	 * @param newPass new password
	 */
	public void changePass(String oldPass, String newPass) {
		System.out.println("---------------------------------------"); 
		System.out.println("Command: CHPASS "+oldPass+"	"+newPass);  
		if(this.password.equals(oldPass)){
			this.password=newPass;
		
		}
		else{System.out.println("Password mismatch! Please, try again.");
		}
		}
	/**
	 * This function adding the friends object.
	 * @param friend friend
	 */
	public void addFriend(String friend){
		System.out.println("---------------------------------------"); 
		System.out.println("Command: ADDFRIEND "	+friend);
		ArrayList<String> userNameList=new ArrayList<String>();
		for(User abc:UserCollection.userlist){
			userNameList.add(abc.getUserName());
		}
		if(userNameList.contains(friend)){
			for(User abc:UserCollection.userlist){
				if(abc.getUserName().equals(friend)){
					if(!this.friendList.contains(abc)){
						this.friendList.add(abc);
						System.out.println(friend+" has been successfully added to your friend list.");
					}
					else{
						System.out.println("This user is already in your friend list!");
					}
				}
			}
		}
		else{
			System.out.println("No such user!");
		}
	}
	/**
	 * This function removing the friends object.
	 * @param friend friend
	 */
	public void removeFriend(String friend){
		System.out.println("---------------------------------------"); 
		System.out.println("Command: REMOVEFRIEND "+friend); 
	ArrayList<String> friendNameList=new ArrayList<String>();
	User x=null;
	for(User abc:this.friendList){
		friendNameList.add(abc.getUserName());
		}
	if(friendNameList.contains(friend)){
		for(User abc:this.friendList){
				x=abc;
			}
		this.friendList.remove(x);
		System.out.println(friend+" has been successfully removed from your friend list.");
		}
		else{
			System.out.println("No such friend!");
		}
		
	}
	/**
	 * This function listing all users information.
	 */
	public void listUsers(){
		
		System.out.println("---------------------------------------"); 
		System.out.println("Command: LISTUSERS"); 
		for(User abc:UserCollection.userlist){
			System.out.println("Name: "+abc.getName());
			System.out.println("Username: "+abc.getUserName());
			System.out.println("Date of Birth: "+simpleDateFormat.format(abc.getDateOfBirth()));
			System.out.println("School: "+abc.getSchoolInfo());
			System.out.println("-----------------------------------");
		}
	}
	/**
	 * This function listing all friends information.
	 */
	public void listFriends(){
		System.out.println("---------------------------------------"); 
		System.out.println("Command: LISTFRIENDS");         
		if(friendList.size()==0){
			System.out.println("You haven't added any friends yet!");
		}
		else{
			for(User abc:friendList){
				System.out.println("Name: "+abc.getName());
				System.out.println("Username: "+abc.getUserName());
				System.out.println("Date of Birth: "+simpleDateFormat.format(abc.getDateOfBirth()));
				System.out.println("School: "+abc.getSchoolInfo());
				System.out.println("-----------------------------------");
			}
		}
	}
	/**
	 * This function adding the block list object.
	 * @param blockName blocked name
	 */
	public void block(String blockName){
		System.out.println("----------------------");
		System.out.println("Command: BLOCK "+blockName);
		ArrayList<String> userNameList=new ArrayList<String>();
		for(User abc:UserCollection.userlist){
			userNameList.add(abc.getUserName());
		}
		if(userNameList.contains(blockName)){
			for(User abc:UserCollection.userlist){
				if(abc.getUserName().contains(blockName)){
				blockList.add(abc);
				System.out.println(blockName+" has been successfully blocked.");
				}
			}
		}
		else{
			System.out.println("No such user!");
		}
		
	}
	/**
	 * This function remove the block user object.
	 * @param unblockName unblock name
	 */
	public void unBlock(String unblockName){

		System.out.println("---------------------------------------"); 
		System.out.println("Command: UNBLOCK "+unblockName);    
		ArrayList<String> blockNameList=new ArrayList<String>();
		User x=null;
		for(User abc:this.blockList){
			blockNameList.add(abc.getUserName());
		}
		if(blockNameList.contains(unblockName)){
			for(User abc:this.blockList){
				x=abc;
			}
		this.blockList.remove(x);
		System.out.println(unblockName+" has been successfully unblocked.");
		}
		else{
			System.out.println("No such user in your blocked users list!");
		}
	}
	/**
	 * This function showing all blocked friends information.
	 */
	public void showBlockFriends(){
		System.out.println("-----------------------------------");
		System.out.println("Command: SHOWBLOCKEDFRIENDS");
		String c=null;
		if(!(blockList.size()==0)){
			for(User abc:UserCollection.userlist){
				for(User abcd:this.blockList){
					if(!abc.friendList.contains(abcd)){
						c="You haven't blocked any friends yet!";
					}
					else{
						System.out.println("Name: "+abcd.getName());
						System.out.println("Username: "+abcd.getUserName());
						System.out.println("Date of Birth: "+simpleDateFormat.format(abcd.getDateOfBirth()));
						System.out.println("School: "+abcd.getSchoolInfo());
						System.out.println("-----------------------------------");
						c="";
					}
			}
			
			}
		System.out.println(c);
		}
		else{
			System.out.println("You haven't blocked any users yet!");
		}
	}
	/**
	 * This function showing block users.
	 */
	public void showBlockUsers(){
		System.out.println("---------------------------------------"); 
		System.out.println("Command: SHOWBLOCKEDUSERS");   
		if(!(blockList.size()==0)){
			for(User abc:blockList){
				System.out.println("Name: "+abc.getName());
				System.out.println("Username: "+abc.getUserName());
				System.out.println("Date of Birth: "+simpleDateFormat.format(abc.getDateOfBirth()));
				System.out.println("School: "+abc.getSchoolInfo());
				System.out.println("-----------------------------------");
			}
		}
		else{
			System.out.println("You haven't blocked any users yet!");
		}
	}
	/**
	 * This function adding to text object and tagged.
	 * @param text text of post
	 * @param latitude latitude of post
	 * @param longitude longitude of post
	 * @param friends friends
	 * 
	 */
	public void addText(String text,Double latitude,Double longitude,String friends){
		System.out.println("---------------------------------------");          
		System.out.println("Command: ADDPOST-TEXT	"+text+"	"+latitude+"	"+longitude+"	"+friends);
		ArrayList<String> friend=new ArrayList<String>();
		ArrayList<String> abcd=new ArrayList<String>();
		Date date = new Date();
		
		
		String [] eleman=friends.split(":"); 
		for(User abc:friendList){
			friend.add(abc.getUserName());
		}

		for(int i=0;i<eleman.length;i++){
			if(!friend.contains(eleman[i])){		
				
				System.out.println("Username "+eleman[i]+" is not your friend, and will not be tagged!");
			
			}
			else{
				abcd.add(eleman[i]);
				}
	
		}
		
		TextPost textPost = new TextPost(text,date,latitude,longitude); 
		postList.add(textPost);
		textPost.tagList=abcd;
	
		System.out.println("The post has been successfully added.");
	}
	/**
	 * This function adding to image object and tagged.
	 * @param text text of image
	 * @param latitude latitude of image
	 * @param longitude longitude of image
	 * @param friends	friends
	 * @param ifileName file name of image 
	 * @param imageResolution resolution of image
	 */
	public void addImage(String text,Double latitude,Double longitude,String friends,String ifileName,String imageResolution){
		System.out.println("---------------------------------------");          
		System.out.println("Command: ADDPOST-IMAGE	"+text+"	"+latitude+"	"+longitude+"	"+friends+"	"+ifileName+"	"+imageResolution);
		ArrayList<String> friend=new ArrayList<String>();
		ArrayList<String> abcd=new ArrayList<String>();
		Date date = new Date();
		String [] eleman=friends.split(":");
		for(User abc:friendList){
			friend.add(abc.getUserName());
		}
		for(int i=0;i<eleman.length;i++){
			if(!friend.contains(eleman[i])){
				System.out.println("Username "+eleman[i]+" is not your friend, and will not be tagged!");
			}
			else{
				abcd.add(eleman[i]);

			}
		}
		
		TextPost textPost = new ImagePost(text,date,latitude,longitude,ifileName,imageResolution); 
		postList.add(textPost);
		System.out.println("The post has been successfully added.");
		textPost.tagList=abcd;
	}
	/**
	 * This function adding to video object and tagged.
	 * @param text text of video
	 * @param latitude latitude of video
	 * @param longitude longitude of video
	 * @param friends friends
	 * @param vfileName file name of video
	 * @param maxVideoLenght lenght of video
	 */
	public void addVideo(String text,Double latitude,Double longitude,String friends,String vfileName,int maxVideoLenght){
			System.out.println("---------------------------------------");          
			System.out.println("Command: ADDPOST-VIDEO	"+text+"	"+latitude+"	"+longitude+"	"+friends+"	"+vfileName+"	"+maxVideoLenght);
			if(maxVideoLenght<=10){
			ArrayList<String> friend=new ArrayList<String>();
			ArrayList<String> abcd=new ArrayList<String>();

			Date date = new Date();
			String [] eleman=friends.split(":");
			for(User abc:friendList){
				friend.add(abc.getUserName());
			}
			for(int i=0;i<eleman.length;i++){
				if(!friend.contains(eleman[i])){
					System.out.println("Username "+eleman[i]+" is not your friend, and will not be tagged!");
				}
				else{
					abcd.add(eleman[i]);
				}
			}
			
			TextPost textPost = new VideoPost(text,date,latitude,longitude,vfileName,maxVideoLenght);
			postList.add(textPost);
			System.out.println("The post has been successfully added.");
			textPost.tagList=abcd;
			}
			else{
				System.out.println("Error: Your video exceeds maximum allowed duration of 10 minutes.");
			}
			
			
			
			
			}
	/**
	 * This function removing last post object.
	 */
	public void removePost(){
		System.out.println("-----------------------");
		System.out.println("Command: REMOVELASTPOST");
		if(this.postList.size()==0)	{
			System.out.println("You don't have any posts.");
		}
		else{
			this.postList.remove(postList.size()-1);
			System.out.println("Your last post has been successfully removed.");
		}
		
	}
		
}
	







