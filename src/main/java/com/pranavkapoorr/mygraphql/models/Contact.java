package com.pranavkapoorr.mygraphql.models;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter @Getter
public class Contact {
	private String id;
	private String name;
	private String address;
}
