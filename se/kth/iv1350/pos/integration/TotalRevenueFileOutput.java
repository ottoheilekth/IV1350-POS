package se.kth.iv1350.pos.integration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import se.kth.iv1350.pos.model.TotalRevenueObserver;

public class TotalRevenueFileOutput implements TotalRevenueObserver {
    private float totalRevenue;
    private PrintWriter totalRevenueLogger;

    public TotalRevenueFileOutput() {
        totalRevenue = 0;

        try {
            File file = new File("./logs/total_revenue_logs/" + LocalDate.now() + '_' +
                                LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")) + ".txt");
            file.getParentFile().mkdirs();
            totalRevenueLogger = new PrintWriter(new FileWriter(file, true), true);
        }
        catch (IOException e) {
            System.out.println("Logging the total revenue for this session is not possible due to an error");
            e.printStackTrace();
        }
    }

    public void UpdateTotalRevenue(float saleTotal) {
        totalRevenue += saleTotal;
        totalRevenueLogger.println("[" + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")) +
                                    "] " + totalRevenue + " KR");
    }
}
