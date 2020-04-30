package com.upgrad.Grofers.service.entity;



import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * StoreEntity class contains all the attributes to be mapped to all the fields in Stores table in the database.
 * All the annotations which are used to specify all the constraints to the columns in the database must be correctly implemented.
 */
@Entity
@Table(name = "stores")
@NamedQueries({
		@NamedQuery(name = "storesByName", query = "select s from StoreEntity s where UPPER" +
				"(s.storeName) LIKE concat('%',UPPER(:storeName),'%') ORDER BY s.storeName ASC"),
		@NamedQuery(name = "storesByRating", query = "select s from StoreEntity s ORDER BY s.customerRating DESC"),
		@NamedQuery(name = "storesByUUID", query = "select s from StoreEntity s where s.uuid = :uuid"),
		@NamedQuery(name = "storesByCategory", query = "select distinct s FROM StoreEntity s " +
				"INNER JOIN s.categories c WHERE c.uuid = :uuid " +
				"ORDER BY s.storeName ASC")
})
public class StoreEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "UUID", length = 64, nullable = false)
	private String uuid;

	@Column(name = "store_name", nullable = false)
	private String storeName;

	@Column(name = "customer_rating", nullable = false)
	private Double customerRating;

	@Column(name = "number_of_customers_rated", nullable = false)
	private Integer numberCustomersRated;

	@OneToOne
	private AddressEntity address;

	@OneToMany
	@JoinTable(name = "store_item", joinColumns = @JoinColumn(name = "store_id"), inverseJoinColumns = @JoinColumn(name = "item_id"))
	private List<ItemEntity> items = new ArrayList<>();

	@ManyToMany
	@JoinTable(name = "store_category", joinColumns = @JoinColumn(name = "store_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
	private List<CategoryEntity> categories = new ArrayList<>();

	public StoreEntity() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public Double getCustomerRating() {
		return customerRating;
	}

	public void setCustomerRating(Double customerRating) {
		this.customerRating = customerRating;
	}

	public Integer getNumberCustomersRated() {
		return numberCustomersRated;
	}

	public void setNumberCustomersRated(Integer numberCustomersRated) {
		this.numberCustomersRated = numberCustomersRated;
	}

	public AddressEntity getAddress() {
		return address;
	}

	public void setAddress(AddressEntity address) {
		this.address = address;
	}

	public List<ItemEntity> getItems() {
		return items;
	}

	public void setItems(List<ItemEntity> items) {
		this.items = items;
	}

	public List<CategoryEntity> getCategories() {
		return categories;
	}

	public void setCategories(List<CategoryEntity> categories) {
		this.categories = categories;
	}
}
