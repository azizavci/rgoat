package com.rzk.RitzyGoat.business.abstracts;

import java.util.List;

import com.rzk.RitzyGoat.core.utilities.results.DataResult;
import com.rzk.RitzyGoat.core.utilities.results.Result;
import com.rzk.RitzyGoat.entities.concretes.Customer;

public interface CustomerService {

	DataResult<List<Customer>> getAll();

	Result add(Customer customer);

	DataResult<Customer> getById(Long id);

}
