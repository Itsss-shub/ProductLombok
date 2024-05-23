package com.validation.restapi.app.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	@NotEmpty
	@Size(min=3,max=20,message = "name should between 3 to 20 chars...!!!")
	private String userName;
	private String password;
	@Pattern(regexp = "[A-Z]{5}[0-9]{4}[A-Z]{1}$",message = "pancard details is not valid...!!!")
	private String userPan;
	@Pattern(regexp = "^[2-9][0-9]{3}\s[0-9]{4}\s[0-9]{4}$",message = "adhar card details is not valid...!!!")
	private String userAdhar;
	@NotEmpty
	@Email(message = "email is not valid...!!!")
	private String userEmail;
	@Pattern(regexp = "^[7-9]{1}[0-9]{9}",message = "phone number is not valid...!!!")
	private String userContact;
	
	
}
