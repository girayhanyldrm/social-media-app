
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
/**
 * 
 * @author girayhan
 *
 */
public abstract class Post implements PostInterface{

	
	private UUID postID;
	private String text;
	private Date date;
	public Location location;
	ArrayList<String> tagList=new ArrayList<String>();
	
	public UUID getPostID() {
		return postID;
	}
	public void setPostID(UUID postID) {
		this.postID = postID;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * This post constructor.
	 * @param text text of post
	 * @param date date of post
	 * @param latitude latitude of post
	 * @param longitude longitude of post
	 */
	public Post(String text,Date date, Double latitude, Double longitude){
		
		this.text=text;
		this.date=date;
		this.location = new Location(latitude, longitude);
		setPostID(UUID.randomUUID());
	}
	
	public abstract String showLocation();
	public abstract String showTaggedUsers();
	
	
	
}
