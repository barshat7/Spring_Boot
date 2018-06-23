package com.graphql.musicapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.graphql.musicapp.model.Album;

public interface AlbumRepository extends JpaRepository<Album,String> {

}
