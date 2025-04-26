package ex4;

public class App {
    public static void main(String[] args) {
        Bil bil = new Kuga();
        System.out.printf(bil.getBeskrivelse() +
                        """                        
                        Total pris: %,d kr

                        """, bil.pris());

        bil = new Læderindtræk(bil);
        System.out.printf(bil.getBeskrivelse() +
                """
                Total pris: %,d kr
                
                """, bil.pris());

        bil = new Bakkecensor(bil);
        System.out.printf(bil.getBeskrivelse() +
                """
                
                Total pris: %,d kr
                
                """, bil.pris());

        bil = new Metallak(bil);
        System.out.printf(bil.getBeskrivelse() +
                """
                
                Total pris: %,d kr
                
                """, bil.pris());
    }
}
