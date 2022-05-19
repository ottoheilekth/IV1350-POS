package se.kth.iv1350.pos.view;

import se.kth.iv1350.pos.model.TotalRevenueObserver;

/**
 * This class observes the <code>Sale</sale> class and prints the total revenue earned since
 * the program start.
 */
public class TotalRevenueView implements TotalRevenueObserver{
    private float totalRevenue;

    /**
     * Creates a new instance.
     */
    public TotalRevenueView() {
        totalRevenue = 0;
    }


    /**
     * Updates and prints the total revenue earned so far.
     * @param saleTotal The total of the last ended sale.
     */
    @Override
    public void UpdateTotalRevenue(float saleTotal) {
        totalRevenue += saleTotal;
        System.out.println("Total revenue since program start: " + totalRevenue + " KR\n");
    }
}
