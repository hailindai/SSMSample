package com.dreamguard.test;
/**
 * ����
 */
interface Worker{
	/**
	 * ���˸ɻ�
	 */
	public void work();
	
	/**
	 * ���˳Է�
	 */
	public void eat();
}
/**
 * ľ��
 */
class WoodWorker implements Worker{
	public void work(){
		System.out.println("ľ����ʼ�ɻ�");
	}

	@Override
	public void eat() {
		System.out.println("ľ����ʼ�Է�");
	}
}
/**
 * ��Ŀ����
 * ��̬����ģʽ
 * ��Ŀ��Ϊ���˵Ĵ����ù���רע�Լ������񣬴���һЩ����
 */
class Manager implements Worker{
	private Worker worker = new WoodWorker();//����һ��ľ��
	@Override
	public void work() {
		System.out.println("����ǰ��Ϊľ��׼����������");
		worker.work();
		System.out.println("����������˴�ɨ�ֳ�");
	}
	@Override
	public void eat() {
		System.out.println("�緹ǰ��Ϊľ��׼�����緹");
		worker.eat();
		System.out.println("�緹��Ϊľ�����߷�������");
	}
	

}

public class StaticProxy {
	public static void main(String[] args) {
		Worker worker = new Manager();
		worker.work();
		worker.eat();
	}
}
