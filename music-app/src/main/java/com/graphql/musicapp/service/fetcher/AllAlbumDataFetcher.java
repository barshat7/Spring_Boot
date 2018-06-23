package com.graphql.musicapp.service.fetcher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.graphql.musicapp.model.Album;
import com.graphql.musicapp.repository.AlbumRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class AllAlbumDataFetcher implements DataFetcher<List<Album>> {

	@Autowired
	private AlbumRepository albumRepository;
	
	@Override
	public List<Album> get(DataFetchingEnvironment arg0) {
		
		return albumRepository.findAll();
	}

}
