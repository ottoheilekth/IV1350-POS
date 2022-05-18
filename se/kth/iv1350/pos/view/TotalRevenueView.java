package se.kth.iv1350.pos.view;

import se.kth.iv1350.pos.model.TotalRevenueObserver;

public class TotalRevenueView implements TotalRevenueObserver{
    private float totalRevenue;

    public TotalRevenueView() {
        totalRevenue = 0;
    }

    @Override
    public void UpdateTotalRevenue(float saleTotal) {
        totalRevenue += saleTotal;
        displayTotalRevenue();
    }

    private void displayTotalRevenue() {
        System.out.println("Total revenue since program start: " + totalRevenue + " KR");
    }
}
