import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {
	
	public static User Login() {
		for(User abc:UserCollection.userlist){
			if (abc.signIn == true)
			{
				return abc;
			}
		}
	return null;
	}
	public static void main(String[] args) throws FileNotFoundException, ParseException{
	SimpleDateFormat date = new SimpleDateFormat("MM/dd/yyyy");
	Scanner scannerUser = new Scanner(new File(args[0]));	
	String data;
	while(scannerUser.hasNextLine()){
		data=scannerUser.nextLine();
		String[] params=data.split("	");
		UserCollection.userlist.add(new User(params[0],params[1],params[2],date.parse((params[3])),params[4]));
	}
	
	scannerUser.close();
	Scanner scannerCommand= new Scanner(new File(args[1]));	
	String data2;
	while(scannerCommand.hasNextLine()){
		data2=scannerCommand.nextLine();
		String[] params=data2.split("	");
		switch(params[0]){
		
		case"ADDUSER":
			System.out.println("---------------------------------------");
			System.out.println("Command: "+params[0]+"	");
			UserCollection.addUser(params[1],params[2],params[3],date.parse(params[4]),params[5]);
			break;
		case"REMOVEUSER":
            System.out.println("---------------------------------------");
			System.out.println("Command: "+params[0]+"	"+params[1]);               
			if(UserCollection.removeUser(Integer.parseInt((params[1])))){       
				System.out.println("User has been successfully removed.");
			}
			else{
				System.out.println("No such user!");
			}
			break;
			
		case"SIGNIN":
			System.out.println("---------------------------------------");
			System.out.println("Command: "+params[0]+"	" + params[1] + "	" + params[2]); 
			UserCollection.userSignin(params[1], params[2]);
			if(UserCollection.userSignin(params[1], params[2]).equals("dogru")){
				System.out.println("You have successfully signed in.");
			}
			if(UserCollection.userSignin(params[1], params[2]).equals("ysifre")){
				System.out.println("Invalid username or password! Please try again.");
			}
			if(UserCollection.userSignin(params[1], params[2]).equals("yname")){
				System.out.println("No such user!");
			}
			break;
		case"SIGNOUT":
			System.out.println("---------------------------------------");
			System.out.println("Command: "+params[0]+"	");              
			for(User abc:UserCollection.userlist){
			if(abc.signIn==true){
				abc.signOut();
				System.out.println("You have successfully signed out.");
			}
			}
			break;
			
		case"UPDATEPROFILE":
			System.out.println("---------------------------------------"); 
			System.out.print("Command: "+params[0]+"	");         
			if(Login()!=null){
			Login().updateProfile(params[1], date.parse(params[2]), params[3]);
			}
			else{System.out.println("Error: Please sign in and try again.");}
			break;
		case"CHPASS": 
			if(Login()!=null){
				Login().changePass(params[1], params[2]);
			}
			else{System.out.println("Error: Please sign in and try again.");}
				break;
		case"ADDFRIEND":
			if(Login()!=null){
			Login().addFriend(params[1]);
			}
			else{System.out.println("Error: Please sign in and try again.");}

			break;
		case"REMOVEFRIEND":
			if(Login()!=null){     
			Login().removeFriend(params[1]);
			}
			else{System.out.println("Error: Please sign in and try again.");}
			break;
			
		case"LISTUSERS":
			if(Login()!=null){     
			Login().listUsers();
			}
			else{System.out.println("Error: Please sign in and try again.");}
			break;
			
		case"LISTFRIENDS":
			if(Login()!=null){     
			Login().listFriends();
			}
			else{System.out.println("Error: Please sign in and try again.");}
			break;
		
		case"BLOCK":
			if(Login()!=null){     
			Login().block(params[1]);
			}
			else{System.out.println("Error: Please sign in and try again.");}
			break;
		
		case"UNBLOCK":
			if(Login()!=null){     
			Login().unBlock(params[1]);
			}
			else{System.out.println("Error: Please sign in and try again.");}
			break;
		
		case"SHOWBLOCKEDUSERS":
			if(Login()!=null){     
			Login().showBlockUsers();
			}
			else{System.out.println("Error: Please sign in and try again.");}
			break;

		case"SHOWBLOCKEDFRIENDS":
			if(Login()!=null){     
			Login().showBlockFriends();
			}
			else{System.out.println("Error: Please sign in and try again.");}
			break;
		case"ADDPOST-TEXT":
			if(Login()!=null){     	
			Login().addText(params[1],Double.parseDouble(params[2]),Double.parseDouble(params[3]),params[4]);
			}
			else{System.out.println("Error: Please sign in and try again.");}

			break;
		case"ADDPOST-IMAGE":
			if(Login()!=null){     	
			Login().addImage(params[1],Double.parseDouble(params[2]),Double.parseDouble(params[3]),params[4],params[5],params[6]);
			}
			else{System.out.println("Error: Please sign in and try again.");}
			break;
		case"ADDPOST-VIDEO":
			if(Login()!=null){     	
			Login().addVideo(params[1],Double.parseDouble(params[2]),Double.parseDouble(params[3]),params[4],params[5],Integer.parseInt(params[6]));
			}
			else{System.out.println("Error: Please sign in and try again.");}
			break;
		case"SHOWPOSTS":
			if(Login()!=null){     	
				UserCollection.showPosts(params[1]);
			}
			else{System.out.println("Error: Please sign in and try again.");}
			break;
		case"REMOVELASTPOST":
			if(Login()!=null){     	
				Login().removePost();
			}
			else{System.out.println("Error: Please sign in and try again.");}
			break;
		
		
		
		
		
		}
	
	}
	scannerCommand.close();
}

}
