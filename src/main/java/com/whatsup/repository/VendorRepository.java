package com.whatsup.repository;

import com.whatsup.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by DelMonroe on 7/10/17.
 */
@Repository
public interface VendorRepository extends JpaRepository<Vendor, Long> {
}
