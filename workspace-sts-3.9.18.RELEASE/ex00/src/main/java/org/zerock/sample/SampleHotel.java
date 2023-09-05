package org.zerock.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

@Component
@Data
@AllArgsConstructor   // - > ������ ����
public class SampleHotel {
	
	// �ʵ� ����(@Autowired)  -> new �����ڸ� �̿����� �ʰ� Autowired�� �̿���
	// setter ���� -> set�޼ҵ忡 ��ü�� �Ѱܹ���
	// ������ ���� -> �����ڿ����� ��ü�� ������
	
	
//	@Setter(onMethod_ = {@Autowired}) - > �������Թ��
	private Restaurant restaurant;  
	
	
}
