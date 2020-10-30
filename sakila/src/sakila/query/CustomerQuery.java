package sakila.query;

public class CustomerQuery {
	public final static String SELECT_CUSTOMER_LIST ="select id, name, phone, if(notes = 'active', _utf8mb4'o',_utf8mb4'x') AS 활성여부, if(return_date,_utf8mb4'x',_utf8mb4'o')AS 연체여부  from customer_list, rental where rental.customer_id = customer_list.ID GROUP BY NAME limit(?,?)";
}
