package org.zerock.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

@Component
@Data
@AllArgsConstructor   // - > 생성자 주입
public class SampleHotel {
	
	// 필드 주입(@Autowired)  -> new 연산자를 이용하지 않고 Autowired를 이용함
	// setter 주입 -> set메소드에 객체를 넘겨받음
	// 생성자 주입 -> 생성자에서도 객체를 주입함
	
	
//	@Setter(onMethod_ = {@Autowired}) - > 셋터주입방법
	private Restaurant restaurant;  
	
	
}
