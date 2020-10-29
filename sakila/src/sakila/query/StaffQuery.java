package sakila.query;

public class StaffQuery {
	public final static String SELECT_STAFF_BY_KEY ="select staff_id, email, store_id, username from staff where email =? and password = password(?)";
	public final static String SELEC_STAFF_BY_INFO ="select staff_id, name, address, phone, city, country, username, email, picture from staff_list, staff where staff.staff_id = staff_list.ID and staff_id = ?";
}
