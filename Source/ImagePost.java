import java.util.Date;

public class ImagePost extends TextPost{


	private String ifileName;
	private String imageResolution;
	
	/**
	 * 
	 * @return image file name
	 */
	public String getIfileName() {
		return ifileName;
	}
	public void setIfileName(String ifileName) {
		this.ifileName = ifileName;
	}
	/**
	 * 
	 * @return resolution of image
	 */
	public String getImageResolution() {
		return imageResolution;
	}
	public void setImageResolution(String imageResolution) {
		this.imageResolution = imageResolution;
	}
	
	/**
	 * Image post constructor.
	 * @param text text of image
	 * @param date date of image
	 * @param latitude latitude of image
	 * @param longitude longitude of image
	 * @param ifileName file name of image
	 * @param imageResolution resolution of image
	 */
	public ImagePost(String text,Date date,Double latitude,Double longitude,String ifileName,String imageResolution){
		super(text,date,latitude,longitude);
		this.ifileName=ifileName;
		this.imageResolution=imageResolution;
	}


	public String toString(){
		String x="";
		x="------------------\n"+getText() +"\nDate: "+simpleDateFormat.format(getDate())+"\n"+showLocation()+"\nImage: "+getIfileName()+"\nImage resolution: "+getImageResolution()+"\n"+showTaggedUsers();
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
		String f="";
		f="Friends tagged in this post: "+tagList;
		return f;
		
	}


















}
