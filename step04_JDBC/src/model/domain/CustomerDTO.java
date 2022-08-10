/** ShoppingDTO

Database - shopping ,  tables - customers **/

/*
 * +--------------+-------------+------+-----+---------+-------+
| Field        | Type        | Null | Key | Default | Extra |
+--------------+-------------+------+-----+---------+-------+
| cust_id      | int         | NO   | PRI | NULL    |       |
| cust_name    | varchar(20) | NO   |     | NULL    |       |
| address      | varchar(40) | NO   |     | NULL    |       |
| postal_code  | varchar(10) | NO   |     | NULL    |       |
| cust_email   | varchar(30) | NO   |     | NULL    |       |
| phone_number | varchar(15) | YES  |     | NULL    |       |
| gender       | char(1)     | YES  |     | NULL    |       |
| join_date    | date        | NO   |     | NULL    |       |
+--------------+-------------+------+-----+---------+-------+
8 rows in set (0.02 sec)
 * */

package model.domain;


import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class CustomerDTO {
	private int cust_id;
	private String cust_name;
	private String address;
	private String postal_code;
	private String cust_email;
	private String phone_number;
	private char gender;
	private Date join_date;

}
