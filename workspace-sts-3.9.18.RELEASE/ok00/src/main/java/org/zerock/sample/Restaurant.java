package org.zerock.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;
import lombok.ToString;

@Component
@ToString
@AllArgsConstructor  
public class Restaurant {

	Chef chef;
	
	
}
