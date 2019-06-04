package com.dreamguard.test;
/**
 * 工人
 */
interface Worker{
	/**
	 * 工人干活
	 */
	public void work();
	
	/**
	 * 工人吃饭
	 */
	public void eat();
}
/**
 * 木工
 */
class WoodWorker implements Worker{
	public void work(){
		System.out.println("木工开始干活");
	}

	@Override
	public void eat() {
		System.out.println("木工开始吃饭");
	}
}
/**
 * 项目经理
 * 静态代理模式
 * 项目作为工人的代理，让工人专注自己的任务，处理一些杂务。
 */
class Manager implements Worker{
	private Worker worker = new WoodWorker();//管理一个木工
	@Override
	public void work() {
		System.out.println("工作前，为木工准备工作材料");
		worker.work();
		System.out.println("工作完后，找人打扫现场");
	}
	@Override
	public void eat() {
		System.out.println("午饭前，为木工准备好午饭");
		worker.eat();
		System.out.println("午饭后，为木工带走饭后垃圾");
	}
	

}

public class StaticProxy {
	public static void main(String[] args) {
		Worker worker = new Manager();
		worker.work();
		worker.eat();
	}
}
