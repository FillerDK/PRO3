package opgaver;

public class Opg6 {

    public static void main(String[] args) {
        char[] belgiensFlag = {'G', 'R', 'S', 'G', 'G', 'R', 'S', 'R', 'G', 'G', 'R', 'S', 'G'};

        System.out.println(belgiensFlag);

        belgiensFlag(belgiensFlag);

        System.out.println(belgiensFlag);
    }

    // Belgiens flag

    public static void belgiensFlag(char[] belgiensFlag) {
        int s = 0;
        int g = belgiensFlag.length - 1;
        int r = belgiensFlag.length;
        while (s <= g) {
            if (belgiensFlag[s] == 'S') {
                s++;
            } else if (belgiensFlag[g] == 'G') {
                g--;
            } else if (belgiensFlag[g] == 'R') {
                r--;
                swap(belgiensFlag, g, r);
                g--;
            } else {
                swap(belgiensFlag, s, g);
                s++;
            }
        }
    }

    private static void swap(char[] belgiensFlag, int l, int h) {
        char temp = belgiensFlag[l];
        belgiensFlag[l] = belgiensFlag[h];
        belgiensFlag[h] = temp;
    }
}
