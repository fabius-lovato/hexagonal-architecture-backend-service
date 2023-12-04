package com.fabius.hexagonalsrv.application.core.domain;

public class Customer {

    public Customer() {
        this.isValidCpf = false;
    }

    public Customer(String id, String name, Address address, String cpf, Boolean isValidCpf) {
        this.setId(id);
        this.setName(name);
        this.setAddress(address);
        this.setCpf(cpf);
        this.setIsValidCpf(isValidCpf);
    }

    private String id;

    private String name;

    private Address address;

    private String cpf;

    private Boolean isValidCpf;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Boolean getIsValidCpf() {
		return isValidCpf;
	}

	public void setIsValidCpf(Boolean isValidCpf) {
		this.isValidCpf = isValidCpf;
	}


}
