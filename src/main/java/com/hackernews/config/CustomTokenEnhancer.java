package com.hackernews.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import com.hackernews.user.CustomUserDetails;


public class CustomTokenEnhancer implements TokenEnhancer {

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        final Map<String, Object> additionalInfo = new HashMap<>();
        additionalInfo.put("user", userDetails);

       // additionalInfo.put("id", userDetails.getId());
       // additionalInfo.put("email", userDetails.getUsername());
 
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
 
        return accessToken;
	}

}
