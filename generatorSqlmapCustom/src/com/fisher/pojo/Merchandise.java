package com.fisher.pojo;

public class Merchandise {
    private Integer merchandiseId;

    private Integer imageId;

    private Integer describeId;

    private Integer commentId;

    private String merchandiseName;

    private Double merchandisePrice;

    private String merchandiseAttribute;

    private String merchandisePricescope;

    private Integer merchandiseInventory;

    public Integer getMerchandiseId() {
        return merchandiseId;
    }

    public void setMerchandiseId(Integer merchandiseId) {
        this.merchandiseId = merchandiseId;
    }

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public Integer getDescribeId() {
        return describeId;
    }

    public void setDescribeId(Integer describeId) {
        this.describeId = describeId;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getMerchandiseName() {
        return merchandiseName;
    }

    public void setMerchandiseName(String merchandiseName) {
        this.merchandiseName = merchandiseName == null ? null : merchandiseName.trim();
    }

    public Double getMerchandisePrice() {
        return merchandisePrice;
    }

    public void setMerchandisePrice(Double merchandisePrice) {
        this.merchandisePrice = merchandisePrice;
    }

    public String getMerchandiseAttribute() {
        return merchandiseAttribute;
    }

    public void setMerchandiseAttribute(String merchandiseAttribute) {
        this.merchandiseAttribute = merchandiseAttribute == null ? null : merchandiseAttribute.trim();
    }

    public String getMerchandisePricescope() {
        return merchandisePricescope;
    }

    public void setMerchandisePricescope(String merchandisePricescope) {
        this.merchandisePricescope = merchandisePricescope == null ? null : merchandisePricescope.trim();
    }

    public Integer getMerchandiseInventory() {
        return merchandiseInventory;
    }

    public void setMerchandiseInventory(Integer merchandiseInventory) {
        this.merchandiseInventory = merchandiseInventory;
    }
}