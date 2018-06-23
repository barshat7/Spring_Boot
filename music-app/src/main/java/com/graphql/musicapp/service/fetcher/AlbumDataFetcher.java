package com.graphql.musicapp.service.fetcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.graphql.musicapp.model.Album;
import com.graphql.musicapp.repository.AlbumRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class AlbumDataFetcher implements DataFetcher<Album> {

	@Autowired
	private AlbumRepository albumRepository;
	
	@Override
	public Album get(DataFetchingEnvironment dataFetch) {
		
		String id = dataFetch.getArgument("id");
		return albumRepository.findById(id).get();
	}

}
