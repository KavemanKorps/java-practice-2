/** 
 * Sets up the puzzle with the specified number of disks
 * 
 * @param disks the number of disks
*/

public class TowersOfHanoi
{
    private int totalDisks;

    /**
     * Sets up the puzzle with the specified number of disks
     * 
     * @param disks the number of disks
     */
}
public class SolveTowers
{
    public TowersOfHanoi(int disks)
    {
        totalDisks = disks;
    }

    public void solve()
    {
        moveTower(totalDisks, 1, 3, 2);
    }

    private void moveTower(int numDisks, int start, int end, int temp)
    {
        if (numDisks == 1)
            moveOneDisk(start, end);
        else
        {
            moveTower(numDisks-1, start, temp, end);
            moveOneDisk(start, end);
            moveTower(numDisks-1, temp, end, start);
        }
    }
}
