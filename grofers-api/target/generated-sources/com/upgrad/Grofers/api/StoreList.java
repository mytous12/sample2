package com.upgrad.Grofers.api;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.upgrad.Grofers.api.StoreDetailsResponseAddress;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.UUID;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * StoreList
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-04-22T14:31:57.116+05:30")

public class StoreList   {
  @JsonProperty("id")
  private UUID id = null;

  @JsonProperty("Store_name")
  private String storeName = null;

  @JsonProperty("photo_URL")
  private String photoURL = null;

  @JsonProperty("customer_rating")
  private BigDecimal customerRating = null;

  @JsonProperty("average_price")
  private Integer averagePrice = null;

  @JsonProperty("number_customers_rated")
  private Integer numberCustomersRated = null;

  @JsonProperty("address")
  private StoreDetailsResponseAddress address = null;

  @JsonProperty("categories")
  private String categories = null;

  public StoreList id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of the Store in a standard UUID format
   * @return id
  **/
  @ApiModelProperty(value = "Unique identifier of the Store in a standard UUID format")

  @Valid

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public StoreList storeName(String storeName) {
    this.storeName = storeName;
    return this;
  }

  /**
   * Name of the Store
   * @return storeName
  **/
  @ApiModelProperty(value = "Name of the Store")


  public String getStoreName() {
    return storeName;
  }

  public void setStoreName(String storeName) {
    this.storeName = storeName;
  }

  public StoreList photoURL(String photoURL) {
    this.photoURL = photoURL;
    return this;
  }

  /**
   * URL for the picture of the Store
   * @return photoURL
  **/
  @ApiModelProperty(value = "URL for the picture of the Store")


  public String getPhotoURL() {
    return photoURL;
  }

  public void setPhotoURL(String photoURL) {
    this.photoURL = photoURL;
  }

  public StoreList customerRating(BigDecimal customerRating) {
    this.customerRating = customerRating;
    return this;
  }

  /**
   * Rating of the Store
   * @return customerRating
  **/
  @ApiModelProperty(value = "Rating of the Store")

  @Valid

  public BigDecimal getCustomerRating() {
    return customerRating;
  }

  public void setCustomerRating(BigDecimal customerRating) {
    this.customerRating = customerRating;
  }

  public StoreList averagePrice(Integer averagePrice) {
    this.averagePrice = averagePrice;
    return this;
  }

  /**
   * Average price for two people
   * @return averagePrice
  **/
  @ApiModelProperty(value = "Average price for two people")


  public Integer getAveragePrice() {
    return averagePrice;
  }

  public void setAveragePrice(Integer averagePrice) {
    this.averagePrice = averagePrice;
  }

  public StoreList numberCustomersRated(Integer numberCustomersRated) {
    this.numberCustomersRated = numberCustomersRated;
    return this;
  }

  /**
   * Number of customers rated the Store
   * @return numberCustomersRated
  **/
  @ApiModelProperty(value = "Number of customers rated the Store")


  public Integer getNumberCustomersRated() {
    return numberCustomersRated;
  }

  public void setNumberCustomersRated(Integer numberCustomersRated) {
    this.numberCustomersRated = numberCustomersRated;
  }

  public StoreList address(StoreDetailsResponseAddress address) {
    this.address = address;
    return this;
  }

  /**
   * Get address
   * @return address
  **/
  @ApiModelProperty(value = "")

  @Valid

  public StoreDetailsResponseAddress getAddress() {
    return address;
  }

  public void setAddress(StoreDetailsResponseAddress address) {
    this.address = address;
  }

  public StoreList categories(String categories) {
    this.categories = categories;
    return this;
  }

  /**
   * List of categories
   * @return categories
  **/
  @ApiModelProperty(value = "List of categories")


  public String getCategories() {
    return categories;
  }

  public void setCategories(String categories) {
    this.categories = categories;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StoreList storeList = (StoreList) o;
    return Objects.equals(this.id, storeList.id) &&
        Objects.equals(this.storeName, storeList.storeName) &&
        Objects.equals(this.photoURL, storeList.photoURL) &&
        Objects.equals(this.customerRating, storeList.customerRating) &&
        Objects.equals(this.averagePrice, storeList.averagePrice) &&
        Objects.equals(this.numberCustomersRated, storeList.numberCustomersRated) &&
        Objects.equals(this.address, storeList.address) &&
        Objects.equals(this.categories, storeList.categories);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, storeName, photoURL, customerRating, averagePrice, numberCustomersRated, address, categories);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StoreList {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    storeName: ").append(toIndentedString(storeName)).append("\n");
    sb.append("    photoURL: ").append(toIndentedString(photoURL)).append("\n");
    sb.append("    customerRating: ").append(toIndentedString(customerRating)).append("\n");
    sb.append("    averagePrice: ").append(toIndentedString(averagePrice)).append("\n");
    sb.append("    numberCustomersRated: ").append(toIndentedString(numberCustomersRated)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    categories: ").append(toIndentedString(categories)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

