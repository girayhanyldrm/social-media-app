import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 
 * @author girayhan
 *
 */

public class TextPost extends Post {
	
	static SimpleDateFormat simpleDateFormat= new SimpleDateFormat("dd/MM/yyyy");
	/**
	 * Text post constructor
	 * @param text text of post
	 * @param date date of post
	 * @param latitude latitude of post
	 * @param longitude	longitude of post
	 */
	public TextPost(String text,Date date,Double latitude, Double longitude){
		super(text,date,latitude,longitude);
	}
	
	public String toString(){
		String x="";
		x="------------------\n"+getText() +"\nDate: "+simpleDateFormat.format(getDate())+"\n"+showLocation()+"\n"+showTaggedUsers();
		return x;
	}

	@Override
	public String showLocation() {
		String d="";
		d="Location: " + location.getLatitude() + ", " + location.getLongitude();
		return d;
	}
	@Override
	public String showTaggedUsers() {
		
		String f="Friends tagged in this post: ";
		for(int i=0;i<tagList.size();i++){
			f+=tagList.get(i);
		}
		return f;
		
	}
}