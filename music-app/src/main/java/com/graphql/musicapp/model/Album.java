package com.graphql.musicapp.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Album {

	@Id 
	private String id;
	private String name;
	private String genre;
	private String artist;
	private String releaseDate;
	private String[] songList;
}
