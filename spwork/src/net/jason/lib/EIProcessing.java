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
		System.out.println("정보처리기사 시험의 총점은" + engineer.total() + "점 이며 평균 점수는" + engineer.avg() + "입니다.");
	}

	@Override
	public void setEngineer(Engineer engineer) {
		this.engineer = engineer;
	}

}
