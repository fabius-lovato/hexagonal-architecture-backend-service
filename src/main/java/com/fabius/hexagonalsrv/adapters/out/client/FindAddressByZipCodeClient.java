package com.fabius.hexagonalsrv.adapters.out.client;

import com.fabius.hexagonalsrv.adapters.out.client.response.AddressResponse;

import feign.Headers;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "FindAddressByZipCodeClient", url = "https://viacep.com.br/ws/")
public interface FindAddressByZipCodeClient {

	@GetMapping("/{zipCode}/json/")
	@Headers({
	          "Origin: https://digitaismidias.com.br",
	          "Referer: https://digitaismidias.com.br/",
	          "Host: viacep.com.br"
	})
    AddressResponse find(@PathVariable("zipCode") String zipCode);

}
