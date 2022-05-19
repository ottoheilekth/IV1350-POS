package se.kth.iv1350.pos.model;

/**
 * Defines the ability to observe the <code>Sale</code> class. The interface is to be implemented by
 * a class that handles total revenue and needs to update it based on the <code>Sale</code> class.
 */
public interface TotalRevenueObserver {
    /**
     * Updates the stored total revenue and performes some kind of printout or logging.
     * @param saleTotal The total of the finished sale.
     */
    void UpdateTotalRevenue(float saleTotal);
}
