package com.odapps.safarirg.classes;

public class StandardListItem {

	private int itemId;
	private String itemName, itemDes, imagePath;

	public StandardListItem(int itemId, String itemName, String itemDes, String imagePath) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemDes = itemDes;
		this.imagePath = imagePath;
	}

	public int getItemId() {
		return itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public String getItemDes() {
		return itemDes;
	}

	public String getImagePath() {
		return imagePath;
	}

}
