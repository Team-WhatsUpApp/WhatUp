package com.whatsup.repositories;

import com.whatsup.models.User;
import com.whatsup.models.Vendor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mosesfranco on 7/6/17
 * Codeup
 * Pinnacles
 */
@Repository
public interface VendorsRepository extends CrudRepository<Vendor, Long>{
	public Vendor findById(long id);

	public Vendor findByOwner(User owner);
}
