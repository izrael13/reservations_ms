package com.izrael.gatewayserver.config;

import java.util.Collection;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RoleKeycloakConverter implements Converter<Jwt, Collection<GrantedAuthority>>{

	@Override
	public Collection<GrantedAuthority> convert(Jwt source) {
		Map<String, Object> realmAccess = (Map<String, Object>) source.getClaims().get("resource_access");
        if (realmAccess == null || realmAccess.isEmpty()) {
            return new ArrayList<>();
        }
        
        Map<String, Object> bookingmAccess = (Map<String, Object>) realmAccess.get("bookingapp");
        
        Collection<GrantedAuthority> returnValue = ((List<String>) bookingmAccess.get("roles") )
                .stream().map(roleName -> "ROLE_" + roleName)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        return returnValue;
	}

}
