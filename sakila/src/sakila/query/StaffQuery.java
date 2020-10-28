package sakila.query;

public class StaffQuery {
	public final static String SELECT_STAFF_BY_KEY ="select email, store_id, username from staff where email =? and password = password(?)";
	public final static String SELEC_STAFF_BY_INFO ="select name, address, phone, city, country, username, picture from staff_list, staff where staff.staff_id = staff_list.ID and staff_id = ?";
}
