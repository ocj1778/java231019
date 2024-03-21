package xyz.itwill08.mvc;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Member {
	private String id;
	private String name;
	private String address;
}
