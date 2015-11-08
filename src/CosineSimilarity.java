/**
 * Created by pmg on 2015/11/8.
 */
public class CosineSimilarity
{
    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: Cosine similarity.
     */
    public static double cosineSimilarity(int[] A, int[] B) {
        int A_abs = 0, B_abs = 0, AB = 0;
        for (int i = 0; i < A.length; i++) {
            A_abs += A[i] * A[i];
            B_abs += B[i] * B[i];
            AB += A[i] * B[i];
        }
        if (A_abs == 0 || B_abs == 0) return 2.0;
        else return ((double) AB) / (Math.sqrt(A_abs) * Math.sqrt(B_abs));
    }

    public static void main(String[] args)
    {
        int[] a = {1, 2, 3};
        int[] b = {2, 3, 4};
        System.out.println(cosineSimilarity(a, b));
    }
}
