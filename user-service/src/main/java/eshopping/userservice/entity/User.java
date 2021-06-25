package eshopping.userservice.entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@EntityScan
@Document(collection ="user")
public class User {
	
	  @Id
	  private String id;
	  private String Name;
	  private String Password;
	  private int active;
	  
	  private UserDetails userDetails;

	  private UserRole role;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getUserName() {
			return Name;
		}

		public void setUserName(String Name) {
			this.Name = Name;
		}

		public String getUserPassword() {
			return Password;
		}

		public void setUserPassword(String Password) {
			this.Password = Password;
		}

		public int getActive() {
			return active;
		}

		public void setActive(int active) {
			this.active = active;
		}

		public UserDetails getUserDetails() {
			return userDetails;
		}

		public void setUserDetails(UserDetails userDetails) {
			this.userDetails = userDetails;
		}

		public UserRole getRole() {
			return role;
		}

		public void setRole(UserRole role) {
			this.role = role;
		}
	}
