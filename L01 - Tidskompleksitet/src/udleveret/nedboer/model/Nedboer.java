package model;

public class Nedboer {
    private int[] nedboerPrUge = { 20, 10, 12, 12, 13, 14, 15, 10, 8, 7, 13,
        15, 10, 9, 6, 8, 12, 22, 14, 16, 16, 18, 23, 12, 0, 2, 0, 0, 78, 0,
        0, 0, 34, 12, 34, 23, 23, 12, 44, 23, 12, 34, 22, 22, 22, 22, 18,
        19, 21, 32, 24, 13 };
    
    /**
     * Returnerer ugenummeret for den uge i året, hvor man skal starte ferien,
     * hvis man ønsker den minimale nedbørsmængde i de tre uger
     *
     * @return
     */
    
    public int bedsteTreFerieUger() {
        int bedste = nedboerPrUge[0] + nedboerPrUge[1] + nedboerPrUge[2];
        int bedsteUge = 1;

        for (int i = 1; i < nedboerPrUge.length - 2; i++) {
            int ny = 0;
            ny = nedboerPrUge[i] + nedboerPrUge[i+1] + nedboerPrUge[i+2];

            if (ny < bedste) {
                bedste = ny;
                bedsteUge = i + 1;
            }
        }

        return bedsteUge;
    }
    
    /**
     * Returnerer ugenummeret for den uge i året, hvor man skal starte ferien,
     * hvis man ønsker den minimale nedbørsmængde i det "antal" uger, der er
     * angivet i paramtereren
     *
     * @return
     */
    
    public int bedsteFerieUgerStart(int antal) {
        int bedste = 0;
        for (int i = 0; i < antal; i++) {
            bedste += nedboerPrUge[i];
        }
        int bedsteUge = 1;

        for (int i = 1; i < nedboerPrUge.length - antal; i++) {
            int ny = 0;
            for (int j = 0; j < antal; j++) {
                ny += nedboerPrUge[i+j];
            }

            if (ny < bedste) {
                bedste = ny;
                bedsteUge = i + 1;
            }
        }

        return bedsteUge;
    }
    
    /**
     * Returnerer ugenummeret på den første uge hvor nedbøren har været præcis
     * den samme flest uger i træk
     *
     * @return
     */
    public int ensNedboer() {
        int førsteUge = -1;
        int flestITræk = 0;
        
        for (int i = 0; i < nedboerPrUge.length - 1; i++) {
            if (nedboerPrUge[i] == nedboerPrUge[i + 1]) {
                int iTræk = 2;
                boolean match = true;
                for (int j = i + 1; match && j < nedboerPrUge.length - 1; j++) {
                    if (nedboerPrUge[j] == nedboerPrUge[j + 1]) {
                        iTræk++;
                    } else {
                        match = false;
                    }
                }
                if (iTræk > flestITræk) {
                    flestITræk = iTræk;
                    førsteUge = i;
                }
                i += iTræk;
            }
        }
        return førsteUge + 1;
    }
}
