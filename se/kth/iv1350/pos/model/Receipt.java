package se.kth.iv1350.pos.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import se.kth.iv1350.pos.model.dto.SaleDTO;

/**
 * Represents one receipt, which proves the payment of one sale.
 */
public class Receipt {
    private SaleDTO saleDTO;
    private LocalTime saleTime;
    private float amountPaid;
    private float change;

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("----------------Receipt----------------\n");
        stringBuilder.append("Date: " + LocalDate.now() + '\t' + "Time: " + 
        saleTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")) + "\n\n");

        for (Item item : saleDTO.getItems()) {
            stringBuilder.append(item.getItemDTO().getName() + '\n');
            stringBuilder.append("\t" + item.getQuantity() + " x " + item.getItemDTO().getPrice() + 
                                "\t\t\t" + item.getItemDTO().getPrice() * item.getQuantity() + '\n');
        }

        stringBuilder.append("\nDiscount:\t\t\t" + Math.round(100 - saleDTO.getDiscountMultiplier() * 100) + 
                            "%\n");
        stringBuilder.append("Total (SEK):\t\t\t" + saleDTO.getTotalPrice() + '\n');
        stringBuilder.append("VAT (SEK):\t\t\t" + sumOfVAT() + '\n');
        stringBuilder.append("Amount paid (SEK):\t\t" + amountPaid + '\n');
        stringBuilder.append("Change (SEK):\t\t\t" + change + '\n');
        stringBuilder.append("------------End of receipt-------------");

        return stringBuilder.toString();
    }

    /**
     * Calculates the total VAT of the sale on this <code>Receipt</code>.
     * @return The total VAT of the sale.
     */
    private float sumOfVAT() {
        float totalVAT = 0;
        for (Item item : saleDTO.getItems())
            totalVAT += item.getItemDTO().getPrice() * item.getQuantity() * item.getItemDTO().getRateOfVat() / 100f;
        return Math.round((totalVAT * saleDTO.getDiscountMultiplier() * 100)) / 100f;
    }

    /**
     * Sets the DTO- and time of sale.
     * @param saleDTO Sale's DTO.
     * @param saleTime Time of sale.
     */
    public void setSale(SaleDTO saleDTO, LocalTime saleTime) {
        this.saleDTO = saleDTO;
        this.saleTime = saleTime;
    }

    /**
     * Sets the payment for the sale.
     * @param amount Amount payed by the customer.
     * @param change Amount returned to the customer.
     */
    public void setPayment(float amount, float change) {
        amountPaid = amount;
        this.change = change;
    }
}
