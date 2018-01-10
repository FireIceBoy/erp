package cn.whsxt.car.pojo;

import java.math.BigDecimal;

public class Car {
    private String carnumber;

    private String cartype;

    private String color;

    private BigDecimal price;

    private BigDecimal rentprice;

    private BigDecimal deposit;

    private String isrenting;

    private String carimg;

    private String cardesc;

    public String getCarnumber() {
        return carnumber;
    }

    public void setCarnumber(String carnumber) {
        this.carnumber = carnumber == null ? null : carnumber.trim();
    }

    public String getCartype() {
        return cartype;
    }

    public void setCartype(String cartype) {
        this.cartype = cartype == null ? null : cartype.trim();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getRentprice() {
        return rentprice;
    }

    public void setRentprice(BigDecimal rentprice) {
        this.rentprice = rentprice;
    }

    public BigDecimal getDeposit() {
        return deposit;
    }

    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    public String getIsrenting() {
        return isrenting;
    }

    public void setIsrenting(String isrenting) {
        this.isrenting = isrenting == null ? null : isrenting.trim();
    }

    public String getCarimg() {
        return carimg;
    }

    public void setCarimg(String carimg) {
        this.carimg = carimg == null ? null : carimg.trim();
    }

    public String getCardesc() {
        return cardesc;
    }

    public void setCardesc(String cardesc) {
        this.cardesc = cardesc == null ? null : cardesc.trim();
    }
}