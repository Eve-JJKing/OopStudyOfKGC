package com.day001.exercise01;
/**
 * ≤‚ ‘People¿‡
 * @author Administrator
 *
 */
public class TestPeople {
	public static void main(String[] args) {
		People people = new People();
		people.name = "jj";
		people.height = 172;
		people.weight = 65;
		people.sing();
		people.dance();
		System.out.println(people.name + people.height + people.weight);
	}
}
