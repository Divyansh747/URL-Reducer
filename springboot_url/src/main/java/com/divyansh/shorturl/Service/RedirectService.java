package com.divyansh.shorturl.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.divyansh.shorturl.Exception.NotFoundException;
import com.divyansh.shorturl.Exception.RequestException;
import com.divyansh.shorturl.Repository.RedirectEntity;
import com.divyansh.shorturl.Repository.RedirectRepository;
import com.divyansh.shorturl.Request.RedirectRequest;

@Service
public class RedirectService {
	
	private RedirectRepository redirectRepository;

	@Autowired
	public RedirectService(RedirectRepository redirectRepository) {
		
		this.redirectRepository = redirectRepository;
	}
	
	public Optional<RedirectEntity> createRedirect(RedirectRequest redirectRequest){
		
		if(redirectRepository.existsByAlias(redirectRequest.getAlias())) {
			throw new RequestException("Alias exists");
		}
		System.out.println("Redirect request : " + redirectRequest.toString());
		RedirectEntity redirectEntity = redirectRepository.save(new RedirectEntity(redirectRequest.getAlias(), redirectRequest.getUrl()));
		
		return Optional.ofNullable(redirectEntity);
	}
	
	public Optional<RedirectEntity> createRedirect(RedirectEntity redirectRequest){
		
		if(redirectRepository.existsByAlias(redirectRequest.getAlias())) {
			throw new RequestException("Alias exists");
		}
		System.out.println("Redirect request : " + redirectRequest.toString());
		RedirectEntity redirectEntity = redirectRepository.save(new RedirectEntity(redirectRequest.getAlias(), redirectRequest.getUrl()));
		
		return Optional.ofNullable(redirectEntity);
	}
	
	public RedirectEntity getRedirect(String alias){
		RedirectEntity redirectEntity = redirectRepository.findByAlias(alias)
				.orElseThrow(() -> new NotFoundException("Alias not found, Try to create new one!"));
		return redirectEntity;
		}
	
}
