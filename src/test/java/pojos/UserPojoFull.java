package pojos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;

@Data
public class UserPojoFull{
	private int id;
	@JsonProperty("last_name")
	private String lastName;
	private String avatar;
	@JsonProperty("first_name")
	private String firstName;
	private String email;


}
