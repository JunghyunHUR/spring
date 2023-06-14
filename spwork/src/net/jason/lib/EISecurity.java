package net.jason.lib;

import net.jason.spring.Engineer;
import net.jason.spring.EngineerConsole;

public class EISecurity implements EngineerConsole  {
	
	private Engineer engineer;
	
	public EISecurity(Engineer engineer) {
		this.engineer = engineer;
	}
	
	public EISecurity() {}

	@Override
	public void print() {
		System.out.println("�������ȱ�� ������ ������" + engineer.total() + "�� �̸� ��� ������" + engineer.avg() + "�Դϴ�.");
	}

	@Override
	public void setEngineer(Engineer engineer) {
		this.engineer = engineer;
		
	}
}
