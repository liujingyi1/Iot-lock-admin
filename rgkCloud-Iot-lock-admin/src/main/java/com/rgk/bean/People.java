package com.rgk.bean;

import java.util.List;

public class People {
	
	Data data;
	String status;
	
	public class Data {
		Person person;

		public Person getPerson() {
			return person;
		}

		public void setPerson(Person person) {
			this.person = person;
		}
	}
	
	public class Person {
		String created_at;
		String updated_at;
		String name;
		String phone;
		String email;
		String age;
		String gender;
		String person_uuid;
		List<Image> images;
		public String getCreated_at() {
			return created_at;
		}
		public void setCreated_at(String created_at) {
			this.created_at = created_at;
		}
		public String getUpdated_at() {
			return updated_at;
		}
		public void setUpdated_at(String updated_at) {
			this.updated_at = updated_at;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getAge() {
			return age;
		}
		public void setAge(String age) {
			this.age = age;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getPerson_uuid() {
			return person_uuid;
		}
		public void setPerson_uuid(String person_uuid) {
			this.person_uuid = person_uuid;
		}
		public List<Image> getImages() {
			return images;
		}
		public void setImages(List<Image> images) {
			this.images = images;
		}
		
	}
	
	public class Image {
		String created_at;
		String image_uuid;
		String width;
		String height;
		String image_url;
		List<Face> faces;
		public String getCreated_at() {
			return created_at;
		}
		public void setCreated_at(String created_at) {
			this.created_at = created_at;
		}
		public String getImage_uuid() {
			return image_uuid;
		}
		public void setImage_uuid(String image_uuid) {
			this.image_uuid = image_uuid;
		}
		public String getWidth() {
			return width;
		}
		public void setWidth(String width) {
			this.width = width;
		}
		public String getHeight() {
			return height;
		}
		public void setHeight(String height) {
			this.height = height;
		}
		public String getImage_url() {
			return image_url;
		}
		public void setImage_url(String image_url) {
			this.image_url = image_url;
		}
		public List<Face> getFaces() {
			return faces;
		}
		public void setFaces(List<Face> faces) {
			this.faces = faces;
		}
		
	}
	
	public class Face {
		String created_at;
		String face_uuid;
		String face_feature;
		public String getCreated_at() {
			return created_at;
		}
		public void setCreated_at(String created_at) {
			this.created_at = created_at;
		}
		public String getFace_uuid() {
			return face_uuid;
		}
		public void setFace_uuid(String face_uuid) {
			this.face_uuid = face_uuid;
		}
		public String getFace_feature() {
			return face_feature;
		}
		public void setFace_feature(String face_feature) {
			this.face_feature = face_feature;
		}
		
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
