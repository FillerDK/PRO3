package aflveringsOpgave;

import afleveringsOpgave.DictionaryDoubleHashing;

public class Test {
    public static void main(String[] args) {
        DictionaryDoubleHashing<Integer, String> dictionary = new DictionaryDoubleHashing<Integer, String>();

        System.out.println(dictionary.isEmpty());
		System.out.println(dictionary.size());

		dictionary.put(8, "hans");
		dictionary.put(3, "viggo");
		dictionary.put(1, "bente");
		dictionary.put(18, "jørgen");
		dictionary.writeOut();
		System.out.println(dictionary.isEmpty());
		System.out.println(dictionary.size());

		System.out.println(dictionary.get(8));

		System.out.println(dictionary.remove(3));
		dictionary.put(7, "bent");
		dictionary.put(2, "lene");
		dictionary.put(10, "sanne");
		System.out.println(dictionary.isEmpty());
		System.out.println(dictionary.size());

		System.out.println(dictionary.size());

		System.out.println(dictionary.put(8, "Ida"));
		System.out.println(dictionary.get(8));
		System.out.println(dictionary.size());
		dictionary.writeOut();
    }
}
