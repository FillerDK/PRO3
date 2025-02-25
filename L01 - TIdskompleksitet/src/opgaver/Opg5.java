package opgaver;

import model.Nedboer;

public class Opg5 {
    /*
       Nedbørsberegning
       På Canvas finder du filen nedboer.zip
       I filen er der en klasse Nedboer, der indeholder et array over nedbørsmængden i
       ml per uge for år 2022.

       Programmer de tre metoder der er specificeret i klassen Nedboer.
         1. Find ugenummeret på den uge man skal starte ferie, hvis man ønsker
            mindst nedbør i de tre uger man holder ferie.
         2. Find ugenummeret på den uge man skal starte ferie, hvis man ønsker
            mindst nedbør og man med en parameter kan angive, hvor mange på
            hinanden følgende uger, man vil holde ferie.
         3. Find ugenummeret på den første uge i den periode hvor nedbøren har
            været præcis den samme flest uger i træk
            Hvad er størrelsesordenen af tidskompleksiteten for metoderne?
     */

    public static void main(String[] args) {
        model.Nedboer nedboer = new Nedboer();

        // Tidskompleksitet O(n)
        System.out.println("Bedste tre ferieuger start: " + nedboer.bedsteTreFerieUger());

        // Tidskompleksitet O(n)
        System.out.println("Bedste ferieuger start: " + nedboer.bedsteFerieUgerStart(3));

        // Tidskompleksitet O(n)
        System.out.println("Ens nedboer: " + nedboer.ensNedboer());
    }
}
