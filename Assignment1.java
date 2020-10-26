package inc.nitya;

public class Assignment1 {

	public Assignment1() {
	}

	public static void main(String[] args) {
		A a = new A();
		C c = new C();
		a.b.c = c.b.a; // the given statement.
	}
}

class A {
	B b = new B();
}

class B {
	int a, c;
}

class C {
	B b = new B();
}
