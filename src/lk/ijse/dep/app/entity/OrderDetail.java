package lk.ijse.dep.app.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class OrderDetail extends SuperEntity{
    @EmbeddedId
    private OrderDetailPK orderDetailPK;
    private int qty;
    private double unitPrice;

    @ManyToOne()
    @JoinColumn(name = "customerId",referencedColumnName = "id")
    private Customer customerId;

    @ManyToOne()
    @JoinColumn(name = "itemCode",referencedColumnName = "code")
    private Item itemCode;


    public OrderDetail() {
    }

    public OrderDetail(OrderDetailPK orderDetailPK, int qty, double unitPrice, Customer customerId, Item itemCode) {
        this.orderDetailPK = orderDetailPK;
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.customerId = customerId;
        this.itemCode = itemCode;
    }


    public OrderDetail(String cid,String code, int qty, double unitPrice, Customer customerId, Item itemCode) {
        this.orderDetailPK = new OrderDetailPK(cid,code);
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.customerId = customerId;
        this.itemCode = itemCode;
    }

    public OrderDetailPK getOrderDetailPK() {
        return orderDetailPK;
    }

    public void setOrderDetailPK(OrderDetailPK orderDetailPK) {
        this.orderDetailPK = orderDetailPK;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public Item getItemCode() {
        return itemCode;
    }

    public void setItemCode(Item itemCode) {
        this.itemCode = itemCode;
    }
}
