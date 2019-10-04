import java.util.Vector;
class Greedy
{
    //Changed denominations, 20 added
    static int deno[] = {1, 2, 5, 10, 20};
    static int n = deno.length;

    static Vector <Integer> findMin(int V)
    {
        // Initialize result
        Vector<Integer> ans = new Vector<>();


        for (int i = n - 1; i >= 0; i--)
        {
            // Find denominations
            while (V >= deno[i])
            {
                V -= deno[i];
                ans.add(deno[i]);
            }
        }
        return  ans;
        // Print result
        //for (int i = 0; i < ans.size(); i++)
        //{
        //  System.out.print(" " + ans.elementAt(i));
        //}
    }

}