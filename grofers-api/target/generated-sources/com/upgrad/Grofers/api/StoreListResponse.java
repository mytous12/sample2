package com.upgrad.Grofers.api;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.upgrad.Grofers.api.StoreList;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * StoreListResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-04-22T14:31:57.116+05:30")

public class StoreListResponse   {
  @JsonProperty("Stores")
  @Valid
  private List<StoreList> stores = null;

  public StoreListResponse stores(List<StoreList> stores) {
    this.stores = stores;
    return this;
  }

  public StoreListResponse addStoresItem(StoreList storesItem) {
    if (this.stores == null) {
      this.stores = new ArrayList<>();
    }
    this.stores.add(storesItem);
    return this;
  }

  /**
   * List of Stores
   * @return stores
  **/
  @ApiModelProperty(value = "List of Stores")

  @Valid

  public List<StoreList> getStores() {
    return stores;
  }

  public void setStores(List<StoreList> stores) {
    this.stores = stores;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StoreListResponse storeListResponse = (StoreListResponse) o;
    return Objects.equals(this.stores, storeListResponse.stores);
  }

  @Override
  public int hashCode() {
    return Objects.hash(stores);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StoreListResponse {\n");
    
    sb.append("    stores: ").append(toIndentedString(stores)).append("\n");
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

