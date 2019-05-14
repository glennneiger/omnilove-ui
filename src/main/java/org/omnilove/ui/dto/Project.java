package org.omnilove.service.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Project {
	private Long id;
	private Date creationDate;
	private String name;
	private User creator;
	private List<User> participants;
}
