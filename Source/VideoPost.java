import java.util.Date;

public class VideoPost extends TextPost {
	
	private String vfileName;
	private int maxVideoLength;
	/**
	 * 
	 * @return video file name
	 */
	public String getVfileName() {
		return vfileName;
	}
	public void setVfileName(String vfileName) {
		this.vfileName = vfileName;
	}
	/**
	 * 
	 * @return video length
	 */
	public int getMaxVideoLength() {
		return maxVideoLength;
	}
	public void setMaxVideoLength(int maxVideoLength) {
		this.maxVideoLength = maxVideoLength;
	}
	/**
	 * Video post constructor.
	 * @param text text of video
	 * @param date date of video
	 * @param latitude latitude of video
	 * @param longitude longitude of video
	 * @param vfileName file name of video
	 * @param maxVideoLenght of video
	 */
	public VideoPost(String text,Date date,Double latitude,Double longitude,String vfileName,int maxVideoLenght){
			super(text,date,latitude,longitude);
			this.vfileName=vfileName;
			this.maxVideoLength=maxVideoLenght;

	}
	public String toString(){
		String x="";
		x="------------------\n"+getText() +"\nDate: "+simpleDateFormat.format(getDate())+"\n"+showLocation()+"\nVideo: "+getVfileName()+"\nVideo Duration: "+getMaxVideoLength()+" minutes"+"\n"+showTaggedUsers();
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