package com.main;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName="prototype")
public class Student {
private String name="Serxan";

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

}
