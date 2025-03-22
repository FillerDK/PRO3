package dictionary;

import afleveringsOpgave.DictionaryDoubleHashing;

public class DictionaryDemo {

	public static void main(String[] args) {
		// afleveringsOpgave.Dictionary<Integer, String> dictionary = new DictionaryHashMap<Integer, String>();
		// Dictionary<Integer, String> dictionary = new
		// DictionaryLinked<Integer, String>();
		/*
		System.out.println(dictionary.isEmpty());
		System.out.println(dictionary.size());

		dictionary.put(8, "hans");
		dictionary.put(3, "viggo");
		System.out.println(dictionary.isEmpty());
		System.out.println(dictionary.size());

		System.out.println(dictionary.get(8));

		dictionary.put(7, "bent");
		dictionary.put(2, "lene");
		System.out.println(dictionary.isEmpty());
		System.out.println(dictionary.size());
		System.out.println(dictionary.remove(3));

		System.out.println(dictionary.size());

		System.out.println(dictionary.put(8, "Ida"));
		System.out.println(dictionary.get(8));
		 */
		System.out.println("----------------------------------------------------");
		DictionaryDoubleHashing<Integer, String> dic = new DictionaryDoubleHashing<>();
		dic.put(4371,"A");
		dic.writeOut();
		System.out.println("------------------------------");
		dic.put(1323,"B");
		dic.writeOut();
		System.out.println("------------------------------");
		dic.put(6173,"C");
		dic.writeOut();
		System.out.println("------------------------------");
		dic.put(4199,"D");
		dic.writeOut();
		System.out.println("------------------------------");
		dic.put(4344,"E");
		dic.writeOut();
		System.out.println("------------------------------");
		dic.put(9679,"F");
		dic.writeOut();
		System.out.println("------------------------------");
		dic.put(1989,"G");
		dic.writeOut();
		System.out.println("------------------------------");

		System.out.println("Forventet 7 " +dic.size());
		System.out.println("Remove 4199");
		dic.remove(4199);
		System.out.println("Forventet: null "+ dic.get(4199));
		System.out.println("Forventet: G " +dic.get(1989));
		System.out.println("Forventet 6 " +dic.size());
		System.out.println("Forventet G "+ dic.put(1989,"MAD"));
		System.out.println("Forventet 6 " + dic.size());
		System.out.println("Forventet MAD "+dic.get(1989));

		System.out.println("Forventet B " + dic.put(1323,"MAD2"));
		System.out.println("Forventet 6 " + dic.size());
		System.out.println("Forventet MAD2 "+dic.get(1323));

		dic.writeOut();
		System.out.println("------------------------------");
		dic.put(1,"MAD3");

	}
}
