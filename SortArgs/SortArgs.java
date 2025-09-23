import java.util.Arrays;

public class SortArgs {
    public static void sort(String[] args) {

        int[] convertArray = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            convertArray[i] = Integer.parseInt(args[i]);
        }
        Arrays.sort(convertArray);

        for (int i = 0; i < convertArray.length; i++) {
            System.out.print(convertArray[i]);
            if (i < convertArray.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}