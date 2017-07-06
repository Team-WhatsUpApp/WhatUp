package com.whatsup.repositories;

import com.whatsup.models.Location;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by mosesfranco on 7/6/17
 * Codeup
 * Pinnacles
 */
public interface LocationsRepository extends CrudRepository<Location, Long> {
}
