package com.capstone.moviechaska.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="movieslist")
public class MoviesList {

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private long id;
		
		@Column
		private String movName;
		
		@Column
		private String movDesc;
		
		@Column
		private String movRel;
		
		@Column
		private double movPrice;

		// Constructor 
		public MoviesList( String name, String description, String release, double price) {
			this.movName = name;
			this.movDesc = description;
			this.movRel = release;
			this.movPrice=price;
		}

		public MoviesList() { }

		// getter & setter methods
		
		
		public String getMovName() {
			return movName;
		}

		public long getId() {
			return id;
		}

		public void setMovName(String movName) {
			this.movName = movName;
		}

		public String getMovDesc() {
			return movDesc;
		}

		public void setMovDesc(String movDesc) {
			this.movDesc = movDesc;
		}

		public String getMovRel() {
			return movRel;
		}

		public void setMovRel(String movRel) {
			this.movRel = movRel;
		}

		public double getMovPrice() {
			return movPrice;
		}

		public void setMovPrice(double movPrice) {
			this.movPrice = movPrice;
		}

		@Override
		public String toString() {
			return "MoviesList [id=" + id + ", movName=" + movName + ", movDesc=" + movDesc + ", movRel=" + movRel
					+ ", movPrice=" + movPrice + "]";
		}
		
		
			
}
