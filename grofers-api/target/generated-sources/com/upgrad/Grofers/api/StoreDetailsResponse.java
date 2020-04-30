package com.upgrad.Grofers.api;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.upgrad.Grofers.api.CategoryList;
import com.upgrad.Grofers.api.StoreDetailsResponseAddress;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Store details
 */
@ApiModel(description = "Store details")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-04-22T14:31:57.116+05:30")

public class StoreDetailsResponse   {
  @JsonProperty("id")
  private UUID id = null;

  @JsonProperty("Store_name")
  private String storeName = null;

  @JsonProperty("customer_rating")
  private BigDecimal customerRating = null;

  @JsonProperty("number_customers_rated")
  private Integer numberCustomersRated = null;

  @JsonProperty("address")
  private StoreDetailsResponseAddress address = null;

  @JsonProperty("categories")
  @Valid
  private List<CategoryList> categories = null;

  public StoreDetailsResponse id(UUID id) {
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

  public StoreDetailsResponse storeName(String storeName) {
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

  public StoreDetailsResponse customerRating(BigDecimal customerRating) {
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

  public StoreDetailsResponse numberCustomersRated(Integer numberCustomersRated) {
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

  public StoreDetailsResponse address(StoreDetailsResponseAddress address) {
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

  public StoreDetailsResponse categories(List<CategoryList> categories) {
    this.categories = categories;
    return this;
  }

  public StoreDetailsResponse addCategoriesItem(CategoryList categoriesItem) {
    if (this.categories == null) {
      this.categories = new ArrayList<>();
    }
    this.categories.add(categoriesItem);
    return this;
  }

  /**
   * List of categories
   * @return categories
  **/
  @ApiModelProperty(value = "List of categories")

  @Valid

  public List<CategoryList> getCategories() {
    return categories;
  }

  public void setCategories(List<CategoryList> categories) {
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
    StoreDetailsResponse storeDetailsResponse = (StoreDetailsResponse) o;
    return Objects.equals(this.id, storeDetailsResponse.id) &&
        Objects.equals(this.storeName, storeDetailsResponse.storeName) &&
        Objects.equals(this.customerRating, storeDetailsResponse.customerRating) &&
        Objects.equals(this.numberCustomersRated, storeDetailsResponse.numberCustomersRated) &&
        Objects.equals(this.address, storeDetailsResponse.address) &&
        Objects.equals(this.categories, storeDetailsResponse.categories);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, storeName, customerRating, numberCustomersRated, address, categories);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StoreDetailsResponse {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    storeName: ").append(toIndentedString(storeName)).append("\n");
    sb.append("    customerRating: ").append(toIndentedString(customerRating)).append("\n");
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

