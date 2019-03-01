/**
 * 
 * @author girayhan
 *
 */
public class Location {
	private double latitude;
	private double longitude;
	
	/**
	 * @return latitude
	 */
	public double getLatitude() {
		return latitude;
	}
	/**
	 * @param  latitude set latitude
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	/**
	 * @return longitude
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude set longitude
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	/**
	 * @param latitude latitude
	 * @param longitude longitude
	 */
	public Location(double latitude, double longitude) {
		this.setLatitude(latitude);
		this.setLongitude(longitude);
	}
}
