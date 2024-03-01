package sku.mvc.dto;

import java.util.List;

;

public class Animals {
	private String name;
	private String gender;
	private String spicies;
	private String habit;
	private String animal;
	
	
	public Animals() {}

	public Animals(String name, String gender, String spicies, String habit, String animal) {
		super();
		this.name = name;
		this.gender = gender;
		this.spicies = spicies;
		this.habit = habit;
		this.animal = animal;

	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSpicies() {
		return spicies;
	}

	public void setSpicies(String spicies) {
		this.spicies = spicies;
	}

	public String getHabit() {
		return habit;
	}

	public void setHabit(String habit) {
		this.habit = habit;
	}

	public String getAnimal() {
		return animal;
	}

	public void setAnimal(String animal) {
		this.animal = animal;
	}


	
	
	
	


	
}
