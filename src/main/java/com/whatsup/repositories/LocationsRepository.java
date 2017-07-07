package com.whatsup.repositories;

import com.whatsup.models.Location;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by mosesfranco on 7/6/17
 * Codeup
 * Pinnacles
 */
@Repository
public interface LocationsRepository extends CrudRepository<Location, Long> {
//
//	@Query("call getLocations(?1, ?2, ?3)")
//	public List<String> getLocationsMap(String lat, String lon, String point);

	@Procedure(name = "getLocations")
	public List<String> getLocationsMap(@Param("lat") String lat, @Param("lon") String lon, @Param("point") String point);

}
