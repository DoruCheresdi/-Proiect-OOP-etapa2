package utils;

import gifts.Gift;

public class GiftPair {
    private Gift gift;
    private int quantity;

    public GiftPair(final Gift gift, final int quantity) {
        this.gift = gift;
        this.quantity = quantity;
    }

    /**
     * getter
     * @return
     */
    public Gift getGift() {
        return gift;
    }

    /**
     * setter
     * @param gift
     */
    public void setGift(final Gift gift) {
        this.gift = gift;
    }

    /**
     * getter
     * @return
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * setter
     * @param quantity
     */
    public void setQuantity(final int quantity) {
        this.quantity = quantity;
    }
}
