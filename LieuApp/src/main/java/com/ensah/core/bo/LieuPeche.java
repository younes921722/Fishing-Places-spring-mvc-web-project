package com.ensah.core.bo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "lieupeche",
uniqueConstraints = {@UniqueConstraint(columnNames = {"localisation", "profondeur"})})
public class LieuPeche {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		@NotBlank(message = "This field is required")
		private String localisation;
		
		@NotNull
		@Positive(message = "Invalid depth. Value should be positive.")
		private Long profondeur;

		@Override
		public String toString() {
			return "LieuPeche [id=" + id + ", localisation=" + localisation + ", profondeur=" + profondeur
					+ "]";
		}

		public Long getId() {
			return id;
		}

		public void setId(Long idContact) {
			this.id = idContact;
		}

		public String getLocalisation() {
			return localisation;
		}

		public void setLocalisation(String localisation) {
			this.localisation = localisation;
		}

		public Long getProfondeur() {
			return profondeur;
		}

		public void setProfondeur(Long profondeur) {
			this.profondeur = profondeur;
		}

		



	}
