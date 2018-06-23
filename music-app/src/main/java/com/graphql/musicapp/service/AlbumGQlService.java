package com.graphql.musicapp.service;

import java.io.File;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.graphql.musicapp.service.fetcher.AlbumDataFetcher;
import com.graphql.musicapp.service.fetcher.AllAlbumDataFetcher;

import graphql.GraphQL;
import graphql.schema.DataFetcher;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

@Service
public class AlbumGQlService {

	@Value("classpath:album.graphql")
	private Resource resource;
	
	private GraphQL graphQL;
	@Autowired
	private AllAlbumDataFetcher allAlbumsDataFetcher;
	@Autowired
    private AlbumDataFetcher albumDataFetcher;
	
	@PostConstruct
	public void loadSchema() throws IOException{
		File schemaFile = resource.getFile();
		TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemaFile);
		RuntimeWiring wiring = buildRuntimeWiring();
		GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
		
		graphQL = GraphQL.newGraphQL(schema).build();
	}

	private RuntimeWiring buildRuntimeWiring() {
		
		return	RuntimeWiring.newRuntimeWiring()
			.type("Query",typeWiring->typeWiring
				.dataFetcher("allAlbums", allAlbumsDataFetcher)
				.dataFetcher("album",albumDataFetcher)
			)
			.build();
		
	}
	
	public GraphQL getGraphQL(){
		return this.graphQL;
	}
	
}
