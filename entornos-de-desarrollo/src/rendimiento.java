
public class rendimiento {

	public static void main(String[] args) {
	// TODO Auto-generated method stub

		long startTime = System.currentTimeMillis();

		long total = 0;
		for (int i = 0; i < 10000000; i++) {
			total += i;
		}

		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		System.out.println(elapsedTime);
	}

}
