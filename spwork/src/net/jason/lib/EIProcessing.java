package net.jason.lib;

import net.jason.spring.Engineer;
import net.jason.spring.EngineerConsole;

public class EIProcessing implements EngineerConsole {

	private Engineer engineer;
	
	public EIProcessing(Engineer engineer) {
		this.engineer = engineer;
	}
	
	public EIProcessing() {}
	
	@Override
	public void print() {
		System.out.println("����ó����� ������ ������" + engineer.total() + "�� �̸� ��� ������" + engineer.avg() + "�Դϴ�.");
	}

	@Override
	public void setEngineer(Engineer engineer) {
		this.engineer = engineer;
	}

}
