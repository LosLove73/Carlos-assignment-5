package com.coderscampus.arraylist;

import java.util.Arrays;

public class CustomArrayList<T> implements CustomList<T> {
	private Object[] items = new Object[10];
	private int size = 0;

	@Override
	public boolean add(T item) {
		if (size == items.length) {
			resizeArray();
		}
		items[size] = item;
		size++;
		return true;
	}
	

	@Override
	public int getSize() {
		
		return size;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
			return (T) items[index];
	}
	

	public Object[] getItems() {
		return items;
	}

	public void setItems(Object[] items) {
		this.items = items;
	}
	
	private void resizeArray() {
		// creates a new array that is double the size of the old array. 
		Object[] newArray = new Object[items.length * 2];
		
		
//		for (int i =0; i < items.length; i++) {
//			newArray[i] = items[i];
//		}
		
		// More efficient way to copy elements from one array to another
		System.arraycopy(items, 0, newArray, 0, items.length);
		items = newArray;
	}

	@Override
	public String toString() {
		return "CustomArrayList [items=" + Arrays.toString(items) + ", size=" + size + "]";
	}
}
