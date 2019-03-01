import java.util.Date;
import java.util.UUID;
/**
 * 
 * @author girayhan
 *
 */
public interface PostInterface {
	
	public void setText(String text);
	
	public String getText();
	
	public UUID getPostID();
	
	public Date getDate();
}
