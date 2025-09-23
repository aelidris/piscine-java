public class ComputeArray {
    public static int[] computeArray(int[] array) {
        int[] result = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            int rem = ((array[i] % 3) + 3) % 3;

            if (rem == 0) {
                result[i] = array[i] * 5;
            } else if (rem == 1) {
                result[i] = array[i] + 7;
            } else if (rem == 2) {
                result[i] = array[i];
            }
        }

        return result;
    }
}
