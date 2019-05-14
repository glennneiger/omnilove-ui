package org.omnilove.ui.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class User {
	private Long id;
	private String username;
	private String surname;
	private String firstname;
	private String email;
	private String password;
	private Date birthday;
	private List<Project> projects;
	private String motivation;
	private List<Skill> skills;
}
